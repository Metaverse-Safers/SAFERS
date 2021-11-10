<template>
  <div>    
      <div class="position-relative overflow-hidden p-3 p-md-5 text-center info-main-headline-div">
        <div class="col-md-5 mx-auto my-5 info-main-headline">
          <h1 class="fw-normal blend">새롭게 만나는 세계</h1>
          <p class="lead fw-normal">사라짐에 위협받는 친구들이 걱정없이 놀 수 있는 새로운 세상,<br>"세이퍼스"에 여러분을 초대합니다.</p>
          <!-- <a class="btn btn-outline-secondary" href="#">Coming soon</a> -->
        </div>
      </div>

        <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3 mt-5 mb-5 line-top container">
          <div class="me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-left overflow-hidden">
            <div class="my-3 py-3">
              <h3><b>지구에 사는 많은 생명을 위해</b></h3>
              <p>for the many lives on earth</p>
            </div>
            <div class="info-link">
              <a target="_black" href="https://www.nie.re.kr/endangered_species/home/nprotect/prot02001i.do">[국립생태원] 대한민국 국가보호종 보기</a>
            </div>
          </div>
          <div class="me-md-3 pt-5 px-5 pt-md-5 px-md-5 text-left overflow-hidden">
            <div class="my-3 p-3">
              <h3><b>50년 간 이 땅에 일어난 사라짐</b></h3>
              <p>단, 1세기도 걸리지 않았다.</p><br>
              <div class="row" style="height:80px;">
                <div class="col-7">
                  <div class="row">
                    <div class="col-4 info-number"><span id="counter-percent"></span>%</div>
                    <div class="col pl-5">전 세계에서<br>위협받는 동물 비율</div>
                  </div>
                </div>
                <div class="col">
                  <div class="row">
                    <div class="col-4 info-number"><span id="counter-number"></span></div>
                    <div class="col">&nbsp;&nbsp;우리나라의<br>&nbsp;&nbsp;멸종위기 종</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="d-md-flex flex-md-equal w-100 my-md-5 ps-md-3 mt-5 line-mid container">
          <div class="info-box me-md-3 px-3 pt-md-4 pb-md-4 mb-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 p-3">
              <img class="info-icon" src="@/assets/icon/mobile.png" alt="">
              <hr style="background:#ffffff;">
              <h3><b>가상세계</b></h3>
              <p>멸종 위기 동물과의 만남<br>새로운 세상에서의 힐링</p>
            </div>
          </div>
          <div class="info-box me-md-3 px-3 pt-md-4 pb-md-4 mb-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 py-3">
              <img class="info-icon" src="@/assets/icon/history-book.png" alt="">
              <hr style="background:#ffffff;">
              <h3><b>동물도감</b></h3>
              <p>환경 미션을 클리어 하며,<br>동물 카드 모으기</p>
            </div>
          </div>
          <div class="info-box me-md-3 px-3 pt-md-4 pb-md-4 mb-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 py-3">
              <img class="info-icon" src="@/assets/icon/chat.png" alt="">
              <hr style="background:#ffffff;">
              <h3><b>커뮤니티</b></h3>
              <p>아름다운 목표를 향한<br>유저들과의 이야기 공유</p>
            </div>
          </div>
        </div>

        <div class="info-video-div ">
          <div class="container pt-4">
            <div class="row">
              <div class="col-8">
                <video class="info-video" src="@/assets/video/Safers-Info-Main.mp4" muted="muted" autoplay="autoplay" loop="loop"></video><br><br>
              </div>
              <div class="col info-video-text align-self-end">
                <p>video</p>
                <h2><b>세이퍼스의 소개 영상</b></h2>
                <br>
                이 곳에는 동물 친구들이<br>
                탁 트인 풍경에서 자유로이 거닐고 있어요.<br>
                <br>
                답답하고 지루했던 하루의 끝, 같이 쉬어보시겠어요?<br><br>
                <img class="info-thumnail" src="@/assets/images/thumnail1.png" alt="">&nbsp;
                <img class="info-thumnail" src="@/assets/images/thumnail2.png" alt="">
              </div>
            </div>
          </div>
        </div>

        <div class="container">
          <div class="text-center mt-5">
            <p>Safers diary</p>
            <h1><b>세이퍼스 일기</b></h1>
          </div>

          <div class="row">
            <div class="col">
              <div class="empty-card"></div>
              <div class="card ml-5">
                <img src="@/assets/images/page-1.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text"><mark>더이상 볼 수 없는 동물</mark>을 볼 수 있었어</p>
                </div>
              </div>
              <div class="empty-card"></div>
              <div class="card ml-5">
                <img src="@/assets/images/page-3.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text">답답했던 일상에서 벗어나 <mark>아름다운 세계</mark>로 갈 수 있어</p>
                </div>
              </div>
              <div class="empty-card"></div>
              <div class="card ml-5">
                <img src="@/assets/images/page-5.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text">내가 동물친구들을 위해 <mark>할 수 있는 방법</mark>을 배웠어</p>
                </div>
              </div>
              <div class="empty-card-bottom"></div>
            </div>
            <div class="col border-left">
              <div class="empty-card-top"></div>
              <div class="card ml-5">
                <img src="@/assets/images/page-2.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text"><mark>다음 생에 동물</mark>로 태어난다면 어떤 동물일까?!</p>
                </div>
              </div>
              <div class="empty-card"></div>
              <div class="card ml-5">
                <img src="@/assets/images/page-4.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text"><mark>크고 작은 미션</mark>이 너무 재미있는거 있지?!</p>
                </div>
              </div>
              <div class="empty-card"></div>
              <div class="card ml-5">
                <img src="@/assets/images/page-6.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text">많은 사람들과 이야기도 하면서 <mark>같이 즐기기</mark> 너무 좋아</p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="join container">
          <div class="row">
            <div class="col">
              <img src="@/assets/images/safers-logo-gif.gif" alt="" class="w-100 gif-img">
            </div>
            <div class="col">
              <h3><b>&nbsp;&nbsp;세이퍼스에 놀러오세요.</b></h3>
              <div class="card-info-box"><router-link to=/login>🌏 로그인/회원가입하기</router-link></div>
              <div class="card-info-box"><a href="https://forms.gle/fmhmGCBrh5WoYGS6A" target="_blank">💪🏻 개발팀 응원하기</a></div>
              <div class="card-info-box"><a href="https://forms.gle/F9MZYzjA2LbBLBsQ7" target="_blank">📋 건의사항 전달하기 </a></div>
              <div class="card-info-box"><a href="https://forms.gle/EkRsna4hVNy2GfYs9" target="_blank">📇 오류사항 전달하기 </a></div>
              <div class="card-info-box"><a href="https://forms.gle/mZ5fEgmritDKDVaDA" target="_blank">🚫 불량 유저/글 신고하기 </a></div>
            </div>
          </div>
        </div>
    </div>  
