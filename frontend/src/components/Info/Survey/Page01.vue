<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      <div class="info-survey-detail-text">
        <b>#1</b><br>
        새롭게 태어나기에 앞서 힘들었던 몸을 쉬고 싶습니다.<br><mark>어디에서 쉴까요?</mark>
      </div>
      <button class="btn btn-outline-answer" @click="next(-2)">한적하고 고요한 산 속🗻</button>
      <button class="btn btn-outline-answer" @click="next(1)">웃음소리가 가득한 바닷가🌅</button>
      <button class="btn btn-outline-answer" @click="next(-1)">조명이 빛나는 도심🌃</button>
      <button class="btn btn-outline-answer" @click="next(2)">재미있는 레크레이션이 있는 계곡🌈</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Page1",
  methods: {
    next(data){
      // index-order : IE-SN-FT-PJ
      this.$emit("nextSurvey", { nextPage:'Page02', index:0, data: data });
    }
  },
}
</script>

<style>
.btn-outline-answer{
  background: #fff;
  border-radius: 10px;
  border: 2px solid #afeeff;
  width: 40%;
  height: 80px;
  margin: 0px 5px;
  margin-bottom: 10px;
}

.btn-outline-answer:hover{
  background: #f7f7f7;
  border: 2px solid #5e5e5e;
}

.info-survey-detali-main{
  height: 100vh;
  background: #E8FAFF;
  padding-top : 10vh;
}

.info-survey-detail-text{
  font-size:3vh;
  height: 30vh;
  padding-top: 10vh;
  margin-bottom: 10vh;
}

.info-survey-detali-explantion{
  padding-right: 10vw;
  padding-left: 10vw;
}
</style>