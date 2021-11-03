<template>
    <div>
        <div class="icon-bar">
            <img id='sideBarLogo' src='@/assets/images/SafersSideBar.png' @click="goMain"/>
            <i class="fas fa-home" v-b-modal.modal-1></i>
            <i class="fas fa-chalkboard-teacher" v-b-modal.modal-2></i>
            <i class="fas fa-user" v-b-modal.modal-3></i>
            <b-modal 
                id="modal-1" 
                title="게시판" 
                title-class="modalTitle"
                size="xl"
                scrollable= true
                hide-footer= true
                >
                <image-card-list :images="images"/>
                <board-detail :images="image"/>
                <!-- <vue-masonry-gallery :imgsArr="imgsArr" @scrollReachBottom="getData"></vue-masonry-gallery> -->
            </b-modal>
        </div>
        <router-view id='sideBarRouterView'/>
    </div>
</template>
<script>
    import axios from 'axios';
    import imageCardList from '@/components/Board/ImageCardList';
    import boardDetail from '@/components/Board/BoardDetail'

    //import VueMasonryGallery from "vue-masonry-gallery";
    export default {
        components:{
            imageCardList,
            boardDetail
            //VueMasonryGallery
        },
        methods:{
            goMain(){
                this.$router.push({ name: 'main' });
            },
            async getRandomImages(count){
                try {
                    const {data} = await axios.get(this.url,{
                            headers: {Authorization: 'Client-ID ' + this.accessKey},
                            params: {count}
                        })
                    this.images = data;
                } catch (error) {
                    console.error(error)
                }
            },
        },
        mounted(){
            this.getRandomImages(30);
            axios.get('https://k5a403.p.ssafy.io/api/board/list/0')
                .then(res => {  
                    console.log(res)
                })
                .catch(err => {
                    console.log(err);
                });
        },
        data(){
            return{
                imgsArr: '',
                images:'',
                accessKey:'4MDT6zQdVRosVGXvVBjJbt-uH4BNCTaxbBABjXbDnSU',
                url:'https://api.unsplash.com/photos/random'
            }
        }
    }
</script>
<style>
    .icon-bar {
        height: 100%;
        width: 100px;
        border-right: 1px #c86b9825 solid;
        background-color: white;
        position: fixed; /* Fixed Sidebar (stay in place on scroll) */
        /*z-index: 1;*/ /* Stay on top */
        top: 0; /* Stay at the top */
        left: 0;
        overflow-x: hidden; /* Disable horizontal scroll */
        padding-top: 0;
        z-index: 1;
    }
    #sideBarLogo{
        width: 100%;
        margin-top: 5px;
    }
    .icon-bar i {
        display: block;
        text-align: center;
        padding: 16px;
        transition: all 0.3s ease;
        color: #c86b9885;
        font-size: 36px;
    }
    .icon-bar i:hover {
        color: #c86b98;
    }
    .icon-bar i:active {
        color: white;
        background-color: #c86b98;
    }
    #sideBarRouterView{
        margin-left: 120px;
    }
    .modalTitle{
        font-family: 'IBMPlexSansKR-SemiBold';
    }
    .modalBody{
        width: 1138px;
    }

</style>
