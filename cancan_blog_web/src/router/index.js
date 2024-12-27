import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router';
import Login from '../views/login.vue'; // 确保正确导入 Login 组件

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
    component: () => import('../views/admin/aIndex.vue'),
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
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token');
  // 判断目标路由是否需要认证
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth);

  if (requiresAuth && !token) {
    // 如果需要认证且没有JWT令牌，重定向到登录页面
    next({ name: 'Login' });
  } else {
    // 否则允许访问目标路由
    next();
  }

  // 加载动画
  // variable.router_loading.value = true;

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