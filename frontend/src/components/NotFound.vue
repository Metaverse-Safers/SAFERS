<template>
    <div class="nexon-font container-fluid notfound card">
        <div id="info-header" class="site-header sticky-top py-1 header-padding">
            <div class="imb-font-semi-bold">
                <img class="info-header-logo" src="@/assets/images/logo-row.png" alt="" @click="clickMain">
            </div>
        </div>
        <div class="card text-center notfound-card">
            <div class ="card-body">
                <div>
                    <img src="@/assets/images/404-image.png" width="50%" class="rounded mx-auto d-block card-img-top">
                </div>
                
                <h3 class="card-text"><b><font color="red">🚫</font> 접근할 수 없어요 <font color="red">🚫</font></b></h3>
                <div class="main-div">
                    <button type="button" class="btn btn-outline-primary" @click="clickMain">메인으로 돌아가기</button>
                </div>
            </div>
        </div>
        
    </div>
</template>
<script>
export default {
    name: "NotFound",
    components: {},
    data(){
      return {
        
      }
    }, 
    methods:{
      clickMain(){
        this.$router.push("/");
      }
    }
  };
</script>
<style scoped>
 .notfound {
     padding: 0px;
 }
 .notfound-card {
    width: 50%;
    align-self: center;
 }
 .card {
     border: none;
 }
 .site-header {
    /* background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280f36); */
    background: #E8FAFF;
    -webkit-backdrop-filter: saturate(180%) blur(20px);
    backdrop-filter: saturate(180%) blur(20px);
    opacity: 0.9;
  }
  .header-padding {
      padding: 15px;
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
  .main-div {
    margin-top: 30px;
  }
</style>
