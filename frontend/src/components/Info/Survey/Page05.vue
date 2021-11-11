<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#5</b><br>
        하고싶은 일도 했고, 벌써 밤이 깊었습니다.<br>
        새로운 삶을 고민할 수 있는 하루가 벌써 저물어 가네요. <br>
        <mark>이렇게 잠들기엔 아쉬우니 무엇을 할까요?</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(-1)">바닷소리가 들리는 모래사장을 산책하기</button>
      <button class="btn btn-outline-answer" @click="next(1)">향긋한 향이 가득한 카페에서 따뜻한 음료 마시기</button>
      <button class="btn btn-outline-answer" @click="next(2)">반짝이는 조명으로 둘러진 칵테일 바에서 한잔하기</button>
      <button class="btn btn-outline-answer" @click="next(-2)">따뜻하게 반신욕을 하며 오늘 있었던 일 되새기기</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page5",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page06', index:0, data: data });
    }
  },
}
</script>

<style>

</style>