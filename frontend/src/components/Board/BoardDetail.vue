<template>
    <div class='detail-box mt-4'>
        <Swiper class="detail-swiper" :options="swiperOption" @click="commentGet">
            <SwiperSlide v-for="(data, idx) in info.fileList" v-bind:key="idx">
                <img :src="data.filePath" class="detail-swiper-img"/>
            </SwiperSlide>
            <div class="swiper-pagination" slot="pagination"></div>
            <div class="swiper-button-prev" slot="button-prev"></div>
            <div class="swiper-button-next" slot="button-next"></div>
        </Swiper>      
        <div class="imb-font-semi-bold p-3">
            {{info.title}}
        </div>                           
        <div class="detail-user">
            <img :src="info.profileUrl"/>
            <div>
                <div class="imb-font-semi-bold">{{info.nickName}}</div>
                <p class="imb-font-semi-bold detail-text">{{info.content}}</p>
            </div>
        </div>
        <div class="detail-comment-wrap">
            <div class="detail-comment-list" v-for="(list, idx) in commentList" v-bind:key="idx">
                <div class="detail-comment">
                    <img :src="list.profileUrl"/>
                    <div>
                        <div class="imb-font-semi-bold">{{list.nickName}}</div>
                        <p class="imb-font-semi-bold detail-text">{{list.comment}}</p>
                    </div>
                </div>
                <div>
                    <i class="far fa-times fa-1x detail-comment-delete-button" v-show="list.mine" @click="commentDelete(list.id)"></i>
                </div>
            </div>
        </div>
        <div class="detail-comment-register">
            <textarea class="imb-font-semi-bold detail-comment-write detail-text" id="detail-textarea" placeholder="댓글 달기..." v-model="comment" required/>
            <div class="p-3">
                <p class="imb-font-semi-bold detail-comment-register-button" @click="commentRegister">등록</p>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
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
                comment: "",
                commentList: {},
                swiperOption: {
                    slidesPerView: 1,
                    spaceBetween: 30,
                    loop: false,
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
        props: {
            info: []
        },
        computed: {
            ...mapGetters({
                userProfile: "user/userProfile"
            })
        },
        methods:{
            commentGet() {
                axios
                .get('/api/board/comment/' + this.info.id)
                .then(res => {
                    this.commentList = res.data
                    for(var i=0 ; i<this.commentList.length; i++){
                        if (this.commentList[i].userId == this.userProfile.id) 
                            this.commentList[i].mine = true;
                        else
                            this.commentList[i].mine = false;
                    }
                })
            },
            commentRegister() {
                const uploadComment = new FormData();
                uploadComment.append("board_id", this.info.id);
                uploadComment.append("comment", this.comment);
                uploadComment.append("userId", this.userProfile.id);
                axios
                .post('/api/board/comment/' + this.info.id, uploadComment)
                .then(res => { // eslint-disable-line no-unused-vars
                    this.commentGet();
                })
                document.getElementById("detail-textarea").value='';
                this.comment = "";
            },
            commentDelete(id) {
                axios
                .patch('/api/board/comment/delete/' + id)
                .then(res => { // eslint-disable-line no-unused-vars
                    this.commentGet();
                })
            }
        },
        mounted(){
            this.commentGet();
        }
    }
</script>
<style>
    .detail-box {
        border: 1px rgb(220, 220, 220) solid;
        display: grid;
        grid-template-columns: 2fr 1fr;
        grid-template-rows: 1fr 9fr 1fr;
        height:100%
    }
    .detail-swiper {
        width: 100%;
        text-align: center;
        vertical-align: middle;
        grid-row: 1 / 4;
        border-right: 1px rgb(230, 230, 230) solid;
        background-color: rgb(250, 250, 250);
    }
    .detail-swiper-img {
        width: 100%; 
        height:100%; 
        object-fit: contain;
    }
    .detail-user {
        display: flex;
        align-items: stretch;
        padding: 10px 10px 0 10px;
        border-bottom: 1px rgb(230, 230, 230) solid;
        padding-bottom: 10px;
    }
    .detail-comment-list {
        display: flex;
        align-items: stretch;
        justify-content: space-between;
        padding: 10px 10px 0 10px;
    }
    .detail-user > img,
    .detail-comment > img {
        height: 3.5vh; 
        width: 3.5vh; 
        border-radius: 100px;
        margin-right: 10px;
    }
    .detail-user > div,
    .detail-comment-list > div{
        font-size: 1.5vh;
    }
    .detail-text{
        font-family: "IBMPlexSansKR-Regular";
        margin-bottom: 0 !important;
    }
    .detail-title {
        height: auto;
        padding: 10px;
        font-size: 20px;
        margin-bottom: 0 !important;
    }
    .detail-comment {
        margin-bottom: 0 !important;
        display: flex;
    }
    .detail-comment-wrap {
        overflow: auto;
    }
    .detail-comment-wrap::-webkit-scrollbar {
        display: none;
    }
    .detail-comment-register {
        display: flex;
        align-items: center;
        padding: 0 2px;
        border-top: 1px rgb(230, 230, 230) solid;
        border-right: 1px rgb(230, 230, 230) solid;
    }
    .detail-comment-write {
        border: none;
        resize: none;
        overflow: auto;
        width: 100%;
        font-size: 1.5vh;
    }
    .detail-comment-write::-webkit-scrollbar {
        display: none;
    }
    .detail-comment-write:focus {
        outline: none;
    }
    .detail-comment-register-button {
        width: max-content;
        margin-bottom: 0 !important;
        color: #c289c5;
    }
    .detail-comment-register-button:hover {
        color: #632b6c;
        cursor: pointer;
    }
    .detail-comment-delete-button {
        color: #5f0000;
        font-weight: 900 !important;
    }
    .detail-comment-delete-button:hover {
        color: #ff0000;
        cursor: pointer;
    }
    
</style>
