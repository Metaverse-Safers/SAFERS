<template>
    <div>
        <image-card-list :images="images"/>
    </div>
</template>

<script>

    import axios from 'axios';
    import imageCardList from '@/components/Board/ImageCardList';

    export default{
        components:{
            imageCardList
        },
        methods:{

            async getRandomImages(count){
                try {
                    const {data} = await axios.get(this.url,{
                            headers: {Authorization: 'Client-ID ' + this.accessKey},
                            params: {count}
                        })
                    this.images = data;
                    console.log(this.images)
                } catch (error) {
                    console.error(error)
                }
            }
        },
        mounted(){
            this.getRandomImages(30);
        },
        data(){
            return{
            images:'',
            accessKey:'4MDT6zQdVRosVGXvVBjJbt-uH4BNCTaxbBABjXbDnSU',
            url:'https://api.unsplash.com/photos/random'
            }
        }
    }
</script>

<style>
    
</style>
