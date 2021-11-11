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