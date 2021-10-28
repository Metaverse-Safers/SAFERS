import createPersistedState from 'vuex-persistedstate'

const store = new Vuex.Store({
  plugins: [
    createPersistedState()
  ]
})