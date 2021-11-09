<template>
  <div class="side-menu-div">
    <nav class="menuShare">
      <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open"/>
      <label class="menu-open-button" for="menu-open">
        <i class="fas fa-bars"></i>
      </label>
      <div class="menu-item go-home-btn" @click="clickHome">
        <i class="fas fa-home"></i>
      </div>

      <div class="menu-item go-border-btn" @click="clickBorder">
        <i class="fas fa-chalkboard-teacher"></i>
      </div>

      <div class="menu-item go-user-page-btn" @click="clickMyPage">
        <i class="fas fa-user"></i>
      </div>

      <div class="menu-item logout-btn" @click="clickLogout">
        <i class="fas fa-sign-out-alt"></i>
      </div>
    </nav>
  </div>
</template>

<script>
import Border from "./Board/Board.vue";
import MyPage from "./User/MyPage.vue";
export default {
  name: "SideMenu",
  methods: {   
    clickBorder(){
      this.$modal.show(Border,{
        hot_table : 'data',
        modal : this.$modal },
        {
          name: 'border-modal',
          width : '80%',
          height : '80%',
          draggable: false,
        }
      )
    },
    clickMyPage(){
      this.$modal.show(MyPage,{
        hot_table : 'data',
        modal : this.$modal },
        {
          name: 'mypage-modal',
          width : '80%',
          height : '80%',
          draggable: false,
        }
      )
    },
    clickHome(){
      this.$router.push("/");
    }, 
    async clickLogout() {
      await this.$store.dispatch("user/requestLogout");
      this.$alert( "다음에 또 놀러오세요!", "로그아웃", "success")
      .then(() => console.log("Closed"));
      this.$router.push("/");
    }
  }, mounted(){
  }
};
</script>

<style>
.side-menu-div {
  position: absolute;
  float: left;
  z-index: 999;
}

.menuShare > div {
  opacity: 0.8;
  -webkit-transition: all 0.8s;
  -moz-transition: all 0.8s;
  -o-transition: all 0.8s;
  -ms-transition: all 0.8s;
  transition: all 0.8s;
  margin-left: 5px;
}

/*social share button*/
.menu-item,
.menu-open-button {
  background: #dbdbdb;
  border-radius: 100%;
  width: 60px;
  height: 60px;
  margin-left: -40px;
  position: absolute;
  color: #ffffff;
  text-align: center;
  line-height: 64px;
  -webkit-transform: translate3d(0, 0, 0);
  transform: translate3d(0, 0, 0);
  -webkit-transition: -webkit-transform ease-out 200ms;
  transition: -webkit-transform ease-out 200ms;
  transition: transform ease-out 200ms;
  transition: transform ease-out 200ms, -webkit-transform ease-out 200ms;
}

.menu-item:hover{
  cursor: pointer;
}

.menu-open {
  display: none;
}

.menuShare {
  margin: auto;
  position: fixed;
  top: 20px;
  left: 20px;
  width: 90px;
  height: 90px;
  text-align: center;
  box-sizing: border-box;
  font-size: 26px;
  z-index: 99;
}

.menuShare a.menu-item .fa {
  color: #fff;
}

.share-icon {
  color: #596778;
}

.menu-item > i {
  margin: -5px;
}

.menu-item:hover {
  opacity: 1;
}

.menu-item:nth-child(3) {
  -webkit-transition-duration: 180ms;
  transition-duration: 180ms;
}

.menu-item:nth-child(4) {
  -webkit-transition-duration: 180ms;
  transition-duration: 180ms;
}

.menu-item:nth-child(5) {
  -webkit-transition-duration: 180ms;
  transition-duration: 180ms;
}

.menu-item:nth-child(6) {
  -webkit-transition-duration: 180ms;
  transition-duration: 180ms;
}

.menu-open-button {
  z-index: 2;
  -webkit-transition-timing-function: cubic-bezier(0.175, 0.885, 0.32, 1.275);
  transition-timing-function: cubic-bezier(0.175, 0.885, 0.32, 1.275);
  -webkit-transition-duration: 400ms;
  transition-duration: 400ms;
  -webkit-transform: scale(1.1, 1.1) translate3d(0, 0, 0);
  transform: scale(1.1, 1.1) translate3d(0, 0, 0);
  cursor: pointer;
  box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
}

.menu-open-button:hover {
  -webkit-transform: scale(1.2, 1.2) translate3d(0, 0, 0);
  transform: scale(1.2, 1.2) translate3d(0, 0, 0);
}

.menu-open:checked + .menu-open-button {
  -webkit-transition-timing-function: linear;
  transition-timing-function: linear;
  -webkit-transition-duration: 200ms;
  transition-duration: 200ms;
  -webkit-transform: scale(0.8, 0.8) translate3d(0, 0, 0);
  transform: scale(0.8, 0.8) translate3d(0, 0, 0);
}

.menu-open:checked ~ .menu-item {
  -webkit-transition-timing-function: cubic-bezier(0.935, 0, 0.34, 1.33);
  transition-timing-function: cubic-bezier(0.935, 0, 0.34, 1.33);
}

.menu-open:checked ~ .menu-item:nth-child(3) {
  transition-duration: 180ms;
  -webkit-transition-duration: 180ms;
  -webkit-transform: translate3d(0.08361px, 80.99997px, 0);
  transform: translate3d(0.08361px, 80.99997px, 0);
}

.menu-open:checked ~ .menu-item:nth-child(4) {
  transition-duration: 280ms;
  -webkit-transition-duration: 280ms;
  -webkit-transform: translate3d(0.08361px, 160.99997px, 0);
  transform: translate3d(0.08361px, 160.99997px, 0);
}

.menu-open:checked ~ .menu-item:nth-child(5) {
  transition-duration: 380ms;
  -webkit-transition-duration: 380ms;
  -webkit-transform: translate3d(0.08361px, 240.99997px, 0);
  transform: translate3d(0.08361px, 240.99997px, 0);
}

.menu-open:checked ~ .menu-item:nth-child(6) {
  transition-duration: 380ms;
  -webkit-transition-duration: 380ms;
  -webkit-transform: translate3d(0.08361px, 320.99997px, 0);
  transform: translate3d(0.08361px, 320.99997px, 0);
}

.go-home-btn {
  background-color: #FFC1A0;
}

.go-home-btn:hover {
  color: #ffffff;
  text-shadow: none;
  background-color: #fcb087;
}

.go-border-btn {
  background-color: #F09F9C;
}

.go-border-btn:hover {
  color: #ffffff;
  text-shadow: none;
  background-color: #f08e8a;
}

.go-user-page-btn {
  background-color: #C86C98;
}

.go-user-page-btn:hover {
  color: #ffffff;
  text-shadow: none;
  background-color: #c75c90;
}

.logout-btn {
  background-color: #632B6C;
}

.logout-btn:hover {
  color: #ffffff;
  text-shadow: none;
  background-color: #6c0e7a;
}
</style>