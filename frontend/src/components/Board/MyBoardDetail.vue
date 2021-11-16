<template>
  <div class="pt-4">
    <div class="row board-detail-title mb-2">
      <div class="col-8 pb-1">
        <img :src="info.profileUrl" align="left" hspace="10" class="user-profile-board"/>
        <h5 class="imb-font-semi-bold bottom-zero-h5">{{info.title}}</h5>
        <p class="imb-font-regular">{{info.nickName}}</p>
      </div>
      <div class="col-4 is-mine-style">
        <i class="far fa-trash-alt fa-2x board-delete" @click="boardDelete" v-if="info.isMine"></i>
      </div>
    </div>
    <div class="p-2">
      <div class="row line-top line-bottom line-left line-right">
        <div class="col-8 board-detail-main bg-light">
          <Swiper class="detail-swiper" :options="swiperOption" @click="commentGet">
              <SwiperSlide v-for="(data, idx) in info.fileList" v-bind:key="idx">
                  <img :src="data.filePath" class="detail-swiper-img"/>
              </SwiperSlide>
              <div class="swiper-pagination" slot="pagination" v-if="singleFileCheck"></div>
              <div class="swiper-button-prev" slot="button-prev" v-if="singleFileCheck"></div>
              <div class="swiper-button-next" slot="button-next" v-if="singleFileCheck"></div>
          </Swiper>
        </div>
        <div class="col bg-light pt-2">
          <div class="row board-detail-content imb-font-regular">{{info.content}}</div>
          <div class="row line-top detail-comment-wrap imb-font-regular pt-2">
            <div class="detail-comment-list" v-for="(list, idx) in commentList" v-bind:key="idx">
                  <div class="detail-comment">
                      <img :src="list.profileUrl"/>
                      <div>
                          <div class="imb-font-semi-bold">{{list.nickName}}</div>
                          <p class="imb-font-semi-bold detail-text">{{list.comment}}</p>
                      </div>
                  </div>
                  <div>
                    <i class="far fa-times fa-1x detail-comment-delete-button" v-show="list.mine" @click="commentDelete(list.id)"></i>
                  </div>
                  
              </div>
          </div>
          <div class="row">
            <div class="detail-comment-register">
              <input type="text" class="imb-font-semi-bold detail-comment-write detail-text" id="detail-textarea" placeholder="댓글 달기..." v-model="comment" required/>
              <div>
                <button class="btn imb-font-semi-bold detail-comment-register-button bg-light mt-2" @click="commentRegister">등록</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapGetters } from "vuex";
