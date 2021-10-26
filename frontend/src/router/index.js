import vue from 'vue'
import router from 'vue-router'

vue.use(router)

export default new router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'main',
            component: () => import("@/views/Main.vue")
        },
        {
            path: '/login',
            name: 'login',
            component: () => import("@/views/Login.vue")
        },
        {
            path: '/mypage',
            name: 'mypage',
            component: () => import("@/views/MyPage.vue")
        }
    ]
})