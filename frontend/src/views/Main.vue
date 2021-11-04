<template>
    <div id='main'>
        <div id='wrap'>
            <img id='qM' src="@/assets/images/questionMark.png">
            <router-link to=/login v-if="loggedIn">
                <img id='login' src="@/assets/images/loginBtn.png">
            </router-link>
            <img v-else id='logout' src="@/assets/images/logoutBtn.png" @click="clickLogout()">
        </div>
        <div id='wrap2' @click='clickStart()'>
            <p id='p1'>함께 지구별에서 살아가는 친구들을 지켜주세요</p>
            <p id='p2'>Safers</p>
            <img id='mainLogo' src='@/assets/images/logo.png'>
            <p id='p3'>아무 곳이나 클릭해주세요</p>
        </div>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'; 
    export default {
        components:{
        },
        data(){
            return{
                loggedIn: true,
            }
        },
        computed: {
            ...mapGetters({
                userProfile : "user/userProfile",
            })
        },
        mounted(){
                // 정의되어 있지 않거나 빈 객체이면, 로그인이 되어 있지 않음
                if(this.userProfile == undefined || Object.keys(this.userProfile).length != 0)
                    this.loggedIn = false;
                console.log(this.userProfile)
        },
        methods: {
            clickStart() {
                this.$router.push('/unity')
            },
            async clickLogout() {
                await this.$store.dispatch("user/requestLogout");
                this.$router.go();
            }
        },
    }

</script>

<style>
    p {
        cursor: default;
    }
    #main{
        /* background-image: url('../assets/images/background.png');
        background-size: cover;
        background-repeat: no-repeat; */
        background: linear-gradient(150deg, #ffc1a0, #f09f9c, #b572c2, #280F36);
        background-size: 160% 160%;
        animation: gradient 10s ease infinite;
    }
    #wrap{
        display: flex;
        justify-content: space-between;
        height: 10vh; 
    }
    #qM{
        margin: 3vh;
        width: 4.5vh;
        height: 4.5vh;
        cursor: pointer;
    }
    #login{
        margin: 3vh;
        width: 14vh;
        height: 4.5vh;
    }
    #logout{
        margin: 3vh;
        width: 14vh;
        height: 4.5vh;
        cursor: pointer;
    }
    #p1{
        color: white; 
        font-size:2.5vh;
        position:absolute;
        top:22%; left:50%;
        transform: translate(-50%, -50%);
        font-family: 'NEXON Lv1 Gothic OTF';
        -webkit-animation: focus-in-expand 3s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
                animation: focus-in-expand 3s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;    
    }
    #p2{
        color: white; 
        font-size:12vh;
        position:absolute;
        top:30%; left:50%;
        transform: translate(-50%, -50%);
        font-family: 'IBMPlexSansKR-SemiBold';
    }  
    #mainLogo{
        width: 35vh;
        position:absolute;
        top:55%; left:50%;
        transform: translate(-50%, -50%);
        animation:circlemove 1.5s infinite linear;
    }
    #p3{
        color: white; 
        font-size:2vh;
        position:absolute;
        top:78%; left:50%;
        transform: translate(-50%, -50%);
        font-family: 'NEXON Lv1 Gothic OTF';
        -webkit-animation: fadein 3s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;
        -webkit-animation-delay: 3s;
                animation: fadein 3s cubic-bezier(0.250, 0.460, 0.450, 0.940) both;  
                animation-delay: 3s;
    }
    #wrap2{
        height: 90%;
    }
    @keyframes circlemove{ 
        0%,100%{ transform:translate(-50%,-50%); } 
        50%{ transform:translate(-50%,-52%); } 
    }
    @-webkit-keyframes focus-in-expand {
        0% {
            letter-spacing: -0.5em;
            -webkit-filter: blur(12px);
                    filter: blur(12px);
            opacity: 0;
        }
        100% {
            -webkit-filter: blur(0px);
                    filter: blur(0px);
            opacity: 1;
        }
    }
    @keyframes focus-in-expand {
    0% {
        letter-spacing: -0.5em;
        -webkit-filter: blur(12px);
                filter: blur(12px);
        opacity: 0;
    }
    100% {
        -webkit-filter: blur(0px);
                filter: blur(0px);
        opacity: 1;
    }
    }
    @keyframes fadein {
        from {
            opacity:0;
        }
        to {
            opacity:1;
        }
    }
    @-webkit-keyframes fadein { /* Safari and Chrome */
        from {
            opacity:0;
        }
        to {
            opacity:1;
        }
    }
    @keyframes gradient {
        0% {
            background-position: 0% 50%;
        }
        50% {
            background-position: 100% 50%;
        }
        100% {
            background-position: 0% 50%;
        }
    }
    @-webkit-keyframes gradient {
        0% {
            background-position: 0% 50%;
        }
        50% {
            background-position: 100% 50%;
        }
        100% {
            background-position: 0% 50%;
        }
    }
</style>