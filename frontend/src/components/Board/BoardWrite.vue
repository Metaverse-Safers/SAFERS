<template>
    <div class="main">
        <div class='box'>
            
        </div>
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
    }
    
</style>