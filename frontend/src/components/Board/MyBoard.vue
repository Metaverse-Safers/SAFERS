<template>
    <div class="my-border-main">
        <div class="board-list" v-show="!boardDetail">
          <h1 class="imb-font-semi-bold">내 게시물</h1>
        </div>
        <MyBoardList @detail="boardDetailT"/>
    </div>
</template>

<script>
  import MyBoardList from "./MyBoardList.vue";
  export default {
    components:{
      MyBoardList
    },
    data:function(){
        return {
            del_password:'',
            boardDetail: false
        }
    },props : [
        'hot_table',
    ],methods : {
        del_data(){          
            this.$emit('close')
        },checktest(){
          console.log("come!")
        },
        boardDetailT(data){
          this.boardDetail = data;
          this.$forceUpdate;
        }
    }
  }
</script>

<style>
  .my-border-main{
    width:100%;
    height: 100%;
    padding-top: 10px;
    padding-right: 10px;
    padding-left: 10px;
    overflow-y: auto;
    overflow-x: hidden;
  }
  .my-border-main::-webkit-scrollbar {
    width: 5px;
  }
  .my-border-main::-webkit-scrollbar-track {
    background-color: #e4e4e4;
    border-radius: 100px;
  }
  .my-border-main::-webkit-scrollbar-thumb {
    border-radius: 100px;
    background-image: linear-gradient(180deg, #d0368a 0%, #708ad4 99%);
    box-shadow: inset 2px 2px 5px 0 rgba(#fff, 0.5);
  }
</style>