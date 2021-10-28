<template>
  <div class="wrapper">
    <div class="heading">
      <h1>Safers 게시판</h1>
    </div>
    <div class="cards" v-if="images.length">
      <image-card v-for="image in images" :key="image.id" :image="image" />
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
        grid-template-columns: repeat(5, 200px);
        justify-content: center;
        max-width: var(--card-container-width);
    }
    h1 {
        font-family: 'IBMPlexSansKR-SemiBold';
    }
    
</style>