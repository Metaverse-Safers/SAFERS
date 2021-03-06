import http from "@/common/axios";

const user = {
  namespaced: true,
  state: {
    token: {},
    userProfile: {},
    isAuthenticated: false,
    path: "",
    isDestroyed: false,
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
    path({ path }) {
      return path;
    },
    isDestroyed({ isDestroyed }) {
      return isDestroyed;
    }
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
    },
    async WITHDRAWAL(state) {
      state.token = {};
    },
    async SET_PATH(state, payload) {
      state.path = payload;
    },
    async SET_IS_DESTROYED(state, payload) {
      state.isDestroyed = payload;
    }

  },
  actions: {
    /* AccessToken 요청 */
    async requestAccessToken({ commit }, code) {
      await http.get("/user/token?code=" + code)
        .then(function (result) {
          commit("SET_TOKEN", result.data);
        })
        .catch(function (error) {
          console.log(error);
        })
    },

    /* 사용자 정보 요청 + 로그인 요청 */
    async requestProfile({ commit }, token) {
      await http.post("/user/login", token)
        .then(function (result) {
          commit("SET_USER_PROFILE", result.data);
          commit("SET_IS_AUTHENTICATED", true);
          localStorage.setItem("userId", result.data.id); // Unity에서 얻기위한 UserId
          localStorage.setItem("nickname", result.data.nickName); 
        })
        .catch(function (error) {
          console.log(error);
        })
    },

    /* 로그아웃 */
    async requestLogout({ commit }) {
      await http.get("/user/logout")
        .then(function () {
          commit("SET_USER_PROFILE", {});
          commit("SET_TOKEN", {});
          commit("SET_IS_AUTHENTICATED", false);
          localStorage.removeItem("userId");
          localStorage.removeItem("nickname");
        })
        .catch(function (error) {
          console.log(error);
        })
    },

    /* AccessToken 갱신 요청 */
    async refreshToken({ commit }, refreshToken) {
      await http.post("/user/token/refresh", refreshToken)
        .then(function (result) {
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
          commit("SET_USER_PROFILE", result.data);
          localStorage.setItem("nickname", result.data.nickName);
        })
        .catch(function (error) {
          console.log(error)
        })
    },

    /* 회원 탈퇴 */
    async withdrawal({ commit }, data) {
      var success = false;
      await http.delete("/user/", data)
        .then(function (result) {
          commit("WITHDRAWAL", result.data);
          commit("SET_USER_PROFILE", {});
          commit("SET_TOKEN", {});
          commit("SET_IS_AUTHENTICATED", false);
          localStorage.removeItem("userId");
          localStorage.removeItem("nickname");
          success = true;
        })
        .catch(function (error) {
          console.log(error)
        })
      return success;
    }
  }
}
export default user;