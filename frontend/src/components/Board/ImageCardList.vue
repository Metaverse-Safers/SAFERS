<template>
  <div class="ImageCardListWrapper">
    <div :style="{
        display: 'grid',
        columnGap: '10px',
        rowGap: '7px',
        gridTemplateColumns: 'repeat(' + widthCount + ', 200px)',
        justifyContent: 'left',
        marginLeft: '30px',
      }"
       v-if="images.length">
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
        },
        data() {
          return{
            widthCount: ''
          }
        },
        mounted() {
          this.handleResize();
          window.addEventListener('resize', this.handleResize);
        },
        beforeDestroy() {
          // console.log("beforeDestroy...");
          window.removeEventListener('resize', this.handleResize);
        },
        methods: {
          handleResize() {
              //console.log(window.innerWidth);
              if(window.innerWidth<975)
                this.widthCount=2
              else if(window.innerWidth<1183)
                this.widthCount=3
              else if(window.innerWidth>1183)
                this.widthCount=5
          }
        }
    }
</script>

<style>
    .ImageCardListWrapper{
      height: 100%;
      width: 100%;
    }
    .cards-loading {
        height: auto;
        text-align: left;
        margin-left: 10px;
    }
    
</style>