</template>

<script>
export default {
  name: "InfoMain",
  methods:{
    countTo(number, element){
      let count = 0
      
      setInterval(function() {
        if(count < number) count++
        element.textContent = count
      }, 15)
    }
  },
  mounted(){
    let percent = document.getElementById('counter-percent');
    let number = document.getElementById('counter-number');
    this.countTo(70, percent)
    this.countTo(267, number)
  }
}
</script>

<style>
.blend{
  mix-blend-mode: luminosity;
  font-size: 7vh;
}

.border-left{
  border-left: 1px solid #e5e5e5;
}

.info-box{
  border-radius: 20px;
} 

.info-box:nth-child(1) {
  border: 1px solid #632B6C;
}

.info-box:nth-child(2) {
  border: 1px solid #C86B98;
}

.info-box:nth-child(3) {
  border: 1px solid#F09F9C;
}

.info-box:nth-child(1):hover {
  background: #632B6C;
  color: #ffffff;
}

.info-box:nth-child(2):hover {
  background: #C86B98;
}

.info-box:nth-child(3):hover {
  background:#F09F9C;
}

.card > img {
  border-radius : 20px 20px 0px 0px;
}

.card{
  border-radius : 22px;
  margin-left: 10%;
  width:80%;
  text-align: center;
}

.card-info-box{
  width: 80%;
  border-bottom: 1px solid #e5e5e5;
  padding: 2vh 5vh;
  border-radius: 10px;
}

.card-info-box:hover{
  background: #e5e5e5;
}

.empty-card{
  height: 300px;
}

.empty-card-top{
  height: 630px;
}

.empty-card-bottom{
  height: 500px;
}

.carousel-inner img {
  width: 100%;
  height: 100%;
}

.flex-equal > * {
  flex: 1;
}

.info-main-headline{
  height: 72vh;
  padding-top: 10vh;
}

.info-main-headline-div{
  background-image: url("../../assets/images/Safers-Info-Img.png");
}

.info-number{
  font-size: 4vh;
  color: #632B6C;
  font-weight: bold;
}

.info-thumnail{
  width: 9vw;
  border-radius: 10px;
}

.info-video-text{
  padding-bottom: 3vh;
}

.info-video-text > small {
  display: inline-block;
  margin-bottom: 2vh;
}

.info-icon{
  width: 50px;
  filter: invert(100%);
}

.info-icon:hover{
  filter: invert(100%);
}

.info-link {
 padding-top: 2vh;
 text-align: right;
}

.login-to{
  display: inline-block;
  padding-left: 30vh;
  margin-top: 10vh;
}

.gif-img{
  width: 100%;
  border-radius: 20px;
}

.card-info-box > a,
.login-to,
.info-link > a {
  text-decoration: none;
  color: grey;
}

.card-info-box > a:hover,
.login-to:hover,
.info-link > a:hover {
  filter: brightness(20%);
}

.info-video-div{
  padding: 7vh;
  margin-bottom: 25vh;
  height: 70vh;
  background: #f7f7f7;
}

.info-video {
  width: 100%;
  border-radius: 10px;
}

.join{
  margin-top: 20vh;
  margin-bottom: 15vh;
}


.lead{
  font-size: 2vh;
}

.line-top{
  height: 50vh;
  padding-top: 10vh;
}

.line-mid{
  padding-bottom: 10vh;
}

@media (min-width: 768px) {
  .flex-md-equal > * {
    flex: 1;
  }
}
</style>
