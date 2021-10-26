<template>
  <div class="wrapper">
    <div class="heading">
      <h1>Safers 게시판</h1>
    </div>
    <div class="cards" v-if="images.length">
      <image-card v-for="image in images" :key="image.id" :image="image" @click="detail()" />
    </div>
    <div class="cards-loading" v-else>
      Loading image....
    </div>
  </div>
</template>

<script>
    import imageCard from './ImageCard'

    export default {
        components:{
            imageCard
        },
        props:{
            images: Array
        },
        mounted(){
            this.ab();
        },
        methods:{
            ab(){
                console.log(this.images)
            },
            detail() {
                this.$router.push({name: 'boarddetail'});
            }
        }
    }
</script>

<style>
    .heading, .cards-loading {
        height: auto;
        text-align: center;
    }
    .cards {
        display: grid;
        column-gap: 10px;
        row-gap: 7px;
        grid-template-columns: repeat(3, 400px);
        justify-content: center;
        max-width: var(--card-container-width);
    }
</style>