import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
export default {
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      comment: "",
      commentList: {},
      swiperOption: {
        slidesPerView: 1,
        spaceBetween: 30,
        loop: false,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      },
    };
  },
  props: {
    info: [],
  },
  computed: {
    ...mapGetters({
      userProfile: "user/userProfile",
    }),
    singleFileCheck(){
      if (this.info.fileList.length == 1)
        return false;
      return true;
    }
  },
  methods: {
    commentGet() {
      axios.get("/api/board/comment/" + this.info.id).then((res) => {
        this.commentList = res.data;
        for (var i = 0; i < this.commentList.length; i++) {
          if (this.commentList[i].userId == this.userProfile.id)
            this.commentList[i].mine = true;
          else this.commentList[i].mine = false;
        }
      });
    },
    commentRegister() {
      const uploadComment = new FormData();
      uploadComment.append("board_id", this.info.id);
      uploadComment.append("comment", this.comment);
      uploadComment.append("userId", this.userProfile.id);
      axios
        .post("/api/board/comment/" + this.info.id, uploadComment)
        .then((res) => {
          // eslint-disable-line no-unused-vars
          this.commentGet();
          console.log(res);
        });
      document.getElementById("detail-textarea").value = "";
      this.comment = "";
    },
    commentDelete(id) {
      axios.patch("/api/board/comment/delete/" + id).then((res) => {
        // eslint-disable-line no-unused-vars
        this.commentGet();
        console.log(res);
      });
    },
    async boardDelete(){
      const $this = this;
      await this.$fire({title: "삭제하시겠어요?", type: "question", timer: 9999999, showCancelButton: true})
      .then(function(result) {
        if(result.value) {
          axios
          .patch('/api/board/delete/' + $this.info.id)
          .then(res => { // eslint-disable-line no-unused-vars
            $this.$fire({title: "삭제 되었습니다!", text: "삭제 완료", type: "success", timer: 1000, showConfirmButton: false});
            $this.$emit("comeback");
          })
        }
      })
    }
  },
  mounted() {
    this.commentGet();
  },
};
</script>
<style>
.detail-box {
  border: 1px rgb(220, 220, 220) solid;
  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-rows: 1fr 9fr 1fr;
  height: 100%;
}
.board-delete{
  margin-right: 1vw;
  width: 24px;
  height: 24px;
}
.board-detail-title{
  height: 6vh;
}
.bottom-zero-h5{
  padding-bottom: 0px !important;
  line-height: 0.5;
  margin-top: 10px;
}
.board-detail-main{
  height: 55vh;
}
.detail-swiper {
  height: 100%;
  text-align: center;
  vertical-align: middle;
  grid-row: 1 / 4;
  border-right: 1px rgb(230, 230, 230) solid;
  background-color: rgb(250, 250, 250);
}
.detail-swiper-img {
  width: 100%;
  height: 100%;
  object-fit: contain;
}
.detail-user {
  display: flex;
  align-items: stretch;
  padding: 10px 10px 0 10px;
  border-bottom: 1px rgb(230, 230, 230) solid;
  padding-bottom: 10px;
}
.detail-comment-list {
  display: flex;
  align-items: stretch;
  justify-content: space-between;
  padding: 10px 10px 0 10px;
}
.user-profile-board{
  width:55px;
  height:55px;
  border-radius: 50%;
}
.detail-user > img,
.detail-comment > img {
  height: 3.5vh;
  width: 3.5vh;
  border-radius: 100px;
  margin-right: 10px;
}
.detail-user > div,
.detail-comment-list > div {
  font-size: 1.5vh;
}
.detail-text {
  font-family: "IBMPlexSansKR-Regular";
  margin-bottom: 0 !important;
}
.board-detail-content{
  height: 40%;
  padding-right: 0.7vw;
  word-break: keep-all;
  overflow: auto;
}
.detail-title {
  height: auto;
  padding: 10px;
  font-size: 20px;
  margin-bottom: 0 !important;
}
.detail-comment {
  margin-bottom: 0 !important;
  display: flex;
}
.detail-comment-wrap {
  overflow: auto;
  height: 50%;
}
.board-detail-content::-webkit-scrollbar,
.detail-comment-wrap::-webkit-scrollbar {
  display: none;
}
.detail-comment-register {
  display: flex;
  align-items: center;
  height: 10%;
  padding: 0 2px;
  border-top: 1px rgb(230, 230, 230) solid;
  /* border-right: 1px rgb(230, 230, 230) solid; */
}
.detail-comment-write {
  border: none;
  resize: none;
  overflow: auto;
  width: 100%;
  font-size: 1.5vh;
  height: 100%;
  background-color:transparent;
}
.detail-comment-write::-webkit-scrollbar {
  display: none;
}
.detail-comment-write:focus {
  outline: none;
}
.detail-comment-register-button {
  width: max-content;
  margin-bottom: 0 !important;
  color: #c289c5;
  border-left: 1px solid #e5e5e5;
}
.detail-comment-register-button:hover {
  color: #632b6c;
  cursor: pointer;
}
.detail-comment-delete-button {
  color: #5f0000;
  font-weight: 900 !important;
  margin-right: 10px;
}
.detail-comment-delete-button:hover {
  color: #ff0000;
  cursor: pointer;
}
.is-mine-style{
  text-align: right;
}
.left-bottom-fix{
  position: absolute;
  top: 88%;
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
.left-bottom-fix:hover{
  /* background:  #e5e5e5; */
  box-shadow: 0px 0px 3px 3px #e5e5e5;
  cursor: pointer;
}
.left-bottom-fix > i{
  width: 100%;
  height: 100%;
}
.line-top{
  border-top: 1px solid #e5e5e5;
}
.line-bottom{
  border-bottom: 1px solid #e5e5e5;
}
.line-left{
  border-left: 1px solid #e5e5e5;
}
.line-right{
  border-right: 1px solid #e5e5e5;
}
</style>
