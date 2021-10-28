import axios from 'axios';
import store from '@/store';
import router from '@/router';

const http = axios.create({
  baseURL: "/api",
  headers: {
    "Access-Control-Allow-Origin": "*",
    "Content-Type": "application/json; charset = utf-8",
  },
})

http.interceptors.request.use(
  config => {
    const isAuthenticated = store.getters["user/isAuthenticated"];
    if(isAuthenticated){
      config.headers.common["authorization"] = store.getters["user/token"].accessToken;
    }
    return config;
  },
  error => {
    Promise.reject(error);
  }
)

// 로그인이 정상적으로 되어있지 않다면
http.interceptors.response.use((response) => response, async (error) => {
  console.log(error.response.data);

  if(error.response.data.status == 401){
    const isAuthenticated = store.getters["user/isAuthenticated"]; 

    if(!isAuthenticated){
      alert("로그인이 필요합니다!");
      router.push({ name: 'login' });
    }
    else{
      // accessToken 만료 시, 다시 토큰 발급받아서 재요청
      const originalRequest = error.config;
      const refreshToken = store.getters["user/token"].refreshToken;
      await store.dispatch("user/refreshToken", { "refreshToken" : refreshToken});

      return axios(originalRequest)
    }
  }
  else if(error.response.data.status == 500){
    alert("서버에 오류가 발생하였습니다. 다시 시도해주세요.");
  }

  throw error;
})

export default http;
