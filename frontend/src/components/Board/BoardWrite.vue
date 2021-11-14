<template>
    <div class="write-wrap">
        
        <form class="write-box" enctype="multipart/form-data">
            <div class="write-img">
                <Swiper class="write-swiper" :options="swiperOption" v-if="previewImgUrls">
                    <SwiperSlide class="write-swiper-slide" v-for="(data, idx) in previewImgUrls" v-bind:key="idx">
                            <img :src="data" class="write-swiper-img"/>
                    </SwiperSlide>
                    <div class="swiper-pagination" slot="pagination"></div>
                    <div class="swiper-button-prev" slot="button-prev"></div>
                    <div class="swiper-button-next" slot="button-next"></div>
                </Swiper>
                <label className="input-file-button" for="rg-img-selctor">
                    <p class="imb-font-semi-bold write-img-selector">사진 선택</p>
                </label>
                <input id="rg-img-selctor" type="file" ref="selectFile" multiple style="display: none" @change="previewFile" accept="image/*" required/>
            </div>
            <div class="write-user">
                <img :src="userProfile.profileUrl"/>
                <div class="imb-font-semi-bold">{{userProfile.nickName}}</div>
            </div>
            <div>
                <input class="imb-font-semi-bold write-text write-title"  placeholder="제목..." v-model="boardInfo.title" required/>
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
    import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
    import 'swiper/css/swiper.css'
    export default {
        components: {
            Swiper,
            SwiperSlide
        },
        data() {
            return{
                userInfo: {},
                boardInfo:{
                    title: "",
                    content: ""
                },
                selectFiles:[],
                previewImgUrls:[],
                swiperOption: {
                    slidesPerView: 1,
                    spaceBetween: 30,
                    loop: true,
                    pagination: {
                        el: '.swiper-pagination',
                        clickable: true
                    },
                    navigation: {
                        nextEl: '.swiper-button-next',
                        prevEl: '.swiper-button-prev'
                    }
                }
            }
        },
        methods: {
            previewFile(e) {
                this.selectFiles=[];
                this.previewImgUrls=[];
                // 선택된 파일이 있는가?
                if (e.target.files.length > 0) {
                    for(var i=0; i<e.target.files.length; i++){
                        // i 번째 파일을 가져 온다.
                        var file = e.target.files[i];
                        // 확장자 명 가져오기
                        var fileExt = file.name.substring(file.name.lastIndexOf(".") + 1); 
                        fileExt = fileExt.toLowerCase()
                        // 이미지 확장자 체크, 3메가 바이트 이하 인지 체크 
                        if(["jpeg", "png", "gif", "bmp", "jpg", "jfif"].includes(fileExt)
                                && file.size <= 3145728){
                            this.selectFiles.push(file);
                            this.previewImgUrls.push(URL.createObjectURL(file));
                        }
                        else {
                            alert("3MB 이하의 이미지 파일만 가능합니다.");
                        }
                    }
                }
            },  
            register() {
                const uploadBoard = new FormData();
                uploadBoard.append("title", this.boardInfo.title);
                uploadBoard.append("userId", this.userInfo.id);
                for (var i = 0; i < this.selectFiles.length; i++){
                    uploadBoard.append("fileList", this.selectFiles[i]);
                }
                uploadBoard.append("content", this.boardInfo.content);
                axios.post('/api/board', uploadBoard,  { headers: { 'Content-Type': 'multipart/form-data' } })
                .then(res => {  // eslint-disable-line no-unused-vars
                    this.$fire({title: "등록 되었습니다!", text: "완료", type: "success", timer: 1000, showConfirmButton: false})
                    this.boardInfo.title="";
                    this.boardInfo.content="";
                    this.selectFiles=[];
                    this.previewImgUrls=[];
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
        grid-column: 1 / 2;
        grid-row: 1 / 3;
    }
    .write-swiper {
        width: 100%;
        height: 100%;
        text-align: center;
        vertical-align: middle;
        border-right: 1px rgb(230, 230, 230) solid;
        background-color: rgb(250, 250, 250);
    }
    .write-swiper-slide {
        width: 100% !important;
    }
    .write-swiper-img {
        height:100%; 
        width:100%; 
        object-fit: contain;
    }
    .write-img-selector {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100%;
        font-size: 1.5vh;
    }
    .write-img-selector:hover {
        color: rgb(200, 200, 200);
        cursor: pointer;
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
        font-family: "IBMPlexSansKR-Regular";
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
        overflow: auto;
        height: 90%;
        border-top: 1px rgb(230, 230, 230) solid;
        padding: 10px;
    }
    .write-content::-webkit-scrollbar {
        display: none;
    }
</style>
