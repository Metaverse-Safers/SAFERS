<template>
    <unity src="./unity/Build/Build.json" width="1920" height="1080" unityLoader="./unity/Build/UnityLoader.js" ref="hookInstance"></unity>
</template>

<script>
import Unity from 'vue-unity-webgl';

    export default {
        name : "UnityGame",
        components : {Unity}
    }
</script>