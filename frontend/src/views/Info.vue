<template>
  <div class="header-float nexon-font">
    
    <div id="info-header" class="site-header sticky-top py-1">
      <nav class="container d-flex flex-column flex-md-row justify-content-between">
        <div class="imb-font-semi-bold">
          <img class="info-header-logo" src="@/assets/images/logo-row.png" alt="" @click="current = 'Main'">
        </div>
        <div class="info-nav-menu">
          <p @click="current = 'Main'">소개</p>
          <p @click="current = 'Survey'">성격유형검사</p>
          <p @click="current = 'Team'">개발팀</p>
          <p><button type="button" class="btn btn-outline-primary" @click="clickMain">메인으로 돌아가기</button></p>
        </div>
      </nav>
    </div>
    <component :is="current"></component>
    <Footer></Footer>
  </div>
</template>

<script>
  import Main from "../components/Info/InfoMain.vue";
  import Footer from "../components/Info/InfoFooter.vue";
  import Survey from "../components/Info/InfoSurvey.vue";
  import Team from "../components/Info/InfoTeam.vue";

  export default {
    name: "Info",
    components: {
      Main, Survey, Team, Footer
    },
    data(){
      return {
        current: 'Main'
      }
    }, methods:{
      clickMain(){
        this.$router.push("/");
      }
    }
  };
</script>

<style>
  .site-header {
    /* background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280f36); */
    background: #E8FAFF;
    -webkit-backdrop-filter: saturate(180%) blur(20px);
    backdrop-filter: saturate(180%) blur(20px);
    opacity: 0.9;
  }
  .info-header-logo{
    height: 60px;
  }
  .info-header-logo:hover{
    filter: brightness(80%);
    cursor: pointer;
  }
  .info-nav-menu {
    padding-top: 13px;
  }
  .info-nav-menu > p{
    color: #000000;
    transition: color 0.15s ease-in-out;
    display: inline-block;
    margin-left: 20px;
  }
  .info-nav-menu > p:hover{
    filter: brightness(80%);
    cursor: pointer;
  }
</style>