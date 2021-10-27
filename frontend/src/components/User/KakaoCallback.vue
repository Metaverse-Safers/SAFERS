<template>
    <h3>kakao callback</h3>
</template>

<script>
export default {
    methods: {
        getAccessToken(code){
            this.$store.dispatch("user/requestAccessToken", code);
        }
    },

    created() {
        const code = this.$route.query.code; // url에서 code값을 빼오기
        this.getAccessToken(code);
    }
}
</script>

<style scoped>
