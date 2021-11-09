<template>
    <div class="border-main">
      <div class="border-nav" v-show="current == 'BoardList'">
        <h1 class="imb-font-semi-bold">게시판</h1>
        <i class="fas fa-plus fa-3x" @click="current = 'BoardWrite'"></i>
      </div>
      <div v-show="current == 'BoardWrite'">
        <i class="fas fa-arrow-left fa-3x" @click="current = 'BoardList'"></i>
      </div>
      <keep-alive>
          <component :is="current"></component>
      </keep-alive>
    </div>
</template>

<script>
import BoardList from "./BoardList.vue";
import BoardDetail from "./BoardDetail.vue";
import BoardWrite from "./BoardWrite.vue";
export default {
  components:{
    BoardList,
    BoardDetail,
    BoardWrite
  },
  data:function(){
      return {
          del_password:'',
          current: 'BoardList'
      }
  },props : [
      'hot_table',
  ],methods : {
      del_data(){          
          this.$emit('close')
      },checktest(){
        console.log("come!")
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
  justify-content: space-between;
}
</style>