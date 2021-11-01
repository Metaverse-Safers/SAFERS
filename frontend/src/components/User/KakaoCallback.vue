<template>
    <div></div>
</template>

<script>
import { mapGetters } from "vuex";

export default {

    methods: {
        async getAccessToken(code){
            await this.$store.dispatch("user/requestAccessToken", code);
            await this.$store.dispatch("user/requestProfile", this.token);
            await this.$router.push({ name: 'unity' });
        }
    },

    computed: {
        ...mapGetters({
            token: "user/token"
        })
    },

    mounted() {
        const code = this.$route.query.code; // url에서 code값을 빼오기
        this.getAccessToken(code);
    }
}
</script>

<style scoped>
