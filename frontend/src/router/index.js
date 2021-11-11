import vue from 'vue'
import router from 'vue-router'

vue.use(router)

export default new router({
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