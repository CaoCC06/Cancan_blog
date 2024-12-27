import { createApp, ref } from 'vue';
import './style.css';
import router from './router';
import { MotionPlugin } from '@vueuse/motion';
import App from './App.vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
import zhCn from 'element-plus/es/locale/lang/zh-cn'; // 引入中文语言包
import store from './store'; // 确保正确导入 Vuex store
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

app.config.globalProperties.$axios = axios; 

// 挂载应用
app.mount('#app');