<template>
    <div class="main">
        hi  
        <!-- <div class='box'>
            <div id="img">
                <img :src="imageInfo.urls.small" style="height:80vh" v-if='Hw'/>
                <img :src="imageInfo.urls.small" style="width:46.6vw; vertical-align: middle;" v-else/>
            </div>
            <div id="text">
                <p>{{imageInfo.created_at}}</p>
            </div>
        </div> -->
    </div>
</template>

<script>
    export default {
        data() {
            return{
                imageInfo:"",
                Hw: false
            }
        },
        created() {
            this.imageInfo = this.$route.query.image;
            if (this.imageInfo.height > this.imageInfo.width){
                this.Hw = true
            }
        }
    }
</script>
<style>
    .main{
        background-color: rgb(250, 250, 250);
    }
    .box{
        width: 70vw;
        height: 80vh;
        border: 1px rgb(219, 219, 219) solid;
        position:absolute;
        top:50%; left:50%;
        transform: translate(-50%, -50%);
        display: grid;
        grid-template-columns: 2fr 1fr;
    }
    #img{
        width: 100%;
        height: 100%;
        text-align: center;
        line-height: 80vh;
    }
    #img *{
        vertical-align: middle;
    }
    #text{
        width: 100%;
        height: 100%;
        background-color: white;
        border-left: 1px rgb(219, 219, 219) solid;
        border-right: 1px rgb(219, 219, 219) solid;
    }
</style>
