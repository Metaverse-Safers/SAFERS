<template>
  <div style="dispaly:relative">
    <div class="wave-div">
      <div class="wave"></div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.wave-div {
  width: 1000px;
  height: 500px;
  position: relative;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  border-radius: 5px;
  background-image: linear-gradient(to top, #accbee 0%, #e7f0fd 100%);
  overflow: hidden;
}

.wave {
  width: 2000px;
  height: 1800px;
  position: absolute;
  top: -25%;
  left: 50%;
  margin-left: -500px;
  margin-top: -500px;
  border-radius: 35%;
  background: rgba(255, 255, 255, .75);
  animation: wave 15s infinite linear;
}

@keyframes wave {
  from { transform: rotate(0deg);}
  from { transform: rotate(360deg);}
}

</style>