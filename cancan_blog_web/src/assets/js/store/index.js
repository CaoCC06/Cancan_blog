// src/assets/js/store/index.js
import { createStore } from 'vuex';

export default createStore({
  state: {
    token: localStorage.getItem('token') || '',
    tokenExpiry: localStorage.getItem('tokenExpiry') || null
  },
  mutations: {
    setToken(state, { token, tokenExpiry }) {
      state.token = token;
      state.tokenExpiry = tokenExpiry;

      localStorage.setItem('token', token);
      localStorage.setItem('tokenExpiry', tokenExpiry);
    },
    clearToken(state) {
      state.token = '';
      state.tokenExpiry = null;

      localStorage.removeItem('token');
      localStorage.removeItem('tokenExpiry');
    }
  },
  actions: {
    async renewToken({ commit }) {
      try {
        // 假设有一个 API 可以用来续期 token
        const response = await axios.post('/api/renewtoken');
        const { token, tokenExpiry } = response.data;
        commit('setToken', { token, tokenExpiry });
      } catch (error) {
        console.error('更新token失败', error);
        commit('clearToken');
      }
    }
  },
  getters: {
    token: state => state.token,
    isTokenExpired: state => {
      if (!state.tokenExpiry) return true;
      const now = new Date();
      return new Date(state.tokenExpiry) < now;
    }
  }
});