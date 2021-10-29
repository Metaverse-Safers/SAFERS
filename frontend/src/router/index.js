import vue from 'vue'
import router from 'vue-router'

vue.use(router)

export default new router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: 'main',
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
                {
                    path: 'mypage',
                    name: 'mypage',
                    component: () => import("@/views/MyPage.vue")
                }
            ]
        },
        {
            path: '/main',
            name: 'main',
            component: () => import("@/views/Main.vue")
        },
        {
            path: '/login',
            name: 'login',
            component: () => import("@/views/Login.vue")
        }
    ]
        
})