<template>
  <div class="login-background">
    <img class="rectangle" src="@/assets/images/registerImg.png" />
    <div>
      <form id="rgForm" enctype="multipart/form-data">
        <label class="rg-img" className="input-file-button" for="rg-img-selctor">
          <img v-if="img.previewImgUrl" :src="img.previewImgUrl"
            style="height: 15vh; width: 15vh; border-radius: 100px; text-align: center;"/>
          <p style="color: white; font-size: 1.3vh">프로필 사진 변경하기</p>
        </label>
        <input id="rg-img-selctor" type="file" ref="selectFile" style="display: none" @change="previewFile" accept="image/*"/>
        <br />
        <input class="rgText" type="text" v-model="userInfo.nickName"/>
        <p class="rgText-validation imb-font-regular" v-if="validationCheckNickname">닉네임은 한글 최대 7자, 영어 최대 13자입니다.</p>
      </form>
      <button class="btn register-btn" type="button" @click="register" :disabled="registerVaildCheck"><img src="@/assets/images/registerBtn.png" class="register-btn"/></button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      userInfo: {
        nickName: ""
      },
      img: {
        selectFile: null,
        previewImgUrl: null, // 미리보기 이미지 URL
        isUploading: false, // 파일 업로드 체크
      },
      inputFocus: false,
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
          alert("3MB 이하의 이미지 파일만 가능합니다.");
        }
      } else {
        // 파일을 선택하지 않았을때
        this.img.selectFile = null;
        this.img.previewImgUrl = null;
      }
    },
    async register() {
      // 1차 회원가입 후
      await this.$store.dispatch("user/requestProfile", this.token);
      await this.profileUpdate();
    },

    async profileUpdate() {
      // 사용자 프로필 업데이트
      const updateData = new FormData();
      updateData.append("id", this.userInfo.id); 
      updateData.append("nickName", this.userInfo.nickName);
      if (this.img.selectFile)
        updateData.append("profileFile", this.img.selectFile);
      else
        updateData.append("profileFile", this.userInfo.profileUrl);
      this.$fire({
            title: "환영합니다!",
            text: "회원가입 완료",
            type: "success",
            timer: 2000,
            showConfirmButton: false
        })
      for (let value of updateData.values()) {
        console.log(value);
      }
      await this.$store.dispatch("user/requestUpdateProfile", updateData);
      await this.$router.push({ name: "main" });
    }
  },
  computed: {
    ...mapGetters({
        token: "user/token",
        userProfile: "user/userProfile"
    }),
    registerVaildCheck(){
      if(this.userInfo["nickName"].length > 0 && this.img.selectFile != null)
        return false;
      return true;
    },
    validationCheckNickname(){
      const regExp1 = /^[가-힣]{1,7}$/g;
      const regExp2 = /^[a-zA-Z]{1,13}$/g;
      if(!regExp1.test(this.userInfo.nickName) && !regExp2.test(this.userInfo.nickName))
        return true;
      return false;
    }
  },
  mounted() {
    this.userInfo = { ...this.userProfile };
    this.img.previewImgUrl = this.userInfo.profileUrl;
  },
};
</script>

<style>
.login-background {
  background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280f36);
  background-size: 160% 160%;
  -webkit-animation: gradient 10s ease infinite;
  animation: gradient 10s ease infinite;
  width: 100vw;
  height: 100vh;
}
.rectangle {
  width: 70vh;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.rg-img > img {
  position: absolute;
  z-index: 1;
  top: 44%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  display: inline-block;
  vertical-align: middle;
}
.rg-img > p {
  position: absolute;
  z-index: 1;
  top: 53%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  display: inline-block;
  vertical-align: middle;
}
.rgText {
  position: absolute;
  z-index: 1;
  top: 60%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  display: inline-block;
  vertical-align: middle;
  border: solid 2px white;
  border-radius: 8px;
  width: 20vh;
}
.rgText-validation {
  position: absolute;
  z-index: 1;
  top: 64.5%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  display: inline-block;
  vertical-align: middle;
  color:red;
  font-size: 1.5vh;
}
.register-btn {
  width: 15vh;
  position: absolute;
  top: 70%;
  left: 49.5%;
  transform: translate(-50%, -50%);
}
.rg-img > p:hover {
  filter: brightness(80%);
  cursor: pointer;
}
</style>