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
    { path: '/register', name: 'register', component: () => import("@/views/Register.vue") },

    // world 페이지
    { path: '/world', name: 'world', component: () => import("@/views/World.vue") },

    // information 페이지
    { path: '/info', name: 'info', component: () => import("@/views/Info.vue") }

  ]
})

route.afterEach((to) => {
  // 월드에서 나온 경우
  if(store.getters["user/path"] == "/world"){
    store.commit("user/SET_IS_DESTROYED", true);
  }else{
    store.commit("user/SET_IS_DESTROYED", false);
  }
  // 이동한 PATH 저장
  store.commit("user/SET_PATH", to.path);
})

export default route;