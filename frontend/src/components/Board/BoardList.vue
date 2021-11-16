<template>
  <div class="list-wrap">
    <!-- <div class="list-nav" v-show="boardDetail" > -->
      <!-- <i class="fas fa-arrow-left fa-2x go-back" @click="boardDetailFunc"></i> -->
      <!-- <h2 class="imb-font-semi-bold">{{info.title}}</h2> -->
      <!-- <i class="far fa-trash-alt fa-2x board-delete" @click="boardDelete" v-if="info.isMine"></i> -->
    <!-- </div> -->
    <div class="masonry" v-show="!boardDetail">
      <div class="mItem" v-for="(data, idx) in boardList" v-bind:key="idx" @click="boardDetailInfo(data)">
        <img :src= data.fileList[0].filePath class="board-list-image-img">
        <div class="board-list-image-overlay p-3">
          <p class="board-list-image-title imb-font-semi-bold">{{data.title}}</p>
          <p class="board-list-image-description imb-font-regular">
            {{data.nickName}}
          </p>
        </div>
      </div>
    </div>
    <infinite-loading ref="infiniteLoading" @infinite='infiniteHandler' spinner="bubbles" v-show="!boardDetail">
      <div 
        slot='no-more'
        style="color:rgb(100,100,100); font-size: 15px; padding:0px 0px 10px 0px;">
        목록의 끝입니다
      </div>
    </infinite-loading>
    <div class="board-detail" v-if="boardDetail">
      <BoardDetail :info="info" v-on:comeback="comeBack"/>
    </div>
    <div class="left-bottom-fix p-3" v-show="boardDetail" @click="boardDetailFunc">
      <i class="fas fa-arrow-left fa-2x go-back"></i>
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
      async comeBack(){
        this.boardDetail = false;
        this.boardDetailFunc();
        this.infiniteScrollRefresh();
        this.$refs.infiniteLoading.stateChanger.reset();
      },
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
.board-list-image-img{
  display: block;
  width: 100%;
  height: 100%;
  background-size: cover;
}

.board-list-image-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgb(0, 0, 0, 0.6);
  border-radius: 10px;
  color: #ffffff;
  display: flex;
  flex-direction: column;
  /* align-items: center;
  justify-content: center; */
  transition: opacity 0.25s;
}

.board-list-image-overlay {
  opacity: 0;
}

.board-list-image-overlay:hover {
  opacity: 1;
}

.board-list-image-title{
  font-size: 1.8vh;
  word-break: keep-all;
}

.board-list-image-description{
  font-size: 1.4vh;
  position:absolute;
  right: 1vw;
  bottom: 0;
}

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

.mItem{
  position: relative;
}

.mItem > img {
  width: 100%;
  border-radius: 10px;
}

.mItem:hover,
.mItem > img:hover {
  filter: brightness(70%);
  color: white;
  cursor: pointer;
}

.masonry {
	column-count: 6;
	column-gap: 16px;
  padding-top: 10px;
  border-top: none !important;
}

.masonry-title{
  position: absolute;
  top: 1vh;
  left: 1vw;
  right: 1vh;
  padding-right: 1vh;
  width: 90%;
  color: white;
  z-index: 999;
}

.text-overflow-dllipisis{
  display: inline-block;
  text-overflow: ellipsis;
  display: -webkit-box;
  word-break: keep-all;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  font-size: 2vh;
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