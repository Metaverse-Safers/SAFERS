import axios from 'axios';
import store from '@/store';

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
      console.log(store.getters["user/token"].accessToken);
      config.headers.common["Authorization"] = store.getters["user/token"].accessToken;
    }
    return config;
  },
  error => {
    Promise.reject(error);
  }
)

// 로그인이 정상적으로 되어있지 않다면
http.interceptors.response.use((response) => response, (error) => {
  console.log(error.response.data);

  if(error.response.data.status == 400){
    alert("로그인이 필요합니다!");
  }

  throw error;
})

export default http;
