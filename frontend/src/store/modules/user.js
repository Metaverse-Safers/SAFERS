import axios from "@/common/axios";

const user = {
    namespaced: true,
    state: {
        token: {},
    },
    getters: {
        token({ token }) {
            return token;
        },
    },
    mutations: {
        LOGIN(state, payload) {
            state.token = payload;
        }
    },
    actions: {
        requestAccessToken({ commit }, code) {
            axios
            .post("/user/token", code)
            .then(({ result }) => {
                console.log(result);
                commit("LOGIN", result.data);
            })
            .catch(({ error }) => {
                console.log(error);
            })
        }
    }
}
export default user;