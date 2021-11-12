<template>
  <div class="info-survey-detali-main">
    <div class="container info-survey-detali-explantion text-center">
      {{mbtiString}}
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "PageResult",
  props: ["mbti"],
  data(){
    return {
      mbtiString: "",
      mbtiData: {},
    }
  },
  methods:{
    getMBTIData(){
      axios.post({
        url: "api/survey",
        data: {
          mbti: this.mbtiString
        }
      })
      .then(res => {
        console.log(res);
      }).catch(err=>{
        console.log(err);
      })
    }
  },
  created(){
    // index-order : IE-SN-FT-PJ
    this.mbtiString += this.mbti[0] < 0 ? "I" : "E";
    this.mbtiString += this.mbti[1] < 0 ? "S" : "N";
    this.mbtiString += this.mbti[2] < 0 ? "F" : "T";
    this.mbtiString += this.mbti[3] < 0 ? "P" : "J";
    this.getMBTIData();
  }
}
</script>

<style>

</style>