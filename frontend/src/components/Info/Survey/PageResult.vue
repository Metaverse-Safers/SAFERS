<template>
  <div class="survey-result-div">
    <div class="container info-survey-detali-explantion text-center">
      <!-- result title -->
      <div ref="printMe" class="bg-skyblue">
        <div class="mt-5">
          <p>당신의 모든 행동의 결과로 다시 태어났습니다!</p>
          <h1><b>{{mbtiData.name}}</b></h1>
          <br>
          <div class="mbti-result-img result-img">
            <img :src="mbtiData.imageUrl" alt="">
          </div>
          <h5><i><mark>{{mbtiData.introduce}}</mark></i></h5>
        </div>
        <!-- result detail -->
        <div class="row mb-5">
          <div class="col-1"></div>
          <div class="col">
            <div class="pt-5 mt-5 text-left">
              <p class="mbti-result-sub-title"><b>| 당신은 Safers의 <span class="text-primary bg-success bg-opacity-25">{{mbtiData.area}}</span>에 살고 있습니다!</b></p>
              <ul class="mbti-result-list">
                <li class="mb-3 mt-2" v-for="exp in mbtiData.explanation" :key="exp">{{exp}}</li>
              </ul>
            </div>
            <div class="pt-3 mt-5 text-left">
              <p class="mbti-result-sub-title"><b>| 당신은 지구에서 <span class="text-danger">위협</span>받고 있어요.</b>&nbsp;&nbsp;<img id="exclamation-mark" class="exclamation-mark-icon" src="@/assets/icon/exclamation-point.png" alt=""><img id="read-line-img" class="result-redline" src="@/assets/images/redline.png" alt=""></p>
              <ul class="mbti-result-list">
                <li class="mb-3 mt-2" v-for="ext in mbtiData.extinction" :key="ext">{{ext}}</li>
              </ul>
            </div>
            <div class="pt-3 mt-5 text-left">
              <p class="mbti-result-sub-title"><b>| 당신의 <mark>성격</mark>은 이렇습니다.</b></p>
              <ul class="mbti-result-list">
                <li class="mb-3 mt-2" v-for="per in mbtiData.personality" :key="per.name">{{per}}</li>
              </ul>
            </div>
            <div class="pt-3 mt-5">
              <p class="mbti-result-sub-title text-left"><b>| 짝짝쿵! 사이좋은 친구들이에요.</b></p>
              <div class="text-center">
                <div class="result-img buddy-sub-animals" v-for="bu in mbtiData.buddy" :key="bu.name">
                  <img class="mb-3" :src="bu.imageUrl" alt="">
                  <p>{{bu.name}}</p>
                </div>   
              </div>
            </div>
            <div class="pt-3 mt-5">
              <p class="mbti-result-sub-title text-left"><b>| 으르렁! 만나면 안되는 친구들이에요.</b></p>
              <div class="text-center">
                <div class="result-img enemy-sub-animals" v-for="en in mbtiData.enemy" :key="en.name">
                  <img class="mb-3" :src="en.imageUrl" alt="">
                  <p>{{en.name}}</p>
                </div>  
              </div>
            </div>
            <div class="pt-3 mt-5">
              <p class="mbti-result-sub-title text-left"><b>| 당신과 함께 Safer의 <span class="text-primary bg-success bg-opacity-25">{{mbtiData.area}}</span>에서 사는 친구들이에요!</b></p>
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
      </div>
      <!-- button group -->
      <button class="btn btn-success btn-wide" type="button" @click="imageDownload">이미지 다운받기</button><br>
      <button id="btnKakao" class="btn btn-warning btn-wide" type="button" @click="shareKakao">카카오톡 공유하기</button><br>
      <button class="btn bg-safers btn-wide" type="button" @click="goLogin">Safers 회원가입/로그인하기</button>
      <!-- OUTPUT -->
      <a id="target" :href="output" :download="mbtiData.name" style="display:none;"></a>
    </div>
  </div>
</template>

<script>
import axios from "axios";
// import kakao from "vue-kakao-sdk";

export default {
  name: "PageResult",
  props: ["mbti"],
  data(){
    return {
      mbtiString: "",
      mbtiData: {},
      output: null,
    }
  },
  methods:{
    getMBTIData(){
      axios.get("/api/survey/" + this.mbtiString)
      .then(res => {
        this.mbtiData = res.data;
      }).catch(err=>{
        console.log(err);
      })
    },
    imageDownload(){
      console.log("클릭!");
      this.print();
    },
    async print() {
      const el = this.$refs.printMe;
      const options = {
        type: 'dataURL', useCORS: true, logging: false 
      }

      this.output = await this.$html2canvas(el, options);
      setTimeout(function(){
        document.getElementById("target").click();
      }, 100);
    },
    goLogin(){
      this.$router.push("/login");
    },
    shareKakao(){ 
      // 카카오링크 버튼 생성
      // this.$kakao.init("2920ed8322509d97bcdb698cad022b10");
      this.$kakao.Link.createDefaultButton({
        container: '#btnKakao', // 카카오공유버튼ID
        objectType: 'feed',
        content: {
          title: "[Safers] " + this.mbtiData.name +"로 환생했어!", // 보여질 제목
          description: "넌 어떤 동물로 환생할까?", // 보여질 설명
          imageUrl: this.mbtiData.imageUrl, // 콘텐츠 URL
          link: {
            mobileWebUrl: "https://k5a403.p.ssafy.io/info",
            webUrl: "https://k5a403.p.ssafy.io/info"
          }
        },
        buttons:[{
          title: '나도 검사해보기',
          link: {
            mobileWebUrl: "https://k5a403.p.ssafy.io/info",
            webUrl: "https://k5a403.p.ssafy.io/info"
          },
        }]
      });
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
.bg-skyblue{
  background: #E8FAFF;
}

.bg-safers{
  background: #C289C5;
}

.bg-safers:hover{
  filter:brightness(0.8);
}

.btn-wide{
  margin: 1vh auto;
  width: 40vw;
  height: 5vh;
}

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
