<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#7</b><br>
        곧 결정이 날 시간이 다가오고 있습니다.<br>
        복잡한 마음을 갖고 걷고 있는 중<br>
        두리번거리던 아이가 오더니 <mark>식당이 어딘지</mark> 물어봅니다.
      </div>
      <button class="btn btn-outline-answer" @click="next(-2)">"미안해 잘 모르겠어~"하고 얼른 간다.</button>
      <button class="btn btn-outline-answer" @click="next(2)">"혼자왔어? 어떤걸 먹고싶은데?!"하고 이야기한다.</button>
      <button class="btn btn-outline-answer" @click="next(-1)">"여기서 코너 돌면 번화가야"라고 간단히 말해준다.</button>
      <button class="btn btn-outline-answer" @click="next(1)">"어제 내가 먹은 곳 맛있는데 데려다 줄까?"한다.</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page7",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page08', index:1, data: data });
    }
  },
}
</script>

<style>

</style>