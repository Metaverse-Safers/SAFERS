<template>
    <div class="write-wrap">
        <form class="write-box" enctype="multipart/form-data">
            <label class="write-img" className="input-file-button" for="rg-img-selctor">
                <img v-if="img.previewImgUrl" :src="img.previewImgUrl"/>
                <p v-else class="imb-font-semi-bold">사진 선택</p>
            </label>
            <input id="rg-img-selctor" type="file" ref="selectFile" style="display: none" @change="previewFile" accept="image/*" required/>
            <div class="write-user">
                <img :src="userProfile.profileUrl"/>
                <div class="imb-font-semi-bold">{{userProfile.nickName}}</div>
            </div>
            <div>
                <input class="imb-font-semi-bold write-text write-title"  placeholder="제목" v-model="boardInfo.title" required/>
                <textarea class="imb-font-semi-bold write-text write-content"  placeholder="문구 입력..." v-model="boardInfo.content" required/>
            </div>
        </form>
        <div class="write-btn">
            <button type="button" class="btn btn-outline-secondary imb-font-semi-bold" @click="register">게시물 등록</button>
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
                    title: "",
                    content: ""
                },
                img: {
                    selectFile: null,
                    previewImgUrl: null, // 미리보기 이미지 URL
                    isUploading: false, // 파일 업로드 체크
                }
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
                    if(["jpeg", "png", "gif", "bmp", "jpg", "jfif"].includes(fileExt)
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
                    this.$alert( "등록 되었습니다!", "완료", "success")
                    this.boardInfo.title="";
                    this.boardInfo.content="";
                    this.img.selectFile="";
                    this.img.previewImgUrl="";
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
    .write-wrap{
        height: 80%;
    }
    .write-box{
        display: grid;
        grid-template-columns: 2fr 1fr;
        grid-template-rows: 1fr 10fr;
        border: 1px rgb(220, 220, 220) solid;
        height: 100%;
    }
    .write-img{
        border-right: 1px rgb(230, 230, 230) solid;
    }
    .write-img:nth-child(1) {
        grid-column: 1 / 2;
        grid-row: 1 / 3;
    }
    .write-img:hover {
        background-color: rgb(200, 200, 200);
    }
    .write-img > img {
        height:100%; 
        width:100%; 
        object-fit: contain;
    }
    .write-img > p {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100%;
        font-size: 2vh;
    }
    .write-btn{
        display: flex;
        align-items: center;
        justify-content: center;
        height: 10%;
    }
    .write-user {
        display: flex;
        align-items: center;
        padding: 2px;
        border-bottom: 1px rgb(230, 230, 230) solid;
    }
    .write-user > img{
        height: 3.5vh; 
        width: 3.5vh; 
        border-radius: 100px;
        margin-left: 10px;
        margin-right: 10px;
    }
    .write-user > div{
        font-size: 1.5vh;
    }
    .write-text {
        border: none;
        width: 100%;
        font-size: 1.5vh;
    }
    .write-text:focus {
        outline: none;
    }
    .write-title {
        height: 10%;
        padding: 10px;
    }
    .write-content {
        resize: none;
        height: 90%;
        border-top: 1px rgb(230, 230, 230) solid;
        padding: 10px;
    }
</style>
