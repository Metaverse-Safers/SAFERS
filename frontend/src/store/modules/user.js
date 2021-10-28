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
        async SET_TOKEN (state, payload) {
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
        async requestAccessToken({ commit }, code) {
            await http.post("/user/token", code)
            .then(function(result) {
                console.log(result.data);
                commit("SET_TOKEN", result.data);
            })
            .catch(function(error) {
                console.log(error);
            })
        },

        async requestProfile({ commit }, token) {
            await http.post("/user/login", token)
            .then(function(result) {
                console.log(result.data);  
                commit("SET_USER_PROFILE", result.data);
                commit("SET_IS_AUTHENTICATED", true);
            })
            .catch(function(error) {
                console.log(error);
            })
        },

        async requestLogout({ commit }) {
            await http.get("/user/logout")
            .then(function(result) {
                console.log(result)
                commit("SET_USER_PROFILE", {});
                commit("SET_TOKEN", {});
                commit("SET_IS_AUTHENTICATED", false);
            })
            .catch(function(error) {
                console.log(error);
            })
        }

    }
}
export default user;