// Vuex 조립
import Vue from 'vue';
import Vuex from 'vuex';
import user from './modules/user.js'
import board from './modules/board.js'

Vue.use(Vuex)

export default new Vuex.Store({
  strict: true,
  modules: {
    user,
    board,
  }
})