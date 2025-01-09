// src/main.js
import { createApp, ref } from 'vue';
import './style.css';
import router from './router';
import { MotionPlugin } from '@vueuse/motion';
import App from './App.vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
import zhCn from 'element-plus/es/locale/lang/zh-cn'; // 引入中文语言包
import store from './assets/js/store'; // 确保正确导入 Vuex store
import axios from 'axios';

const app = createApp(App);

// 全局变量
app.config.globalProperties.variable = {
  router_loading: ref(false)
};

// 使用路由
app.use(router);

// 使用 Element Plus 并设置中文语言包
app.use(ElementPlus, {
  locale: zhCn,
});

// 注册 Element Plus 图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}

// 使用 Motion Plugin
app.use(MotionPlugin);

// 使用 Vuex store
app.use(store);

// 添加请求拦截器
// 拦截器的第一部分，第二部分在router index.js里面
axios.interceptors.request.use(function(config) {
  // 在发送请求之前做些什么
  // 判断是否存在token,如果存在将每个页面header添加token
  if (localStorage.getItem("token")) {
    config.headers.common['token'] = localStorage.getItem("token");
  }
  return config
})
app.config.globalProperties.$axios = axios; 

// 挂载应用
app.mount('#app');