import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import Particles from "particles.vue";
import VueAxios from "./common/axios";
import store from "./store";
import VueKakaoSdk from 'vue-kakao-sdk'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


const apiKey = '2920ed8322509d97bcdb698cad022b10';

Vue.config.productionTip = false
Vue.use(Particles);
Vue.use(VueKakaoSdk, { apiKey });
Vue.use(BootstrapVue);

new Vue({
  router,
  VueAxios,
  store,
  render: h => h(App),
}).$mount('#app')