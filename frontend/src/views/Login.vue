<template>
    <div id='loginBackGround'>
        <div id='loginWrap'>
            <img id='loginQM' src="@/assets/images/questionMark.png">
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
            /*if (!Kakao.isInitialized()) {
                //Kakao.init("2920ed8322509d97bcdb698cad022b10");
                Kakao.init("87b730a1b8865066cd4a4aba71a23371"); // 상훈 key
            }
            Kakao.Auth.authorize({
            redirectUri: "http://localhost:8080/login/callback"
            //redirectUri: "https://k5a403.p.ssafy.io/login/callback" //배포용
            });*/
            window.Kakao.Auth.login({
                scope: 'profile_nickname, profile_image, account_email',
                success: this.getProfile
            });
        },
        getProfile(authObj) {
            console.log(authObj);
            window.Kakao.API.request({
                url: '/v2/user/me',
                success: res => {
                    const kakao_account = res.kakao_account;
                    console.log(kakao_account);
                    alert('로그인 성공');
                    this.$router.push('/')
                }
            });
        }
    },
}
</script>

<style>
    #loginBackGround{
        background-image: url('../assets/images/background.png');
        background-size: cover;
        background-repeat: no-repeat;
    }
    #loginWrap{
        display: flex;
        justify-content: space-between;
        height: 10vh; 
    }
    #loginQM{
        margin: 3vh;
        width: 5vh;
        height: 5vh;
    }
    #home{
        margin: 3.5vh;
        width: 15vh;
        height: 3.5vh;
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
</style>