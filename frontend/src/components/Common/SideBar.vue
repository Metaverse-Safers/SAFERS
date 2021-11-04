<template>
    <div>
        <div class="icon-bar">
            <router-link to="/"><img id='sideBarLogo' src='@/assets/images/SafersSideBar.png'/></router-link>
            <router-link to="/unity"><i class="fas fa-home"></i></router-link>
            <router-link to="/board"><i class="fas fa-chalkboard-teacher"></i></router-link>
            <router-link to="/personality"><i class="fas fa-cat"></i></router-link>
            <router-link to="/login"><i class="fas fa-sign-in-alt"></i></router-link>
            <router-link to="/mypage"><i class="fas fa-user"></i></router-link>
        </div>
        <router-view id='sideBarRouterView'/>
    </div>
</template>

<style>
    .icon-bar {
        height: 100%;
        width: 120px;
        border-right: 1px #c86b9825 solid;
        background-color: white;
        position: fixed; /* Fixed Sidebar (stay in place on scroll) */
        /*z-index: 1;*/ /* Stay on top */
        top: 0; /* Stay at the top */
        left: 0;
        overflow-x: hidden; /* Disable horizontal scroll */
        padding-top: 0;
        z-index: 1;
    }
    #sideBarLogo{
        width: 80px;
    }
    .icon-bar a {
        display: block;
        text-align: center;
        padding: 16px;
        transition: all 0.3s ease;
        color: #c86b9885;
        font-size: 36px;
    }
    .icon-bar a:hover {
        color: #c86b98;
    }
    .icon-bar a:active {
        color: white;
        background-color: #c86b98;
    }
    #sideBarRouterView{
        margin-left: 120px;
    }

</style>
