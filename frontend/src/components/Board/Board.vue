<template>
    <div class="border-main">
      <div v-show="current == 'BoardList'">
        <div class="border-nav" v-show="!boardDetail">
          <h1 class="imb-font-semi-bold">게시판</h1>
          <i class="fas fa-plus fa-2x align-middle" @click="current = 'BoardWrite'"></i>
        </div>
      </div>
      <div class="goback" v-show="current == 'BoardWrite'">
        <i class="fas fa-arrow-left fa-2x" @click="current = 'BoardList'"></i>
      </div>
      <keep-alive>
          <component :is="current" @detail="boardDetailT"></component>
      </keep-alive>
    </div>
</template>

<script>
import BoardList from "./BoardList.vue";
import BoardWrite from "./BoardWrite.vue";
export default {
  components:{
    BoardList,
    BoardWrite
  },
  data:function(){
      return {
          del_password:'',
          current: 'BoardList',
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
      boardDetailT(toggle){
        this.boardDetail = toggle;
      }
  }
}
</script>

<style>
.border-main{
  width:100%;
  height: 100%;
  padding-top: 10px;
  padding-right: 10px;
  padding-left: 10px;
  overflow-y: auto;
  overflow-x: hidden;
}
.goback{
  height: 10%;
}
.border-main::-webkit-scrollbar {
  width: 5px;
}
.border-main::-webkit-scrollbar-track {
  background-color: #e4e4e4;
  border-radius: 100px;
}
.border-main::-webkit-scrollbar-thumb {
  border-radius: 100px;
  background-image: linear-gradient(180deg, #d0368a 0%, #708ad4 99%);
  box-shadow: inset 2px 2px 5px 0 rgba(#fff, 0.5);
}
.border-nav{
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: 1px rgb(220, 220, 220) solid;
}
.border-nav > i:hover{
  filter: brightness(5%);
  cursor: pointer;
}
.goback:hover{
  filter: brightness(5%);
  cursor: pointer;
}
</style>