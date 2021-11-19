<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#3</b><br>
        음식을 먹고 난 후 산책을 나왔습니다.<br>
        먹고 바로 걸으니 옆구리가 아프네요😂<br>
        쉼터에 다양한 가구가 있네요.<br>
        <mark>어떤 곳에서 쉴까요?</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(-1)">와 이게 뭐야! 푹신하고 몸이 쏘옥 들어가는 빈백</button>
      <button class="btn btn-outline-answer" @click="next(1)">아픈데 누워야지! 나무로 만들어진 엔틱한 침대</button>
      <button class="btn btn-outline-answer" @click="next(-2)">아파도 놀러온거니까! 나무 사이에 걸린 해먹</button>
      <button class="btn btn-outline-answer" @click="next(2)">참을만 하니까 잠깐만 쉬자! 푹신푹신한 의자</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page3",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page04', index:2, data: data });
    }
  },
}
</script>

<style>

</style>