<template>
    <div>
        <form class="boardwrite-container" enctype="multipart/form-data">
            <label class="board-img" className="input-file-button" for="rg-img-selctor">
                <img v-if="img.previewImgUrl" :src="img.previewImgUrl" style="height:100%; width:100%;"/>
                <p v-else style="font-size: 20px">사진 선택하기</p>
            </label>
            <input id="rg-img-selctor" type="file" ref="selectFile" style="display: none" @change="previewFile" accept="image/*" required/>
            <textarea class="board-Text"  placeholder="제목" v-model="boardInfo.title" style="margin-bottom:2px" required/>
            <textarea class="board-Text"  placeholder="문구 입력..." v-model="boardInfo.content" required/>
        </form>
        <div class="upload-btn">
            <img @click="register" style="height:40px" src="@/assets/images/Board-Register_Btn.png"/>
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
    .boardwrite-container{
        display: grid;
        grid-template-columns: 2fr 1fr;
        grid-template-rows: 33px 40vh;
        margin-top: 10px;
        margin-bottom: 20px;
        border: 1px rgb(197, 197, 197) solid;
        padding: 2px;
    }
    .board-img:nth-child(1) {
        /* 1번 라인에서 1칸 */
        grid-column: 1 / span 1;
        /* 1번 라인에서 2칸 */
        grid-row: 1 / span 2;
    }
    .board-img{
        margin-right: 2px;
    }
    .upload-btn{
        text-align: center;
        margin-bottom: 20px;
    }
</style>
