import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import Particles from "particles.vue";

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

Vue.use(Particles);