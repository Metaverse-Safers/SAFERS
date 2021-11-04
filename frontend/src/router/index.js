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
            path: '/',
            component: () => import("@/components/Common/SideBar.vue"),
            children:[
                {
                    path: 'unity',
                    name: 'unity',
                    component: () => import("@/views/Unity.vue")
                },
                {
                    path: 'mypage',
                    name: 'mypage',
                    component: () => import("@/views/MyPage.vue")
                },
                {
                    path: 'board',
                    name: 'board',
                    component: () => import("@/views/Board.vue")
                },
                {
                    path: 'board/boarddetail',
                    name: 'boarddetail',
                    component: () => import("@/components/Board/BoardDetail.vue")
                },
                {
                    path: 'board/boardwrite',
                    name: 'boardwrite',
                    component: () => import("@/components/Board/BoardWrite.vue")
                },
                {
                    path: 'personality',
                    name: 'personality',
                    component: () => import("@/views/Personality.vue")
                },
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: () => import("@/views/Login.vue")
        },
        {
            path: '/login/callback',
            name: 'kakaoCallback',
            component: () => import("@/components/User/KakaoCallback.vue")
        },
        {
            path: '/register',
            name: 'register',
            component: () => import("@/views/Register.vue")
        },
    ]
        
})