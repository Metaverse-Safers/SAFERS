import axios from "@/common/axios";

const user = {
    namespaced: true,
    state: {
        token: {},
        userProfile: {},
    },
    getters: {
        token({ token }) {
            return token;
        },
        userProfile({ userProfile }) {
            return userProfile;
        }
    },
    mutations: {
        async SET_TOKEN (state, payload) {
            state.token = payload;
        }, 
        async SET_USER_PROFILE(state, payload) {
            state.userProfile = payload;
        }
    },
    actions: {
        async requestAccessToken({ commit }, code) {
            await axios.post("/user/token", code)
            .then(function(result) {
                console.log(result.data);
                commit("SET_TOKEN", result.data);
            })
            .catch(function(error) {
                console.log(error);
            })
        },

        async requestProfile({ commit }, token) {
            await axios.post("/user/login", token)
            .then(function(result) {
                console.log(result.data);  
                commit("SET_USER_PROFILE", result.data);
            })
            .catch(function(error) {
                console.log(error);
            })
        },

        async requestLogout({ commit }) {
            await axios.get("/user/logout")
            .then(function(result) {
                console.log(result)
                commit("SET_USER_PROFILE", {});
                commit("SET_TOKEN", {});
            })
            .catch(function(error) {
                console.log(error);
            })
        }

    }
}
export default user;