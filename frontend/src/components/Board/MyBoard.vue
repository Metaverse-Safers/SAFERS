<template>
    <div class="my-border-main">
        <div class="board-list" v-show="!boardDetail" >
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
      }
  }
}
</script>

<style>
.my-border-main{
  width:100%;
  padding-top: 10px;
  padding-right: 10px;
  padding-left: 10px;
  overflow-y: auto;
  overflow-x: hidden;
}
</style>