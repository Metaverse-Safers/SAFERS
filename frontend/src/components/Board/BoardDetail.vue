<template>
    <div class="detail-main">
        <div class='detail-box'>
            <div class="detail-img">
                <img :src="info.fileList[0].filePath" style="width: 100%; height:100%; object-fit: contain;" @click="a"/>
            </div>                                 
            <div class="detail-user">
                <img :src="info.profileUrl"/>
                <div class="imb-font-semi-bold">{{info.nickName}}</div>
            </div>
            <div class="detail-text">
                <p class="imb-font-semi-bold detail-title">{{info.title}}</p>
                <p class="imb-font-semi-bold detail-content">{{info.content}}</p>
            </div>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from "vuex";
    export default {
        data() {
            return{
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
            a(){
                console.log(this.info)
            }
        },
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
    }
    .detail-content {
        height: 80%;
        border-top: 1px rgb(230, 230, 230) solid;
        padding: 10px;
    }
</style>
