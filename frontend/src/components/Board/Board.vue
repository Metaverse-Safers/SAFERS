<template>
    <div class="border-main">
      <div class="board-write" v-show="current == 'BoardWrite'">
        <i class="fas fa-arrow-left fa-2x" @click="current = 'BoardList'"></i>
        <h2 class="imb-font-semi-bold">게시물 작성</h2>
      </div>
      <component :is="current" @detail="boardDetailT" @write="boardWrite"></component>
      <div class="right-bottom-fix p-3" v-show="!boardDetail && current != 'BoardWrite'" @click="current = 'BoardWrite'">
          <i class="fas fa-plus fa-2x" ></i>
      </div>
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
    data(){
        return {
            del_password:'',
            current: 'BoardList',
            boardDetail: false
        }
    },
    props: [
        'hot_table',
    ],
    methods: {
        del_data(){          
            this.$emit('close')
        },checktest(){
          console.log("come!")
        },
        boardDetailT(data){
          this.boardDetail = data;
        },
        boardWrite(data){
          this.current = data;
          this.$forceUpdate;
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
  .board-list, 
  .board-write{
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    align-items: center;
    margin-bottom: 10px;
  }
  .board-list > h1,
  .board-write > h2 {
    grid-column: 2/3;
    justify-self: center;
    margin-bottom: 0 !important;
  }
  .board-list > i {
    grid-column: 3/4;
    justify-self: end;
  }
  .board-write > i{
    grid-column: 1/2;
    justify-self: start;
  }
  .board-list > i:hover,
  .board-write > i:hover {
    filter: brightness(5%);
    cursor: pointer;
  }
  .right-bottom-fix{
    position: absolute;
    top: 88%;
    right: 1vw;
    display: inline-block;
    border-radius: 50%;
    width: 70px;
    height: 70px;
    z-index: 999;
    /* background:  #e5e5e5; */
    background: #fff;
    border: 3px solid #e5e5e5;
    align-items: center;
    text-align: center;
  }
  .right-bottom-fix:hover{
    /* background:  #e5e5e5; */
    box-shadow: 0px 0px 3px 3px #e5e5e5;
    cursor: pointer;
  }
  .right-bottom-fix > i{
    width: 100%;
    height: 100%;
  }
</style>