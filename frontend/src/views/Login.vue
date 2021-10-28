<template>
    <div id='main'>
        <div id='wrap'>
            <img id='qM' src="@/assets/images/questionMark.png">
            <router-link to=/><img id='home' src="@/assets/images/homeBtn.png"></router-link>
        </div>
        <img id='img' src="@/assets/images/loginImg.png">
        <img id='kakaoLogin' src='@/assets/images/kakaoLogin.png' @click="kakaoLogin">
    </div>
</template>

<script>
export default{
    methods: {
        kakaoLogin(){
            this.$kakao.Auth.authorize({
            redirectUri: "https://localhost:8081/login/callback" // 8081: frontend, 8080: backend로 두고 테스트함.
            //redirectUri: "https://localhost:8080/login/callback" // 8080: frontend와 backend로 두고 테스트함.
            //redirectUri: "https://k5a403.p.ssafy.io/login/callback" //배포용
            });
        },
    },
}
</script>

<style>
    #main{
        background-image: url('../assets/images/background.png');
        background-size: cover;
        background-repeat: no-repeat;
    }
    #wrap{
        display: flex;
        justify-content: space-between;
        height: 10vh; 
    }
    #qM{
        margin: 3vh;
        width: 5vh;
        height: 5vh;
    }
    #home{
        margin: 3.5vh;
        width: 15vh;
        height: 3.5vh;
    }
    #img{
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
</style>