import vue from 'vue'
import VueRouter from 'vue-router'
import router from 'vue-router'
import store  from '../store'

vue.use(router)

const route = new VueRouter({
  mode: 'history',
  routes: [
    // main 페이지
    { path: '/', name: 'main', component: () => import("@/views/Main.vue") },

    // login 페이지
    { path: '/login', name: 'login', component: () => import("@/views/Login.vue") },
    { path: '/login/callback', name: 'kakaoCallback', component: () => import("@/components/User/KakaoCallback.vue") },

    // register 페이지
    { path: '/register', name: 'register', meta: {requireAuth:true}, component: () => import("@/views/Register.vue") },

    // world 페이지
    { path: '/world', name: 'world', meta: {requireAuth:true}, component: () => import("@/views/World.vue") },

    // information 페이지
    { path: '/info', name: 'info', component: () => import("@/views/Info.vue") }

  ]
})


// URL이 변경되기 전, 호출되는 함수
route.beforeEach((to, from, next) => {
  // 로그인이 필요한 페이지에 들어가기전, 로그인 여부 확인
  if(to.matched.some(record => record.meta.requireAuth)){
    if(!store.getters["user/isAuthenticated"]){ 
      route.push("/login");
    }
  }

  // 월드에서 나온 경우
  if(store.getters["user/path"] == "/world"){
    store.commit("user/SET_IS_DESTROYED", true);
  }else{
    store.commit("user/SET_IS_DESTROYED", false);
  }
  // 이동한 PATH 저장
  store.commit("user/SET_PATH", to.path);
  next();
})

export default route;