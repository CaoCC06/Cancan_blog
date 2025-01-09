// src/router/index.js
import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router';
import store from '../assets/js/store'; // 确保正确导入 Vuex store
import { ElMessage } from 'element-plus'; // 导入 element-plus 的消息提示组件

// 定义前台路由数组
const frontendRoutes = [
  {
    meta: { title: '灿灿的博客' },
    path: '/',
    component: () => import('../views/client/myIndex.vue'),
  },
  {
    meta: { title: '登录' },
    path: '/login',
    name: 'Login',
    component: () => import('../views/login.vue'),
  },
  {
    meta: { title: '测试' },
    path: '/myTest',
    component: () => import('../views/client/myTest.vue'),
  },
  {
    path: '/404',
    component: () => import('../views/client/404.vue'),
  },
  {
    path: '/:pathMatch(.*)',
    redirect: '/404',
  },
];

// 定义后台路由数组
const backendRoutes = [
  {
    meta: { title: '控制台', requiresAuth: true },
    path: '/admin/console',
    name: 'AdminConsole',
    component: () => import('../views/admin/aIndex.vue'),
    children: [
      {
        meta: { title: '个人资料', requiresAuth: true },
        path: '/admin/userInfo',
        component: () => import('../views/admin/userInfo/userInfo.vue'),
      },
    ]
  },
];

const router = createRouter({
  routes: [
    // 将前台路由和后台路由合并到总的路由配置中
    ...frontendRoutes,
    ...backendRoutes,
  ], // 你的路由配置
  history: (() => {
    if (typeof window !== 'undefined' && window.history && window.history.pushState) {
      // 检查浏览器是否支持 HTML5 History API
      return createWebHistory();
    } else {
      // 如果不支持，使用 createWebHashHistory
      return createWebHashHistory();
    }
  })(),
});

// 全局前置守卫逻辑
router.beforeEach(async (to, from, next) => {
  const token = localStorage.getItem('token');
  const tokenExpiry = localStorage.getItem('tokenExpiry');
  const timeOver = 24 * 60 * 60 * 1000; // 你可以根据需要调整这个时间
  // 当前时间
  let date = new Date().getTime();
  // 判断目标路由是否需要认证
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth);

  if (requiresAuth && !token) {
    // 如果需要认证且没有JWT令牌，重定向到登录页面
    return next({ name: 'Login' });
  } else if (requiresAuth && token && to.name === 'Login') {
    // 如果有JWT令牌且目标路由是登录页面，重定向到控制台页面
    return next({ name: 'AdminConsole' });
  } else if (requiresAuth && date - tokenExpiry > timeOver) {
    // 如果 token 过期
    ElMessage.error("登录状态过期，请重新登录");
    store.commit('clearToken');
    return next({ name: 'Login' });
  } else if (requiresAuth && date - tokenExpiry > timeOver - 2 * 60 * 60 * 1000) {
    // 如果 token 即将过期，调用 renewToken 动作
    try {
      await store.dispatch('renewToken');
      console.log('Token 续期成功');
    } catch (error) {
      console.error('Token 续期失败', error);
      ElMessage.error("Token 续期失败，请重新登录");
      store.commit('clearToken');
      return next({ name: 'Login' });
    }
  }

  // 否则允许访问目标路由
  next();

  // 设置页面标题
  document.title = to.meta.title || '默认标题'; // 设置页面标题，如果未设置则使用默认标题
});

// router.afterEach((to, from) => {
//   // 结束加载动画
//   setTimeout(() => {
//     variable.router_loading.value = false;
//   }, 1000);
// });

export default router;