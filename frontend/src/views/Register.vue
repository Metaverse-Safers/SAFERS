<template>
    <div id='loginBackGround'>
        <img id='rectangle' src="@/assets/images/rectangle.png">
        <div>
            <form id="rgForm">
                <label className="input-file-button" for="input-file">
                    <img v-if="img.previewImgUrl" :src="img.previewImgUrl" for="input-file" style="height:10vh; width:10vh; borderRadius: 100px"/>
                </label>
                <input type="file" ref="selectFile" id="input-file" style="display:none" @change="previewFile" accept="image/*" />
                <input type="text" v-model="userInfo.nickName" required/>
                <button class="button" @click="register">회원가입</button>
            </form>
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
    #rgForm{
        position:absolute;
        z-index: 1;
        top:50%; left:50%;
        transform: translate(-50%, -50%);
    }
    .input-file-button{
        padding: 6px 25px;
        background-color:#FF6600;
        border-radius: 4px;
        color: white;
        cursor: pointer;
    }
</style>