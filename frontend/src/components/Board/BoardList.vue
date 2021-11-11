<template>
  <div class="list-wrap">
    <div class="list-nav" v-show="boardDetail" >
      <i class="fas fa-arrow-left fa-2x" @click="boardDetailFunc"></i>
      <h2 class="imb-font-semi-bold">{{info.nickName}} 님의 게시물</h2>
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
    <div class="board-detail" v-if="boardDetail">
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

.list-nav {
  display: grid;
  grid-template-columns: 1fr 11fr 1fr;
  align-items: center;
  margin-bottom: 10px;
}

.list-nav > h2 {
  grid-column: 2/3;
  justify-self: center;
  margin-bottom: 0 !important;
}

.list-nav > i {
  grid-column: 1/2;
  justify-self: start;
}

.list-nav > i:hover{
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
  border-top: 1px rgb(220, 220, 220) solid;
}

.masonry .mItem {
  display: inline-block;
  margin-bottom: 16px;
  width: 100%;
}

.board-detail{
  height: 85%;
}
@media (max-width: 1600px) {
  .masonry {
    column-count: 5;
  }
}

@media (max-width: 1200px) {
  .masonry {
    column-count: 4;
  }
}

@media (max-width: 800px) {
  .masonry {
    column-count: 3;
  }
}

@media (max-width: 400px) {
  .masonry {
    column-count: 2;
  }
}


</style>