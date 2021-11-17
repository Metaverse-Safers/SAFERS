<template>
  <div class="unity-div">
    <Menu></Menu>
    <unity
      class="unity-screen"
      src="./unity/Build/Build.json"
      unityLoader="./unity/Build/UnityLoader.js"
      ref="hookInstance"
      v-bind="{hideFooter: true}"
    ></unity>
  </div>
</template>

<script>
import Unity from "vue-unity-webgl";
import Menu from "../components/SideMenu.vue";

export default {
  name: "World",
  components: { Unity, Menu },
  data() {
    return {
      unityWidth: "",
      unityHeight: "",
    };
  },
  mounted() {
    this.handleResize();
    window.addEventListener("resize", this.handleResize);

    // 게임화면 이동시 connect valid
    localStorage.setItem("homeValid", 0);
  
    // 뒤로가기 혹은, 다른 페이지로 넘어가기 전 거쳐가는 함수
    this.$router.beforeEach(function(to, from, next) {
      console.log(to +"에서" + from + "으로 가기전!" + next);  
    });
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.handleResize);
  },
  methods: {
    handleResize() {
      this.unityWidth = window.innerWidth * 0.5;
      this.unityHeight = window.innerHeight;
      console.log(this.unityWidth);
    },
  },
};
</script>

<style>
  .unity-div {
    width: 100vw;
    height: 100vh;
    overflow: hidden;
  }
</style>