<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#6</b><br>
        푹 잠들었다가 어느 순간 자연스레 깼습니다.<br>
        <mark>어떤 시간에 일어났을까요?</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(-1)">아직 깜깜하고 고요한 새벽</button>
      <button class="btn btn-outline-answer" @click="next(1)">해가 어스름하게 피어나는 이른 아침</button>
      <button class="btn btn-outline-answer" @click="next(2)">새가 지저귀는 반짝이는 아침</button>
      <button class="btn btn-outline-answer" @click="next(-2)">피로감은 하나도 남지않은 해가 쨍쨍한 대낮</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page6",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page07', index:3, data: data });
    }
  },
}
</script>

<style>

</style>