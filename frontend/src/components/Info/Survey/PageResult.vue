<template>
  <div class="survey-result-div">
    <div class="container info-survey-detali-explantion">
      <!-- result title -->
      <div class="text-center mt-5">
        <p>당신의 모든 행동의 결과로 다시 태어났습니다!</p>
        <h1><b>{{mbtiData.name}}</b></h1>
        <br>
        <div class="mbti-result-img result-img">
          <img :src="mbtiData.imageUrl" alt="">
        </div>
        <h5><i><mark>{{mbtiData.introduce}}</mark></i></h5>
      </div>
      <!-- result detail -->
      <div class="row">
        <div class="col-1"></div>
        <div class="col">
          <div class="pt-5 mt-5">
            <p class="mbti-result-sub-title"><b>| 당신은 Safers의 <span class="text-primary bg-success bg-opacity-25">{{mbtiData.area}}</span>에 살고 있습니다!</b></p>
            <ul class="mbti-result-list">
              <li class="mb-3 mt-2" v-for="exp in mbtiData.explanation" :key="exp">{{exp}}</li>
            </ul>
          </div>
          <div class="pt-3 mt-5">
            <p class="mbti-result-sub-title"><b>| 당신은 지구에서 <span class="text-danger">위협</span>받고 있어요.</b>&nbsp;&nbsp;<img id="exclamation-mark" class="exclamation-mark-icon" src="@/assets/icon/exclamation-point.png" alt=""><img id="read-line-img" class="result-redline" src="@/assets/images/redline.png" alt=""></p>
            <ul class="mbti-result-list">
              <li class="mb-3 mt-2" v-for="ext in mbtiData.extinction" :key="ext">{{ext}}</li>
            </ul>
          </div>
          <div class="pt-3 mt-5">
            <p class="mbti-result-sub-title"><b>| 당신의 <mark>성격</mark>은 이렇습니다.</b></p>
            <ul class="mbti-result-list">
              <li class="mb-3 mt-2" v-for="per in mbtiData.personality" :key="per.name">{{per}}</li>
            </ul>
          </div>
          <div class="pt-3 mt-5">
            <p class="mbti-result-sub-title"><b>| 짝짝쿵! 사이좋은 친구들이에요.</b></p>
            <div class="text-center">
              <div class="result-img buddy-sub-animals" v-for="bu in mbtiData.buddy" :key="bu.name">
                <img class="mb-3" :src="bu.imageUrl" alt="">
                <p>{{bu.name}}</p>
              </div>   
            </div>
          </div>
          <div class="pt-3 mt-5">
            <p class="mbti-result-sub-title"><b>| 으르렁! 만나면 안되는 친구들이에요.</b></p>
            <div class="text-center">
              <div class="result-img enemy-sub-animals" v-for="en in mbtiData.enemy" :key="en">
                <img class="mb-3" :src="en.imageUrl" alt="">
                <p>{{en.name}}</p>
              </div>  
            </div>
          </div>
          <div class="pt-3 mt-5">
            <p class="mbti-result-sub-title"><b>| 당신과 함께 <span class="text-primary bg-success bg-opacity-25">{{mbtiData.area}}</span>에서 사는 친구들이에요!</b></p>
            <div class="text-center">
              <div class="result-img similar-sub-animals" v-for="si in mbtiData.similar" :key="si.name">
                <img class="mb-3" :src="si.imageUrl" alt="">
                <p>{{si.name}}</p>
              </div>  
            </div>
          </div>
        </div>
        <div class="col-1"></div>
      </div>
      <!-- button group -->
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
      axios.get("/api/survey/" + this.mbtiString)
      .then(res => {
        this.mbtiData = res.data;
        console.log(this.mbtiData);
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
  }, mounted(){
    document.getElementById("read-line-img").style.display = "none";
    document.getElementById("exclamation-mark").addEventListener("mouseout", function(){
      document.getElementById("read-line-img").style.display = "none";
    });
    document.getElementById("exclamation-mark").addEventListener("mouseover", function(){
      document.getElementById("read-line-img").style.display = "block";
    });
  }
}
</script>

<style>
.exclamation-mark-icon{
  width: 24px;
}

.exclamation-mark-icon:hover{
  filter:brightness(0.8);
  cursor: pointer;
}

.survey-result-div{
  background: #E8FAFF;
  padding-top : 10vh;
  padding-bottom: 10vh;
}

.result-top-image{
  height: 200px;
}

.result-redline{
  width: 60%;
  position: absolute;
}

.result-img{
  background: white;
  display: inline-block;
  border-radius: 50%;
}

.buddy-sub-animals{
  border: 5px solid #b1a0ff;
  width: 170px;
  height: 170px;
  margin-right: 10px;
}

.enemy-sub-animals{
  border: 5px solid #ff8989;
  width: 170px;
  height: 170px;
  margin-right: 10px;
}

.similar-sub-animals{
  border: 5px solid #00b1f7;
  width: 170px;
  height: 170px;
  margin-right: 10px;
}

.mbti-result-img{
  width: 350px;
  height: 350px;
  border: 15px solid #FFC1A0;
  margin-bottom: 5vh;
}

.similar-sub-animals > img,
.enemy-sub-animals > img,
.buddy-sub-animals > img,
.mbti-result-img > img{
  width: 100%;
}

.mbti-result-introduce {
  background: white;
  border-radius: 15px;
  margin: 0 auto;
}

.mbti-result-sub-title{
  font-size: 20px;
}
</style>
