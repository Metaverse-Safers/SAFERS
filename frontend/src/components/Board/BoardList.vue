<template>
  <div>
    <br>
    <div class="masonry">
      <div class="mItem">
        <img class="m-img" src="https://source.unsplash.com/random/1">
      </div>

      <div class="mItem">
        <img class="m-img" src="https://source.unsplash.com/random/2">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/3">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/4">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/5">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/6">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/7">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/8">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/9">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/10">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/60">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/80">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/300">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/200">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/100">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/50">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/600">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/500">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/400">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/30">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/10">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/30">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/10">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/30">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/10">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/30">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/10">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/30">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/10">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/20">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/60">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/80">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/300">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/200">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/100">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/50">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/600">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/500">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/400">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/30">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/10">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/20">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/60">
      </div>

      <div class="mItem">
        <img src="https://source.unsplash.com/random/80">
      </div>

    </div>
  </div>
</template>

<script>
export default {
  methods:{
    test(){
      this.$emit("testClick", "1")
    }
  }
}
</script>

<style>
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
}

.masonry .mItem {
  display: inline-block;
  margin-bottom: 16px;
  width: 100%;
}

@media (max-width: 1199px) {
  .masonry {
    column-count: 3;
  }
}

@media (max-width: 991px) {
  .masonry {
    column-count: 2;
  }
}

@media (max-width: 767px) {
  .masonry {
    column-count: 1;
  }
}


</style>