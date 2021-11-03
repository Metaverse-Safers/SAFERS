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
            previewFile(e) {
                // 선택된 파일이 있는가?
                if (e.target.files.length > 0) {
                    // 0 번째 파일을 가져 온다.
                    
                    const file = e.target.files[0];
                    // 확장자 명 가져오기
                    let fileExt = file.name.substring(file.name.lastIndexOf(".") + 1); 
                    fileExt = fileExt.toLowerCase()

                    // 이미지 확장자 체크, 3메가 바이트 이하 인지 체크 
                    if(["jpeg", "png", "gif", "bmp", "jpg"].includes(fileExt)
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
            insertRecord() {
                axios.post('/board/list/{0}' + this.user.no, {
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