import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import Particles from "particles.vue"

Vue.config.productionTip = false
Vue.use(Particles);

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

window.Kakao.init("87b730a1b8865066cd4a4aba71a23371");