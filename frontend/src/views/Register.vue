<template>
    <div id='loginBackGround'>
        <img id='rectangle' src="@/assets/images/registerImg.png">
        <div>
            <form id="rgForm" enctype="multipart/form-data">
                <label id="rgImg" className="input-file-button" for="rgImgSelctor">
                    <img v-if="img.previewImgUrl" :src="img.previewImgUrl" style="height:15vh; width:15vh; borderRadius: 100px; text-align:center"/>
                    <p style="color:white; font-size:1.3vh">프로필 사진 변경하기</p>
                </label>
                <input id="rgImgSelctor" type="file" ref="selectFile" style="display:none" @change="previewFile" accept="image/*" />
                <br>
                <div class="rgText">
                    <input type="text" v-model="userInfo.nickName" required/>
                    <p style="color:white; font-size:1.3vh">닉네임</p>
                </div>
            </form>
            <img id="registerBtn" @click="register" src="@/assets/images/registerBtn.png">                            
        </div>
    </div>
</template>

<script>
    import { mapGetters } from "vuex";
    export default{
        data() {
            return{
                Hw: false,
                userInfo: {},
                img: {
                    selectFile: null,
                    previewImgUrl: null, // 미리보기 이미지 URL
                    isUploading: false, // 파일 업로드 체크
                },
            }
        },
        methods: {
            previewFile(e) {
                // 선택된 파일이 있는가?
                if (e.target.files.length > 0) {
                    // 0 번째 파일을 가져 온다.
                    
                    const file = e.target.files[0];
                    // 확장자 명 가져오기
                    let fileExt = file.name.substring(file.name.lastIndexOf(".") + 1); 
                    fileExt = fileExt.toLowerCase()

                    // 이미지 확장자 체크, 3메가 바이트 이하 인지 체크 
                    if(["jpeg", "png", "gif", "bmp", "jpg"].includes(fileExt)
                            && file.size <= 3145728){
                        
                        this.img.selectFile = file;
                        this.img.previewImgUrl = URL.createObjectURL(file);
                    }
                    else {
                        alert("3MB 이하의 이미지 파일만 가능합니다.")
                    }
                } else {
                    // 파일을 선택하지 않았을때
                    this.img.selectFile = null
                    this.img.previewImgUrl = null
                }
            },
            register(){
                const updateData = new FormData();
                updateData.append("id", this.userInfo.id);
                updateData.append("nickName", this.userInfo.nickName);
                updateData.append("profileFile", this.img.selectFile);
                this.$store.dispatch("user/requestUpdateProfile", updateData);
                this.$router.push({ name: 'unity' });
            }
        },
        computed: {
            ...mapGetters({
                userProfile: "user/userProfile"
            }),
        },
        mounted(){
            this.userInfo = { ...this.userProfile };
            this.img.previewImgUrl = this.userInfo.profileUrl;
        }
    }
</script>

<style>
    #loginBackGround{
        background-image: url('../assets/images/background.png');
        background-size: cover;
        background-repeat: no-repeat;
    }
    #loginWrap{
        display: flex;
        justify-content: space-between;
        height: 10vh; 
    }
    #loginQM{
        margin: 3vh;
        width: 5vh;
        height: 5vh;
    }
    #home{
        margin: 3.5vh;
        width: 15vh;
        height: 3.5vh;
    }
    #rectangle{
        width: 70vh;
        position:absolute;
        top:50%; left:50%;
        transform: translate(-50%, -50%);
    }
    #rgImg>img{
        position:absolute;
        z-index: 1;
        top:44%; left:49.5%;
        transform: translate(-50%, -50%);
        display:inline-block;
        vertical-align: middle;
    }
    #rgImg>p{
        position:absolute;
        z-index: 1;
        top:53%; left:49.5%;
        transform: translate(-50%, -50%);
        display:inline-block;
        vertical-align: middle;
    }
    .rgText>input{
        position:absolute;
        z-index: 1;
        top:60%; left:49.5%;
        transform: translate(-50%, -50%);
        border: solid 2px white;
        border-radius: 5px;
        width: 20vh;
    }
    .rgText>input[type="text"]:focus{
        border: solid 2px #c86b9885;
    }
    .rgText>p{
        position:absolute;
        z-index: 1;
        top:63%; left:49.5%;
        transform: translate(-50%, -50%);
    }
    #registerBtn{
        width: 15vh;
        position:absolute;
        top:70%; left:49.5%;
        transform: translate(-50%, -50%);
    }
    #registerBtn:hover{
        filter: brightness(80%);
    }
</style>