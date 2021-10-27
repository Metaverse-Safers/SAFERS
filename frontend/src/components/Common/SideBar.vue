<template>
    <div class='container'>
        <div class="sidebar">
            <div class="title">
                Safers
            </div>
            <div class="menu-items">
                <router-link to='main' active-class="active" tag='button'>
                    <div class="link-container">
                        Main
                    </div>
                </router-link>
            </div>
            <div class="menu-items">
                <router-link to='board' active-class="active" tag='button'>
                    <div class="link-container">
                        게시판
                    </div>
                </router-link>
            </div>
            <div class="menu-items">
                <router-link to='personality' active-class="active" tag='button'>
                    <div class="link-container">
                        성격테스트
                    </div>
                </router-link>
            </div>
            <div class="menu-items">
                <router-link to='mypage' active-class="active" tag='button'>
                    <div class="link-container">
                        마이페이지
                    </div>
                </router-link>
            </div>
        </div>
        <router-view/>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    .container, .sidebar, .title{
        margin:0;
    }
    .menu-items{
        width: 10px;
        height: 5vh;
    }
    .container{
        display: grid;
        grid-template-columns: 1fr 5fr;
    }
</style>