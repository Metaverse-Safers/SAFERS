<template>
    <div class="main">
        <div class='box'>
            <div id="img">
                <img v-if="img.previewImgUrl" :src="img.previewImgUrl" style="height:80vh; width:46.6vw;"/>
                <input type="file" ref="selectFile" @change="previewFile" accept="image/*" required/>
            </div>
            <div id="text">  
                <textarea v-model="message" placeholder="문구 입력..."></textarea>
                <button class="btn" @click="insertRecord">업로드</button>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from "axios";
    export default {
        data() {
            return{
                imageInfo:"",
                Hw: false,
                img: {
                    selectFile: null,
                    previewImgUrl: null, // 미리보기 이미지 URL
                    isUploading: false, // 파일 업로드 체크
                },
                comment: ""
            }
        },
        created() {
            this.imageInfo = this.$route.query.image;
            if (this.imageInfo.height > this.imageInfo.width){
                this.Hw = true
            }
        },
        methods: {
            previewFile() {
                // 선택된 파일이 있는가?
                if (0 < this.$refs.selectFile.files.length) {
                // 0 번째 파일을 가져 온다.
                    this.img.selectFile = this.$refs.selectFile.files[0]
                    // 마지막 . 위치를 찾고 + 1 하여 확장자 명을 가져온다.
                    let fileExt = this.img.selectFile.name.substring(
                        this.img.selectFile.name.lastIndexOf(".") + 1
                    )
                    // 소문자로 변환
                    fileExt = fileExt.toLowerCase()
                    // 이미지 확장자 체크, 1메가 바이트 이하 인지 체크
                    if (
                        ["jpeg", "png", "gif", "bmp", "jpg"].includes(fileExt) &&
                        this.img.selectFile.size <= 1048576
                        ) {
                            // FileReader 를 활용하여 파일을 읽는다
                            var reader = new FileReader()
                            reader.onload = e => {
                                // base64
                                this.img.previewImgUrl = e.target.result
                            }
                            reader.readAsDataURL(this.img.selectFile)
                        } else if (this.img.selectFile.size <= 1048576) {
                            // 이미지외 파일
                            this.img.previewImgUrl = null
                        } else {
                            this.img.selectFile = null
                            this.img.previewImgUrl = null
                    }
                } else {
                    // 파일을 선택하지 않았을때
                    this.img.selectFile = null
                    this.img.previewImgUrl = null
                }
            },
            insertRecord() {
                axios.post('' + this.user.no, {
                    
                })
                .then(res => {  // eslint-disable-line no-unused-vars
                    this.$router.push('board');
                })
                .catch(err => {
                    console.log(err);
                });
            },

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
        position:relative;
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
    textarea{
        width: 98.5%;
        height: 90%;
    }
    input{
        position: absolute;
        top: 0;
        left: 0;
        z-index: 1;
    }
</style>