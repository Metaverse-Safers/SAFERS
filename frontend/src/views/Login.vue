<template>
    <div class="login-background">
        <div>
            <router-link to=/><img class="home-btn" src="@/assets/images/homeBtn.png"></router-link>
        </div>
        <img class="login-btn" src="@/assets/images/loginImg.png">
        <img class="kakao-login" src='@/assets/images/kakaoLogin.png' @click="kakaoLogin">
    </div>
</template>

<script>
    export default {
    name: "Login",
    methods: {
        kakaoLogin() {
        this.$kakao.Auth.authorize({
            //redirectUri: "https://localhost:8081/login/callback" // 8081: frontend, 8080: backend로 두고 테스트함.
            redirectUri: "https://k5a403.p.ssafy.io/login/callback", //배포용
        });
        },
    }
}
</script>

<style>
.login-background {
  background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280f36);
  background-size: 160% 160%;
  -webkit-animation: gradient 10s ease infinite;
  animation: gradient 10s ease infinite;
  width: 100vw;
  height: 100vh;
}
.home-btn {
  margin: 3.5vh;
  width: 14vh;
  height: 3vh;
  float: left;
}
.login-btn {
  width: 70vh;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.kakao-login {
  width: 35vh;
  position: absolute;
  top: 68%;
  left: 50%;
  transform: translate(-50%, -50%);
  cursor: pointer;
}
@keyframes gradient {
  0% { background-position: 0% 50%; }
  50% { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}
@-webkit-keyframes gradient {
  0% { background-position: 0% 50%; }
  50% { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}
</style>
