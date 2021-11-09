<template>
  <div class="mypage-container">
    <img class="mypage-img" src="@/assets/images/mypageImg.png" />
    <div>
      <form enctype="multipart/form-data">
        <label class="mypage-profile-img" className="input-file-button" for="mypage-profile-img-selctor">
          <img v-if="img.previewImgUrl" :src="img.previewImgUrl"
            style="height: 15vh; width: 15vh; border-radius: 100px; text-align: center;"/>
          <p style="color: white; font-size: 1.3vh">프로필 사진 변경하기</p>
        </label>
        <input id="mypage-profile-img-selctor" type="file" ref="selectFile" style="display: none" @change="previewFile" accept="image/*"/>  
        <input class="mypage-text" type="text" v-model="userInfo.nickName" required/>
      </form>
      <img class="mypage-btn" @click="register" src="@/assets/images/mypageBtn.png"/>
      <img class="mypage-withdrawal-btn" @click="withdrawal" src="@/assets/images/withdrawal.png"/>
    </div>
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
            await this.$store.dispatch("user/requestLogout");
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
.mypage-container {
  background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280f36);
  background-size: 160% 160%;
  -webkit-animation: gradient 10s ease infinite;
  animation: gradient 10s ease infinite;
  width: 100vw;
  height: 100vh;
}
.mypage-img {
  width: 70vh;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.mypage-profile-img > img {
  position: absolute;
  z-index: 1;
  top: 40%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  display: inline-block;
  vertical-align: middle;
}
.mypage-profile-img > p {
  position: absolute;
  z-index: 1;
  top: 53%;
  left: 49.5%;
  transform: translate(-50%, -50%);
  display: inline-block;
  vertical-align: middle;
}
.mypage-text {
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
.mypage-btn {
  width: 15vh;
  position: absolute;
  top: 70%;
  left: 49.5%;
  transform: translate(-50%, -50%);
}
.mypage-withdrawal-btn {
  width: 10vh;
  position: absolute;
  top: 78%;
  left: 49.5%;
  transform: translate(-50%, -50%);
}
.mypage-profile-img :hover,
.mypage-btn:hover,
.mypage-withdrawal-btn:hover {
  filter: brightness(80%);
  cursor: pointer;
}
</style>