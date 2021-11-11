<template>
    <div class='detail-box'>
        <div class="detail-img">
            <img :src="info.fileList[0].filePath" style="width: 100%; height:100%; object-fit: contain;" @click="commentGet"/>
        </div>                                 
        <div class="detail-user">
            <img :src="info.profileUrl"/>
            <div>
                <div>{{info.nickName}}</div>
                <p>{{info.content}}</p>
            </div>
        </div>
        <div class="detail-comment-wrap">
            <div class="detail-comment-list" v-for="(list, idx) in commentList" v-bind:key="idx">
                <img :src="list.profileUrl"/>
                <div>
                    <div>{{list.nickName}}</div>
                    <p>{{list.comment}}</p>
                </div>
            </div>
        </div>
        <div class="detail-comment-register">
            <textarea class="detail-comment-write" id="detail-textarea" placeholder="댓글 달기..." v-model="comment" required/>
            <div>
            <p class="detail-comment-register-button" @click="commentRegister">등록</p>
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
            },
            a(){
                console.log(this.info)
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
    *{
        font-family: "IBMPlexSansKR-SemiBold";
    }
    p {
        margin-bottom: 0 !important;
    }
    .detail-img {
        text-align: center;
        vertical-align: middle;
        grid-row: 1 / 4;
        border-right: 1px rgb(230, 230, 230) solid;
        background-color: rgb(250, 250, 250);
    }
    .detail-user,
    .detail-comment-list {
        display: flex;
        align-items: stretch;
        padding: 10px 10px 0 10px;
    }
    .detail-user {
        border-bottom: 1px rgb(230, 230, 230) solid;
        padding-bottom: 10px;
    }
    .detail-user > img,
    .detail-comment-list > img {
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
        width: 100%;
    }
    .detail-title {
        height: auto;
        padding: 10px;
        font-size: 20px;
        margin-bottom: 0 !important;
    }
    .detail-comment {
        margin-bottom: 0 !important;
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
    
</style>
