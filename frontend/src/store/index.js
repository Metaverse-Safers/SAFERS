// Vuex 조립
import Vue from 'vue';
import Vuex from 'vuex';
import user from './modules/user.js'
import board from './modules/board.js'
import VuexPersistence from "vuex-persist";


Vue.use(Vuex)

const vuexLocal = new VuexPersistence({
  storage: window.localStorage,
});

export default new Vuex.Store({
  strict: true,
  plugins: [vuexLocal.plugin],
  modules: {
    user,
    board,
  }
})