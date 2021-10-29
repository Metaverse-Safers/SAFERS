<template>
  <div class="wrapper">
    <div class="heading">
      <h1>게시판</h1>
    </div>
    <div :style="{
        display: 'grid',
        columnGap: '10px',
        rowGap: '7px',
        gridTemplateColumns: 'repeat(' + widthCount + ', 200px)',
        justifyContent: 'left',
        marginLeft: '10px',
        maxWidth: 'var(--card-container-width)'
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
              console.log(window.innerWidth);
              if(window.innerWidth<550)
                this.widthCount=1
              else if(window.innerWidth<760)
                this.widthCount=2
              else if(window.innerWidth<970)
                this.widthCount=3
              else if(window.innerWidth<1180)
                this.widthCount=4
              else if(window.innerWidth<1390)
                this.widthCount=5
              else if(window.innerWidth<1600)
                this.widthCount=6
              else if(window.innerWidth<1810)
                this.widthCount=7
              else if(window.innerWidth<2020)
                this.widthCount=8
              else if(window.innerWidth<2230)
                this.widthCount=9
          }
        }
    }
</script>

<style>
    .heading, .cards-loading {
        height: auto;
        text-align: left;
        margin-left: 10px;
    }
    h1 {
        font-family: 'IBMPlexSansKR-SemiBold';
    }
    
</style>