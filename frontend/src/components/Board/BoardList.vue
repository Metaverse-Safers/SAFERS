<template>
  <div>
    <div class="masonry">
      <div class="mItem" v-for="(data, idx) in boardList" v-bind:key="idx" >
        <!-- @click="detail(data.chlgNo)" -->
        <img :src= data.fileList[0].filePath>
      </div>
      <infinite-loading @infinite='infiniteHandler'>
      <div 
        slot='no-more'
        style="color:rgb(102,102,102); font-size: 14px; padding:10px 0px;">
        목록의 끝입니다
      </div>
    </infinite-loading>

    </div>
    
  </div>
</template>

<script>
  import axios from "axios";
  import InfiniteLoading from 'vue-infinite-loading';
  export default {
    components: {
      InfiniteLoading,
    },
    data(){
      return{
        boardList: [],
        page: 0
      }
    },
    methods:{
      infiniteHandler($state){
        setTimeout(1000);
        axios
          .get('/api/board/list/' + this.page)
          .then(res => {
            if(res.data.length == 0){
              $state.complete();
            }
            else{
              setTimeout(() => {
                for(let i=0; i<res.data.length; i++)
                {
                  if(res.data[i].fileList[0].filePath)
                    this.boardList.push(res.data[i]);
                }
                this.page++;
                $state.loaded();
              },700)
              
            }
          })
          .catch(err => {
            console.log(err);
          });
      }
    }
  }
</script>

<style>
.mItem > img {
  width: 100%;
  border-radius: 10px;
}

.mItem > img:hover {
  filter: brightness(70%);
  cursor: pointer;
}

.masonry {
	column-count: 6;
	column-gap: 16px;
}

.masonry .mItem {
  display: inline-block;
  margin-bottom: 16px;
  width: 100%;
}

@media (max-width: 1199px) {
  .masonry {
    column-count: 3;
  }
}

@media (max-width: 991px) {
  .masonry {
    column-count: 2;
  }
}

@media (max-width: 767px) {
  .masonry {
    column-count: 1;
  }
}


</style>