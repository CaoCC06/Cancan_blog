import { createStore } from 'vuex';

export default createStore({
  state: {
    token: localStorage.getItem('token') || ''
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
    }
  },
  actions: {
    // 其他 actions
  },
  getters: {
    token: state => state.token
  }
});