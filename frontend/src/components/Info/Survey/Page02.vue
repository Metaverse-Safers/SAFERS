<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#2</b><br>
        휴양지에서 쉬고나니 배가 고파졌습니다.<br><mark>어떤 음식을 먹고 싶으신가요?</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(-2)">원래 평소에 좋아했던 맛있는 음식🥞</button>
      <button class="btn btn-outline-answer" @click="next(1)">처음 들어보는 이름의 신기한 음식🧆</button>
      <button class="btn btn-outline-answer" @click="next(-1)">비싸서 돈 주고 사먹지 못했던 음식🦪</button>
      <button class="btn btn-outline-answer" @click="next(2)">플레이팅으로 가득한  아름다운 음식🥘</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page2",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page03', index:1, data: data });
    }
  },
}
</script>

<style>

</style>