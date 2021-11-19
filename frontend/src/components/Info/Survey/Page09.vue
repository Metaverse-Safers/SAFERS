<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#9</b><br>
        "두번째, 인간의 삶을 살 때의 <mark>소중한 사람들</mark>한테 전하고 싶은 말이 있니?"
      </div>
      <button class="btn btn-outline-answer" @click="next(-2)">보험, 비상금 등의 현실적인 도움을 알려주세요.</button>
      <button class="btn btn-outline-answer" @click="next(1)">"함께 해서 재밌었고 즐거웠다"고 진심을 전달해주세요.</button>
      <button class="btn btn-outline-answer" @click="next(-1)">연락하지 못한 고마운 사람들께 연락을 부탁해주세요.</button>
      <button class="btn btn-outline-answer" @click="next(2)">"너무 슬퍼하지 마"라고 위로의 말을 전달해주세요.</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page9",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page10', index:1, data: data });
    }
  },
}
</script>

<style>

</style>