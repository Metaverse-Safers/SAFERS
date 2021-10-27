<template>
    <div id='main'>
        <div id='wrap'>
            <img id='qM' src="@/assets/images/questionMark.png">
            <router-link to=/><img id='home' src="@/assets/images/homeBtn.png"></router-link>
        </div>
        <img id='img' src="@/assets/images/loginImg.png">
        <img id='kakaoLogin' src='@/assets/images/kakaoLogin.png' @click="clickLogin">
    </div>
</template>

<script>
export default{
    methods: {
        clickLogin(){
            if (!Kakao.isInitialized()) {
                Kakao.init("2920ed8322509d97bcdb698cad022b10");
            }
            Kakao.Auth.authorize({
            redirectUri: "http://localhost:8081/login/callback"
            //redirectUri: "https://k5a403.p.ssafy.io/login/callback" //배포용
            });
        } 
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