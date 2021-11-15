<template>
  <div class="list-wrap">
    <div class="list-nav" v-show="boardDetail" >
      <i class="fas fa-arrow-left fa-2x go-back" @click="boardDetailFunc"></i>
      <h2 class="imb-font-semi-bold">{{info.title}}</h2>
      <i class="far fa-trash-alt fa-2x board-delete" @click="boardDelete" v-if="info.isMine"></i>
    </div>
    <div class="masonry" v-show="!boardDetail">
      <div class="mItem" v-for="(data, idx) in boardList" v-bind:key="idx" >
        <img :src= data.fileList[0].filePath @click="boardDetailInfo(data)">
      </div>
    </div>
    <infinite-loading @infinite='infiniteHandler' spinner="bubbles" v-show="!boardDetail">
      <div 
        slot='no-more'
        style="color:rgb(100,100,100); font-size: 15px; padding:0px 0px 10px 0px;">
        목록의 끝입니다
      </div>
    </infinite-loading>
    <div class="board-detail" v-if="boardDetail">
      <BoardDetail :info="info"/>
    </div>
  </div>
</template>

<script>
  import axios from "axios";
  import InfiniteLoading from 'vue-infinite-loading';
  import BoardDetail from "./BoardDetail.vue";
  import { mapGetters } from "vuex";
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
    computed: {
        ...mapGetters({
            userProfile: "user/userProfile"
        })
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
                  if(res.data[i].fileList[0].filePath){
                    if(res.data[i].userId == this.userProfile.id)
                      res.data[i].isMine = true;
                    else
                      res.data[i].inMine = false;
                    this.boardList.push(res.data[i]);
                  }

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
        console.log(this.info.isMine)
      },
      boardDetailFunc(){
        this.boardDetail=false;
        this.$emit('detail',false);
      },
      infiniteScrollRefresh(){
        this.page = 0;
        this.boardList = [];
        this.infiniteId += 1 
      },
      async boardDelete(){
        var confirm = false;
        await this.$fire({title: "삭제하시겠어요?", type: "question", timer: 9999999, showCancelButton: true})
        .then(function(result) {if(result.value) confirm = true})
        if(confirm){
            this.$fire({title: "삭제 되었습니다!", text: "삭제 완료", type: "success", timer: 1000, showConfirmButton: false})
            this.boardDetailFunc();
            axios
            .patch('/api/board/delete/' + this.info.id)
            .then(res => { // eslint-disable-line no-unused-vars
            })
            this.infiniteScrollRefresh();
        }
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
  justify-self: center;
  margin-bottom: 0 !important;
}

.go-back {
  justify-self: start;
}

.go-back:hover {
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