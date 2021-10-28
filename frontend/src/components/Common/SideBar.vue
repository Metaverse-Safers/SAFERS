<template>
    <div>
        <div class="icon-bar">
            <img id='sideBarLogo' src='@/assets/images/SafersSideBar.png'/>
            <router-link to="/main"><i class="fas fa-home"></i></router-link>
            <router-link to="/board"><i class="fas fa-chalkboard-teacher"></i></router-link>
            <router-link to="/login"><i class="fas fa-sign-in-alt"></i></router-link>
            <router-link to="/personality"><i class="fas fa-cat"></i></router-link>
        </div>
        <router-view/>
    </div>
</template>

<style>
    #sideBarLogo{
        margin-top: 10px;
        width: 80px;
    }
    .icon-bar {
        height: 100%;
        width: 90px;
        background-color: #c289c5;
        position: fixed; /* Fixed Sidebar (stay in place on scroll) */
        /*z-index: 1;*/ /* Stay on top */
        top: 0; /* Stay at the top */
        left: 0;
        overflow-x: hidden; /* Disable horizontal scroll */
        padding-top: 0;
    }
    .icon-bar a {
        display: block;
        text-align: center;
        padding: 16px;
        transition: all 0.3s ease;
        color: white;
        font-size: 36px;

    }
    .icon-bar a:hover {
        background-color: #632b6c;
    }
    .active {
        background-color: #5eaf13;
    }

</style>
