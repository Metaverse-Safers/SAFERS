<template>
  <div>    
      <div class="position-relative overflow-hidden p-3 p-md-5 text-center info-main-headline-div">
        <div class="col-md-5 mx-auto my-5 info-main-headline">
          <h1 class="fw-normal blend">새롭게 만나는 세계</h1>
          <p class="lead fw-normal">사라짐에 위협받는 친구들이 걱정없이 놀 수 있는 새로운 세상,<br>"세이퍼스"에 여러분을 초대합니다.</p>
          <!-- <a class="btn btn-outline-secondary" href="#">Coming soon</a> -->
        </div>
      </div>

      <div class="container">
        <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3">
          <div class="bg-dark me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
            <div class="my-3 py-3">
              <h2 class="display-5">Another headline</h2>
              <p class="lead">And an even wittier subheading.</p>
            </div>
            <div class="bg-light shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
          </div>
          <div class="bg-light me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 p-3">
              <h2 class="display-5">Another headline</h2>
              <p class="lead">And an even wittier subheading.</p>
            </div>
            <div class="bg-dark shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
          </div>
        </div>

        <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3">
          <div class="bg-light me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
            <div class="my-3 p-3">
              <h2 class="display-5">Another headline</h2>
              <p class="lead">And an even wittier subheading.</p>
            </div>
            <div class="bg-dark shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
          </div>
          <div class="bg-primary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
            <div class="my-3 py-3">
              <h2 class="display-5">Another headline</h2>
              <p class="lead">And an even wittier subheading.</p>
            </div>
            <div class="bg-light shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
          </div>
        </div>
      </div>
    </div>  
</template>

<script>
export default {
  name: "InfoMain",
}
</script>

<style>
.blend{
  mix-blend-mode: luminosity;
  font-size: 7vh;
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

.lead{
  font-size: 2vh;
}

.product-device {
  position: absolute;
  right: 10%;
  bottom: -30%;
  width: 300px;
  height: 540px;
  background-color: #333;
  border-radius: 21px;
  transform: rotate(30deg);
}

.product-device::before {
  position: absolute;
  top: 10%;
  right: 10px;
  bottom: 10%;
  left: 10px;
  content: "";
  background-color: rgba(255, 255, 255, 0.1);
  border-radius: 5px;
}

.product-device-2 {
  top: -25%;
  right: auto;
  bottom: 0;
  left: 5%;
  background-color: #e5e5e5;
}

@media (min-width: 768px) {
  .flex-md-equal > * {
    flex: 1;
  }
}
</style>
