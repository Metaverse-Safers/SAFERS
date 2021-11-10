<template>
  <div>
    <div class="wave-container">
      <svg viewBox="0 0 500 300" preserveAspectRatio="xMinYMin meet">
        <path d="M0,200 C250,250 350,0 500,100 L550,00 L0,0 Z" style="stroke: none; fill:#E8FAFF;"></path>
      </svg>
      <div class="wave-data container">
        <div class="wave-team-text">
          <h1><b>떡잎방범대 🌱</b></h1><br>
          <p>아름다운 세이퍼스를 만들고,</p>
          <p>지켜나가는 다섯 명의 개발자를 소개합니다.</p>
        </div>
        <img class="wave-team-img" src="@/assets/images/team.png" alt="">
      </div>
    </div>
    <div class="container mb-5 mt-5">
      <div class="row">
        <div class="col-1"></div>
        <div class="col">
          <div class="row">
            <div class="col text-right pt-5">
              <h3><b>당현아</b></h3>
              <p>하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말</p>
              <a class="info-img-link" href="https://github.com/eona1301" target="_black"><img class="link-icon" src="@/assets/icon/github.png" alt="github"></a>
              <a class="info-img-link" href="mailto:eona1301@gmail.com" target="_black"><img class="link-icon" src="@/assets/icon/email.png" alt="email"></a> 
              <a class="info-img-link" href="https://velog.io/@eona1301" target="_black"><img class="link-icon" src="@/assets/icon/world-wide-web.png" alt="web"></a> 
            </div>
            <div class="col text-center">
              <img class="member-profile" src="https://avatars.githubusercontent.com/u/45550607?v=4" alt="">
            </div>
          </div>
        </div>
        <div class="col"></div>
        <div class="col-1"></div>
      </div>
      <div class="row">
        <div class="col-1"></div>
        <div class="col"></div>
        <div class="col">
          <div class="row">
            <div class="col text-center">
              <img class="member-profile" src="https://avatars.githubusercontent.com/u/46213180?v=4" alt="">
            </div>
            <div class="col pt-5">
              <h3><b>이상현</b></h3>
              <p>하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말</p>
              <a class="info-img-link" href="https://github.com/kimkuan" target="_black"><img class="link-icon" src="@/assets/icon/github.png" alt="github"></a>
              <a class="info-img-link" href="mailto:zxd9857@gmail.com" target="_black"><img class="link-icon" src="@/assets/icon/email.png" alt="email"></a>
            </div>
          </div>
        </div>
        <div class="col-1"></div>
      </div>
      <div class="row">
        <div class="col-1"></div>
        <div class="col">
          <div class="row">
            <div class="col text-right pt-5">
              <h3><b>이영주</b></h3>
              <p>하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말</p>
              <a class="info-img-link" href="https://github.com/0JUUU" target="_black"><img class="link-icon" src="@/assets/icon/github.png" alt="github"></a>
              <a class="info-img-link" href="mailto:clleo97@naver.com" target="_black"><img class="link-icon" src="@/assets/icon/email.png" alt="email"></a> 
              <a class="info-img-link" href="https://0juuu.tistory.com/" target="_black"><img class="link-icon" src="@/assets/icon/world-wide-web.png" alt="web"></a> 
            </div>
            <div class="col text-center">
              <img class="member-profile" src="https://avatars.githubusercontent.com/u/61124319?v=4" alt="">
            </div>
          </div>
        </div>
        <div class="col"></div>
        <div class="col-1"></div>
      </div>
      <div class="row">
        <div class="col-1"></div>
        <div class="col"></div>
        <div class="col">
          <div class="row">
            <div class="col text-center">
              <img class="member-profile" src="https://avatars.githubusercontent.com/u/40432401?v=4" alt="">
            </div>
            <div class="col pt-5">
              <h3><b>안상훈</b></h3>
              <p>하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말</p>
              <a class="info-img-link" href="https://github.com/ahnsang9" target="_black"><img class="link-icon" src="@/assets/icon/github.png" alt="github"></a>
              <a class="info-img-link" href="mailto:ahnsang9@naver.com" target="_black"><img class="link-icon" src="@/assets/icon/email.png" alt="email"></a>
            </div>
          </div>
        </div>
        <div class="col-1"></div>
      </div>
      <div class="row">
        <div class="col-1"></div>
        <div class="col">
          <div class="row">
            <div class="col text-right pt-5">
              <h3><b>정원석</b></h3>
              <p>하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말 하고싶은 말</p>
              <a class="info-img-link" href="https://github.com/JWeonseok" target="_black"><img class="link-icon" src="@/assets/icon/github.png" alt="github"></a>
              <a class="info-img-link" href="mailto:weonseok125@naver.com" target="_black"><img class="link-icon" src="@/assets/icon/email.png" alt="email"></a> 
            </div>
            <div class="col text-center">
              <img class="member-profile" src="https://avatars.githubusercontent.com/u/77473524?v=4" alt="">
            </div>
          </div>
        </div>
        <div class="col"></div>
        <div class="col-1"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.info-img-link{
  margin-left: 5px;
}

.link-icon{
  width: 24px;
}

.member-profile{
  width: 200px;
  border-radius: 50%;
}

.link-icon:hover,
.member-profile:hover{
  -webkit-filter: brightness(.5);
  filter: brightness(.5);
}

.text-right{
  text-align: right;
}

.wave-container {
  display: inline-block;
  position: relative;
  width: 100%;
  padding-bottom: 45vw;
  vertical-align: middle;
  overflow: hidden;
}

.wave-container > svg {
  display: inline-block;
  position: absolute;
  top: 0;
  left: 0;
}

.wave-data{
  position: relative;
}

.wave-team-img{
  position: absolute;
  width: 900px;
  right: 0vw;
  top: 130px;
}

.wave-team-text{
  position: absolute;
  width: 30vw;
  padding-top: 150px;
  padding-left: 80px;
}
</style>