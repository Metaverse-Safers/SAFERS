<template>
  <div class="list-wrap">
    <div class="goback" v-show="boardDetail" >
        <i class="fas fa-arrow-left fa-2x" @click="boardDetailFunc"></i>
      </div>
    <div class="masonry" v-show="!boardDetail">
      <div class="mItem" v-for="(data, idx) in boardList" v-bind:key="idx" >
        <img :src= data.fileList[0].filePath @click="boardDetailInfo(data)">
      </div>
      <infinite-loading @infinite='infiniteHandler'>
        <div 
          slot='no-more'
          style="color:rgb(102,102,102); font-size: 14px; padding:10px 0px;">
          목록의 끝입니다
        </div>
      </infinite-loading>
    </div>
    <div class="detail-wrap" v-if="boardDetail">
      <BoardDetail :info="info"/>
    </div>
  </div>
</template>

<script>
  import axios from "axios";
  import InfiniteLoading from 'vue-infinite-loading';
  import BoardDetail from "./BoardDetail.vue";
  export default {
    components: {
      InfiniteLoading,
      BoardDetail,
    },
    data(){
      return{
        info: [],
        boardDetail: false,
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
      },
      boardDetailInfo(data){
        this.info=data;
        this.boardDetail=true;
        this.$emit('detail',true);
      },
      boardDetailFunc(){
        this.boardDetail=false;
        this.$emit('detail',false);
      }
    }
  }
</script>

<style>
.list-wrap{
  height: 100%;
}

.goback{
  height: 10%;
}

.goback:hover{
  filter: brightness(5%);
  cursor: pointer;
}

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
  padding-top: 10px;
}

.masonry .mItem {
  display: inline-block;
  margin-bottom: 16px;
  width: 100%;
}

.detail-wrap{
  height: 85%;
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