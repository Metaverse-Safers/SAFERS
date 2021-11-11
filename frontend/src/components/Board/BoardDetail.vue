<template>
    <div class="detail-main">
        <div class='detail-box'>
            <div class="detail-img">
                <img :src="info.fileList[0].filePath" style="width: 100%; height:100%; object-fit: contain;" @click="a"/>
            </div>                                 
            <div class="detail-user">
                <img :src="info.profileUrl"/>
                <div>{{info.nickName}}</div>
            </div>
            <div class="detail-text">
                <p class="detail-title">{{info.title}}</p>
                <p class="detail-content">{{info.content}}</p>
                <div class="detail-comment-list" v-for="(list, idx) in commentList" v-bind:key="idx">
                    <img :src="list.profileUrl"/>
                    <div>{{data.nickName}}</div>
                    <br>
                    <p class="detail-content">{{data.content}}</p>
                </div>
                <div class="detail-comment-register">
                    <input class="detail-comment-write" placeholder="댓글 달기..." v-model="comment" required/>
                    <p class="detail-comment-register-button" @click="commentRegister">등록</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
    import { mapGetters } from "vuex";
    export default {
        data() {
            return{
                comment: "",
                commentList: {}
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
                    console.log(this.commentList)
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
                    console.log("성공")
                    this.commentGet();
                })
                
            },
            a(){
                console.log(this.info)
            }
        },
        mounted(){
            
        }
    }
</script>
<style>
    .detail-main{
        height: 100%;
    }
    .detail-box{
        border: 1px rgb(220, 220, 220) solid;
        display: grid;
        grid-template-columns: 2fr 1fr;
        grid-template-rows: 1fr 10fr;
        height:100%
    }
    .detail-box *{
        font-family: "IBMPlexSansKR-SemiBold";
    }
    .detail-img{
        text-align: center;
        vertical-align: middle;
        grid-row: 1 / 3;
        border-right: 1px rgb(230, 230, 230) solid;
        background-color: rgb(250, 250, 250);
    }
    .detail-user{
        display: flex;
        align-items: center;
        padding: 2px;
        border-bottom: 1px rgb(230, 230, 230) solid;
    }
    .detail-user > img{
        height: 3.5vh; 
        width: 3.5vh; 
        border-radius: 100px;
        margin-left: 10px;
        margin-right: 10px;
    }
    .detail-user > div{
        font-size: 1.5vh;
    }
    .detail-text{
        width: 100%;
    }
    .detail-title {
        height: auto;
        padding: 10px;
        font-size: 20px;
        margin-bottom: 0 !important;
    }
    .detail-content {
        height: auto;
        border-top: 1px rgb(230, 230, 230) solid;
        padding: 10px;
        margin-bottom: 0 !important;
    }
    .detail-comment-register {
        display: flex;
        align-items: center;
        padding: 2px;
        border-top: 1px rgb(230, 230, 230) solid;
    }
    .detail-comment-write {
        border: none;
        width: 100%;
        font-size: 1.5vh;
    }
    .detail-comment-write:focus {
        outline: none;
    }
    .detail-comment-register-button {
        margin-bottom: 0 !important;
    }
    
</style>
