<template>
  <div class="list-wrap">
    <div class="list-nav" v-if="boardDetail">
    </div>
    <div class="masonry" v-if="!boardDetail">
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
    <infinite-loading @infinite='infiniteHandler' :identifier="infiniteId" spinner="bubbles" v-show="!boardDetail">
      <div 
        slot='no-more'
        style="color:rgb(100,100,100); font-size: 15px; padding:0px 0px 10px 0px;">
        목록의 끝입니다
      </div>
    </infinite-loading>
    <div class="board-detail" v-if="boardDetail">
      <MyBoardDetail v-if="!editT" :info="info" v-on:comeback="comeBack" @edit="editFunc"/>
      <MyBoardEdit v-else :info="info" @list="listFunc"/>
    </div>
    <div class="left-bottom-fix p-3" v-if="boardDetail" @click="boardDetailFunc">
      <i class="fas fa-arrow-left fa-2x go-back"></i>
    </div>
  </div>
</template>

<script>
  import axios from "axios";
  import InfiniteLoading from 'vue-infinite-loading';
  import MyBoardDetail from "./MyBoardDetail.vue";
  import MyBoardEdit from "./BoardEdit.vue";
  import { mapGetters } from "vuex";
  export default {
    components: {
      InfiniteLoading,
      MyBoardDetail,
      MyBoardEdit
    },
    data(){
      return{
        info: [],
        boardDetail: false,
        boardList: [],
        page: 0,
        infiniteId: +new Date(),
        editT: false
      }
    },
    computed: {
        ...mapGetters({
            userProfile: "user/userProfile"
        })
    },
    methods:{
      editFunc() {
        this.editT = true;
      },
      listFunc() {
        this.editT = false;
        this.boardDetail = false;
        this.comeBack();
        this.$emit('detail',false);
      },
      async comeBack(){
        this.boardDetail = false;
        this.boardDetailFunc();
        this.infiniteScrollRefresh();
        this.$refs.infiniteLoading.stateChanger.reset();
      },
      infiniteHandler($state){
        setTimeout(1000);
        axios
          .get('/api/board/' + this.page + '/' + this.userProfile.id)
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
      },
      boardDetailFunc(){
        if(this.editT)
          this.editT = false;
        else{
          this.boardDetail = false;
          this.$emit('detail',false);
        }
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
  .board-delete {
    justify-self: end;
    color: #5f0000;
  }
  .board-delete:hover {
    color: #ff0000;
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