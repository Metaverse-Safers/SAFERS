<template>
    <div id='loginBackGround'>
        <div id='loginWrap'>
            <router-link to=/main><img id='home' src="@/assets/images/homeBtn.png"></router-link>
        </div>
        <img id='loginImg' src="@/assets/images/loginImg.png">
        <img id='kakaoLogin' src='@/assets/images/kakaoLogin.png' @click="kakaoLogin">
    </div>
</template>

<script>
export default{
    methods: {
        kakaoLogin(){
            this.$kakao.Auth.authorize({
            // redirectUri: "https://localhost:8081/login/callback" // 8081: frontend, 8080: backend로 두고 테스트함.
            redirectUri: "https://k5a403.p.ssafy.io/login/callback" //배포용
            });
        },
    },
    computed: {
        userProfile(){
            return this.$store.state.user.userProfile;
        },
        isAuthenticated(){
            return this.$store.state.user.isAuthenticated;
        }
    },
    mounted(){
        console.log(this.isAuthenticated)
    }
}
</script>

<style>
    #loginBackGround{
        /* background-image: url('../assets/images/background.png');
        background-size: cover;
        background-repeat: no-repeat; */
        background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280F36);
        background-size: 160% 160%;
        animation: gradient 10s ease infinite;
    }
    #loginQM{
        margin: 3vh;
        width: 5vh;
        height: 5vh;
    }
    #home{
        margin: 3.5vh;
        width: 14vh;
        height: 3vh;
        float: right;
    }
    #loginImg{
        width: 70vh;
        position:absolute;
        top:50%; left:50%;
        transform: translate(-50%, -50%);
    }
    #kakaoLogin{
        width: 35vh;
        position:absolute;
        top:68%; left:50%;
        transform: translate(-50%, -50%);
        cursor: pointer;
    }
    @keyframes gradient {
        0% {
            background-position: 0% 50%;
        }
        50% {
            background-position: 100% 50%;
        }
        100% {
            background-position: 0% 50%;
        }
    }
    @-webkit-keyframes gradient {
        0% {
            background-position: 0% 50%;
        }
        50% {
            background-position: 100% 50%;
        }
        100% {
            background-position: 0% 50%;
        }
    }
</style>