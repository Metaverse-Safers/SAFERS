<template>
  <div>
    <button @click="next"></button>
  </div>
</template>

<script>
export default {
  name: "Page1",
  methods: {
    next(){
      this.$emit("nextSurvey", { x:'v1', y:'v2', z: 'v3' });
    }
  },
}
</script>

<style>

</style>