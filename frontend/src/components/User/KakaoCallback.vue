<template>
    <div></div>
</template>

<script>
import { mapGetters } from "vuex";
import http from "@/common/axios";

export default {
    data(){
        return{
            present: null
        }
    },
    methods: {
        async getAccessToken(code){
            await this.$store.dispatch("user/requestAccessToken", code);
            this.present = await http.post("user/present", this.token)
            .then(res => {
                console.log(res.data.present)
                return res.data.present;
            })
            await this.$store.dispatch("user/requestProfile", this.token);
            
            if (!this.present){
                await this.$router.push({ name: 'register' });
            }
            else {
                await this.$router.push({ name: 'unity' });
            }
        }
    },

    computed: {
        ...mapGetters({
            token: "user/token",
            userProfile: "user/userProfile"
        })
    },

    async mounted() {
        const code = this.$route.query.code; // url에서 code값을 빼오기
        this.getAccessToken(code);
    }
}
</script>

<style scoped>
