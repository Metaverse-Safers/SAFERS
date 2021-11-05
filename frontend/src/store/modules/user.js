import http from "@/common/axios";

const user = {
  namespaced: true,
  state: {
    token: {},
    userProfile: {},
    isAuthenticated: false,
  },
  getters: {
    token({ token }) {
      return token;
    },
    userProfile({ userProfile }) {
      return userProfile;
    },
    isAuthenticated({ isAuthenticated }) {
      return isAuthenticated;
    },
  },
  mutations: {
    async SET_TOKEN(state, payload) {
      state.token = payload;
    },
    async SET_USER_PROFILE(state, payload) {
      state.userProfile = payload;
    },
    async SET_IS_AUTHENTICATED(state, payload) {
      state.isAuthenticated = payload;
    }
  },
  actions: {
    /* AccessToken 요청 */
    async requestAccessToken({ commit }, code) {
      await http.get("/user/token?code=" + code)
        .then(function (result) {
          console.log(result.data);
          commit("SET_TOKEN", result.data);
        })
        .catch(function (error) {
          console.log(error);
        })
    },

    /* 사용자 정보 요청 */
    async requestProfile({ commit }, token) {
      await http.post("/user/login", token)
        .then(function (result) {
          console.log(result.data);
          commit("SET_USER_PROFILE", result.data);
          commit("SET_IS_AUTHENTICATED", true);
        })
        .catch(function (error) {
          console.log(error);
        })
    },

    /* 로그아웃 */
    async requestLogout({ commit }) {
      await http.get("/user/logout")
        .then(function (result) {
          console.log(result)
          commit("SET_USER_PROFILE", {});
          commit("SET_TOKEN", {});
          commit("SET_IS_AUTHENTICATED", false);
        })
        .catch(function (error) {
          console.log(error);
        })
    },

    /* AccessToken 갱신 요청 */
    async refreshToken({ commit }, refreshToken) {
      await http.post("/user/token/refresh", refreshToken)
        .then(function (result) {
          console.log(result.data);
          commit("SET_TOKEN", result.data);
        })
        .catch(function (error) {
          console.log(error);
        })
    },


    /* 사용자 프로필 정보 수정 */
    async requestUpdateProfile({ commit }, data) {
      await http.post("/user/", data, { headers: { 'Content-Type': 'multipart/form-data' } })
        .then(function (result) {
          console.log(result)
          commit("SET_USER_PROFILE", result.data);
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
export default user;