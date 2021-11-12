<template>
  <div >
    <div class="info-survey-main" v-if="pages == 0">
      <div class="info-survey-explantion text-right">
        <div class="info-frist-text text-left">
          <h1><b>다음 생에 "동물"로 태어난다면?</b></h1>
          <br>
          <p>힘들고 지치지만 즐거운 인가의 삶을 마친 당신, 열심히 살아온 당신을 위해 신이 새로운 삶을 준다고 합니다.</p>
          <p>어려운 선택에 앞서 하룻밤 고민할 수 있는 시간을 주었습니다. 여유롭게 쉬면서 고민해볼까요?</p>
          <p>새로운 삶은 여러분의 답으로 결정된다고 하니 여러분이 원하는 답변을 골라보세요.</p>
          <div type="button" class="btn btn-outline-success" @click="pages = 'Page01'">새로운 삶으로 GO!</div>
        </div>
        <img class="info-frist-img" src="@/assets/images/Safers-Survey-Object.png" alt="">
      </div>
    </div>
    <div v-else>
      <component :is='pages' v-on:nextSurvey="nextPage" :mbti="mbti"></component>
    </div>
  </div>
</template>

<script>
import Page01 from "./Survey/Page01.vue";
import Page02 from "./Survey/Page02.vue";
import Page03 from "./Survey/Page03.vue";
import Page04 from "./Survey/Page04.vue";
import Page05 from "./Survey/Page05.vue";
import Page06 from "./Survey/Page06.vue";
import Page07 from "./Survey/Page07.vue";
import Page08 from "./Survey/Page08.vue";
import Page09 from "./Survey/Page09.vue";
import Page10 from "./Survey/Page10.vue";
import PageResult from "./Survey/PageResult.vue";

export default {
  name: "InfoSurvey",
  components:{
    Page01, Page02, Page03, Page04, Page05, Page06, Page07, Page08, Page09, Page10, PageResult
  },
  data(){
    return {
      mbti: [0, 0, 0, 0], // IE-SN-FT-PJ
      pages : 0
    }
  },
  methods: {
    nextPage(surverData){
      this.pages = surverData['nextPage'];
      this.mbti[surverData['index']] += surverData['data'];
    }
  },
}
</script>

<style>
.info-survey-explantion{
  background: #E8FAFF;
}

.info-survey-main {
  height: 100%; /* info-imge height */
}

.info-frist-img{
  /* width: 100%; */
  max-width: 100%;
  margin-top: 50px;
}

.info-frist-text{
  position: absolute;
  margin-top: 10vw;
  margin-left: 15vw;
  cursor: default;
}

.text-left{
  text-align: left;
}
</style>