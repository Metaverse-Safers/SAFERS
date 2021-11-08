<template>
    <div class="main">
        <div class='box'>
            <!-- <div id="img">
                <img v-if="img.previewImgUrl" :src="img.previewImgUrl" style="height:80vh; width:46.6vw;"/>
                <input type="file" ref="selectFile" @change="previewFile" accept="image/*" required/>
            </div>
            <div id="text">  
                <textarea v-model="message" placeholder="문구 입력..."></textarea>
                <button class="btn" @click="insertRecord">업로드</button>
            </div> -->
            <form class="rgForm" enctype="multipart/form-data">
                <label class="rg-img" className="input-file-button" for="rg-img-selctor">
                    <img v-if="img.previewImgUrl" :src="img.previewImgUrl"
                        style="height: 15vh; width: 15vh; border-radius: 100px; text-align: center;"/>
                    <p style=" font-size: 5vh">사진 변경하기</p>
                </label>
                <input id="rg-img-selctor" type="file" ref="selectFile" style="display: none" @change="previewFile" accept="image/*"/>
                <br />
                <input class="rgText" type="text" v-model="boardInfo.title" required/>
                <input class="rgText" type="text" v-model="boardInfo.content" required/>
            </form>
            <img class="register-btn" @click="register" src="@/assets/images/kakaoLogin.png"/>
        
        </div>
    </div>
</template>

<script>
    import axios from "axios";
    import { mapGetters } from "vuex";
    export default {
        data() {
            return{
                userInfo: {},
                boardInfo:{
                    title: null,
                    content: null
                },
                img: {
                    selectFile: null,
                    previewImgUrl: null, // 미리보기 이미지 URL
                    isUploading: false, // 파일 업로드 체크
                },
                Hw: false
            }
        },
        created() {
            this.imageInfo = this.$route.query.image;
            if (this.imageInfo.height > this.imageInfo.width){
                this.Hw = true
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
            register() {
                const uploadBoard = new FormData();
                uploadBoard.append("title", this.boardInfo.title);
                uploadBoard.append("userId", this.userInfo.id);
                uploadBoard.append("fileList", this.img.selectFile);
                uploadBoard.append("content", this.boardInfo.content);
                axios.post('/api/board', uploadBoard)
                .then(res => {  // eslint-disable-line no-unused-vars
                    console.log(res)
                })
                .catch(err => {
                    console.log(err);
                });
            }
        },
        computed: {
                ...mapGetters({
                userProfile: "user/userProfile",
            })
        },
        mounted() {
            this.userInfo = { ...this.userProfile };
        },
    }
</script>
<style>
    
    .rg-img{
        width: 100%;
        height: 100%;
    }
</style>
