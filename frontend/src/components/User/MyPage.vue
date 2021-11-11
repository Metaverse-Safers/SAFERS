<template>
  <div class="mypage-main">
    <div class="mypage-nav">
      <h1 class="imb-font-semi-bold">마이페이지</h1>
    </div>
    <div>
      <form enctype="multipart/form-data">
        <label class="mypage-profile-img" className="input-file-button" for="mypage-profile-img-selctor">
          <img v-if="img.previewImgUrl" :src="img.previewImgUrl"/>
          <div/>
          <p>프로필 사진 변경하기</p>
        </label>
        <input id="mypage-profile-img-selctor" type="file" ref="selectFile" style="display: none" @change="previewFile" accept="image/*"/>  
        <input class="mypage-text" type="text" v-model="userInfo.nickName" required>
      </form>
      <div class="mypage-btn">
          <button type="button" @click="register" class="btn btn-outline-secondary imb-font-semi-bold">수정하기</button>
          <button type="button" @click="withdrawal" class="btn btn-outline-danger imb-font-semi-bold">회원탈퇴</button>
      </div>
    </div>
    <!-- <img class="mypage-scene" src="@/assets/images/mypageScene.png"/> -->
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      userInfo: {},
      img: {
        selectFile: null,
        previewImgUrl: null, // 미리보기 이미지 URL
        isUploading: false, // 파일 업로드 체크
      }
    };
  },
  methods: {
    previewFile(e) {
      // 선택된 파일이 있는가?
      if (e.target.files.length > 0) {
        // 0 번째 파일을 가져 온다.

        const file = e.target.files[0];
        // 확장자 명 가져오기
        let fileExt = file.name.substring(file.name.lastIndexOf(".") + 1);
        fileExt = fileExt.toLowerCase();

        // 이미지 확장자 체크, 3메가 바이트 이하 인지 체크
        if (
          ["jpeg", "png", "gif", "bmp", "jpg", "jfif"].includes(fileExt) &&
          file.size <= 3145728
        ) {
          this.img.selectFile = file;
          this.img.previewImgUrl = URL.createObjectURL(file);
        } else {
          this.$fire({title: "3MB이하의 사진만 가능합니다!", type: "error", timer: 1500, showConfirmButton: false})
        }
      } else {
        // 파일을 선택하지 않았을때
        this.img.selectFile = null;
        this.img.previewImgUrl = null;
      }
    },
    register() {
      const updateData = new FormData();
      updateData.append("id", this.userInfo.id);
      updateData.append("nickName", this.userInfo.nickName);
      updateData.append("profileFile", this.img.selectFile);
      this.$store.dispatch("user/requestUpdateProfile", updateData);
      this.$fire({title: "변경되었습니다!", type: "success", timer: 1500, showConfirmButton: false})
    },
    async withdrawal() {
        var confirm = false;
        await this.$fire({title: "정말 탈퇴하시겠어요?", type: "question", timer: 9999999, showCancelButton: true})
        .then(function(result) {if(result.value) confirm = true})
        if(confirm){
            this.$fire({title: "금방 돌아오실 거죠? ㅠㅠ", text: "탈퇴 완료", type: "success", timer: 3000, showConfirmButton: false})
            await this.$store.dispatch("user/withdrawal", this.token.accessToken);
            await this.$router.push({ name: "main"});
            await window.location.reload();
        }
    }
  },
  computed: {
    ...mapGetters({
      userProfile: "user/userProfile",
      token: "user/token"
    }),
  },
  mounted() {
    this.userInfo = { ...this.userProfile };
    this.img.previewImgUrl = this.userInfo.profileUrl;
  },
};
</script>

<style>
.mypage-main {
  width: 100%;
  height: 100%;
  background-image: url('../../assets/images/mypageScene.png');
  background-repeat: no-repeat;
  background-position: center bottom;
  background-size: 100% 35%;
  margin-top: 1px;
}
.mypage-nav {
  display: grid;
  align-items: center;
  justify-items: center;
  border-bottom: 1px rgb(220, 220, 220) solid;
  padding: 10px
}
.mypage-nav > h1{
  margin-bottom: 0 !important;
}
.mypage-profile-img > img {
  position: absolute;
  top: 33%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  height: 20vh; 
  width: 20vh; 
  border-radius: 100px; 
  text-align: center;
}
.mypage-profile-img > p {
  position: absolute;
  top: 50%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  color: rgb(0, 0, 0); 
  font-size: 1.5vh;
}
.mypage-profile-img > p:hover {
  color: rgb(180, 180, 180);
}
.mypage-profile-img > div {
  position: absolute;
  top: 33%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  height: 20vh; 
  width: 20vh;
  border: 1px rgb(200, 200, 200) solid;
  border-radius: 100px;
}
.mypage-text {
  position: absolute;
  top: 58%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  width: 170px;
  border: none;
  background-color: rgb(240, 240, 240);
}
.mypage-text:focus {
  outline: none;
}
.mypage-btn {
  height: 10%;
  position: absolute;
  top: 68%;
  left: 49.5%;
  transform: translate(-50%, -50%);
}
.mypage-btn * {
  margin: 3px;
}
.mypage-profile-img :hover,
.mypage-btn:hover,
.mypage-withdrawal-btn:hover {
  filter: brightness(80%);
  cursor: pointer;
}
</style>