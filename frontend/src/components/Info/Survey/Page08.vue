<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#8</b><br>
        벌써 새로운 삶을 위한 시간이 왔습니다<br>
        신이 총 3가지의 질문을 합니다.<br>
        <mark>"첫번째, 다시 태어났을 때, 어떤 삶을 살고싶니?"</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(-1)">어떤 일이든 척척 잘해내는 만능꾼</button>
      <button class="btn btn-outline-answer" @click="next(1)">함께하는 사람들과 조화를 이루는 따듯한 사람</button>
      <button class="btn btn-outline-answer" @click="next(-2)">항상 만족스러운 결과를 얻는 승부사</button>
      <button class="btn btn-outline-answer" @click="next(2)">좋은 기운을 줄 수 있는 긍정적인 사람</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page8",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page09', index:2, data: data });
    }
  },
}
</script>

<style>

</style>