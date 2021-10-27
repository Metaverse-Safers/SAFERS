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
                },
                {
                    path: '/board',
                    name: 'board',
                    component: () => import("@/views/Board.vue")
                },
                {
                    path: '/board/boarddetail/:no',
                    name: 'boarddetail',
                    component: () => import("@/components/Board/BoardDetail.vue")
                },
                {
                    path: '/personality',
                    name: 'personality',
                    component: () => import("@/views/Personality.vue")
                },
                {
                    path: '/mypage',
                    name: 'mypage',
                    component: () => import("@/views/MyPage.vue")
                },
                {
                    path: '/sidebar',
                    name: 'sidebar',
                    component: () => import("@/components/Common/SideBar.vue")
                }
            ]
        
})