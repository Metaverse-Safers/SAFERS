<template>
    <div class="main-backgound">
        <div class="main-nav">
            <router-link to=/info class="router-btn">
              <img class="main-question-mark" src="@/assets/images/questionMark.png">
            </router-link>
            <router-link to=/login v-if="loggedIn" class="router-btn">
              <img class="log-btn" src="@/assets/images/loginBtn.png">
            </router-link>
            <img v-else class="log-btn" src="@/assets/images/logoutBtn.png" @click="clickLogout()">
        </div>
        <div class="main-content" @click="clickStart()">
            <p class="nexon-font">함께 지구별에서 살아가는 친구들을 지켜주세요</p>
            <p class="imb-font-semi-bold">Safers</p>
            <img class="main-logo" src="@/assets/images/logo.png">
            <p class="nexon-font">아무 곳이나 클릭해주세요</p>
        </div>
    </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Main",
  components: {},
  data() {
    return {
      loggedIn: true,
    };
  },
  computed: {
    ...mapGetters({
      userProfile: "user/userProfile",
    }),
    getIsLoggin(){
      return this.$store.getter["user/userProfile"];
    }
  },
  mounted() {
    // 정의되어 있지 않거나 빈 객체이면, 로그인이 되어 있지 않음
    if (
      this.userProfile == undefined ||
      Object.keys(this.userProfile).length != 0
    )
      this.loggedIn = false;
    console.log(this.userProfile);
  },
  methods: {
    clickStart() {
      this.$router.push("/world");
    },
    async clickLogout() {
      await this.$store.dispatch("user/requestLogout");
      let isLogin = this.$store.getters["isAuthenticated"];
      if(isLogin == undefined || isLogin == false){
        this.loggedIn = true;
        this.$alert( "다음에 또 놀러오세요!", "로그아웃", "success")
        .then(() => console.log("Closed"));
      } else {
        this.loggedIn = false;
        this.$alert( "문제가 생겼어요!", "로그아웃", "warning")
        .then(() => console.log("Closed"));
      }
    },
  },
  watch:{
    getIsLoggin(){
      console.log(this.loggedIn);
    }
  }
};
</script>

<style>
.log-btn {
  margin: 3vh;
  width: 14vh;
  height: 4.5vh;
  cursor: pointer;
}
.main-backgound {
  width: 100vw;
  height: 100vh;
  background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280f36);
  background-size: 160% 160%;
  -webkit-animation: gradient 10s ease infinite;
  animation: gradient 10s ease infinite;
  overflow: hidden;
}
.main-content {
  height: 90%;
}
.main-content > p {
  cursor: default;
}
.main-content > p:nth-child(1) {
  color: white;
  font-size: 2.5vh;
  position: absolute;
  top: 22%;
  left: 50%;
  transform: translate(-50%, -50%);
  -webkit-animation: focus-in-expand 3s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation: focus-in-expand 3s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
}
.main-content > p:nth-child(2) {
  color: white;
  font-size: 12vh;
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.main-content > p:last-child{
  color: white;
  font-size: 2vh;
  position: absolute;
  top: 78%;
  left: 50%;
  transform: translate(-50%, -50%);
  -webkit-animation: fadein 3s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  -webkit-animation-delay: 3s;
  animation: fadein 3s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation-delay: 3s;
}
.main-logo {
  width: 35vh;
  position: absolute;
  top: 55%;
  left: 50%;
  transform: translate(-50%, -50%);
  animation: circlemove 1.5s infinite linear;
}
.main-nav {
  display: flex;
  justify-content: space-between;
  height: 10%;
}
.main-question-mark {
  margin: 3vh;
  width: 4.5vh;
  height: 4.5vh;
  cursor: pointer;
}
.router-btn{
  height: 10vh;
}
@keyframes circlemove {
  0%, 100% { transform: translate(-50%, -50%); }
  50% { transform: translate(-50%, -52%); }
}
@-webkit-keyframes focus-in-expand {
  0% {
    letter-spacing: -0.5em;
    -webkit-filter: blur(12px);
    filter: blur(12px);
    opacity: 0;
  }
  100% {
    -webkit-filter: blur(0px);
    filter: blur(0px);
    opacity: 1;
  }
}
@keyframes focus-in-expand {
  0% {
    letter-spacing: -0.5em;
    -webkit-filter: blur(12px);
    filter: blur(12px);
    opacity: 0;
  }
  100% {
    -webkit-filter: blur(0px);
    filter: blur(0px);
    opacity: 1;
  }
}
@keyframes fadein {
  from { opacity: 0; }
  to { opacity: 1; }
}
@-webkit-keyframes fadein {
  /* Safari and Chrome */
  from { opacity: 0; }
  to { opacity: 1; }
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