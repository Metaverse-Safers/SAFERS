package com.safers.common.handler;

import com.safers.api.service.KakaoService;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KakaoAuthenticationHandler implements HandlerInterceptor {

    private KakaoService kakaoService = new KakaoService();

    /*
    * 인증이 필요한 API에 대해 토근 여부 확인 (실패 시, 401 ERROR 반환)
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = request.getHeader("authorization");

        if(accessToken == null)
            throw new AuthorizationServiceException("로그인이 필요합니다!");

        int responseCode = kakaoService.checkAccessToken(accessToken);
        if(responseCode == 400 || responseCode == 401)
            throw new AuthorizationServiceException("토큰갱신 후 다시 요청해주세요");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        response.setHeader("Access-Control-Expose-Headers", "ETag");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}