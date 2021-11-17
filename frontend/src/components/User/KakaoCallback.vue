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
                    this.$store.commit("user/SET_USER_PROFILE", res.data.userProfile);
                    return res.data.present;
                })

                if (!this.present){
                    await this.$router.push({ name: 'register' });
                }
                else {
                    await this.$store.dispatch("user/requestProfile", this.token);
                    await this.$router.push({ name: 'main' });
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
