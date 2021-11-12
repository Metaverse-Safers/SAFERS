<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#4</b><br>
        아픈 것이 사라졌습니다. <br>
        곧 노을이 질 시간이네요.<br>
        <mark>무엇을 하러갈까요?</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(1)">해가 진다고?! 저녁 식사 챙겨 먹어야지~</button>
      <button class="btn btn-outline-answer" @click="next(-2)">와 이쁘다! 경치 좋은 곳에서 노을 구경하고 가야겠다.</button>
      <button class="btn btn-outline-answer" @click="next(2)">앗 햇빛! 눈부셔!! 선글라스 사러갈까?</button>
      <button class="btn btn-outline-answer" @click="next(-1)">이왕 쉬는 김에 쉬던 이 자리에서 여유를 즐기자</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page4",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page05', index:3, data: data });
    }
  },
}
</script>

<style>

</style>