<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <mark>"마지막으로... 넌 이번 삶은 어땠니?"</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(-1)">재미있었습니다.</button>
      <button class="btn btn-outline-answer" @click="next(1)">만족스러웠습니다.</button>
      <button class="btn btn-outline-answer" @click="next(-2)">행복했습니다.</button>
      <button class="btn btn-outline-answer" @click="next(2)">뿌듯했습니다.</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page10",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'PageResult', index:2, data: data });
    }
  },
}
</script>

<style>

</style>