<template>
    <div id='main'>
        <div id='wrap'>
            <img id='qM' src="@/assets/images/questionMark.png">
            <router-link to=/main><img id='home' src="@/assets/images/homeBtn.png"></router-link>
        </div>
        <img id='img' src="@/assets/images/loginImg.png">
    </div>
</template>

<script>

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
    #home{
        margin: 3.5vh;
        width: 15vh;
        height: 3.5vh;
    }
    #img{
        width: 70vh;
        position:absolute;
        top:50%; left:50%;
        transform: translate(-50%, -50%);
    }
</style>