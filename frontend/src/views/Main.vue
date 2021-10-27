<template>
    <div id='main'>
        <Particles id="tsparticles" lineLinked="true"/>
        <div id='wrap'>
            <img id='qM' src="@/assets/images/questionMark.png">
            <router-link to=/login><img id='login' src="@/assets/images/loginBtn.png"></router-link>
        </div>
        <p id='p1'>함께 지구별에서 살아가는 친구들을 지켜주세요</p>
        <p id='p2'>Safers</p>
        <img id='logo' src='@/assets/images/logo.png'>
    </div>
</template>

<script>
    import Particles from "particles.vue";
    export default {
        components:{
            Particles
        }
    }

</script>

<style>
    #main{
        background-image: url('../assets/images/background.png');
        background-size: cover;
        background-repeat: no-repeat;
    }
    #wrap{
        display: flex;
        justify-content: space-between;
        height: 10vh; 
    }
    #qM{
        margin: 3vh;
        width: 5vh;
        height: 5vh;
    }
    #login{
        margin: 3vh;
        width: 16vh;
        height: 5vh;
    }
    #p1{
        color: white; 
        font-size:2.5vh;
        position:absolute;
        top:20%; left:50%;
        transform: translate(-50%, -50%);
        font-family: 'NEXON Lv1 Gothic OTF';
        
    }
    #p2{
        color: white; 
        font-size:12vh;
        position:absolute;
        top:20%; left:50%;
        transform: translate(-50%, -50%);
        font-family: 'IBMPlexSansKR-SemiBold';
    }   

    #logo{
        width: 35vh;
        position:absolute;
        top:60%; left:50%;
        transform: translate(-50%, -50%);
    }
</style>