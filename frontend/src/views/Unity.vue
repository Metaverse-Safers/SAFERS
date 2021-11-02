<template>
        <unity id='unity' src="./unity/Build/Build.json" width=1000 height=800 unityLoader="./unity/Build/UnityLoader.js" ref="hookInstance"></unity>
</template>

<script>
import Unity from 'vue-unity-webgl';

    export default {
        name : "UnityGame",
        components : {Unity},
        data(){
            return{
                unityWidth:'',
                unityHeight:''
            }
        },
        mounted(){
            this.handleResize();
            window.addEventListener('resize', this.handleResize);
        },
        beforeDestroy() {
          window.removeEventListener('resize', this.handleResize);
        },
        methods: {  
          handleResize() {
              this.unityWidth = window.innerWidth * 0.5
              this.unityHeight = window.innerHeight
              console.log(this.unityWidth)
          }
        }
    }
</script>

<style>
</style>