import { createRouter, createWebHashHistory,createWebHistory } from 'vue-router'
//路由配置
// 定义前台路由数组
const frontendRoutes = [
    {
      meta: { title: '灿灿的博客'},
      path: '/',
      component: () => import('../views/client/myIndex.vue'),
    },
    {
      meta: { title: '测试' },
      path: '/myTest',
      component: () => import('../views/client/myTest.vue'),
    },
    {
      path: '/404',
      component: () => import('../views/client/404.vue')
    },
    {
      path: '/:pathMatch(.*)',
      redirect: '/404'
    },
  ]

// 定义后台路由数组
const backendRoutes = [
  {
    meta: { title: '控制台' },
    path: '/admin/console',
    component: () => import('../views/admin/aIndex.vue'),
  },
];

  const router = createRouter({
    routes: [
      // 将前台路由和后台路由合并到总的路由配置中
    ...frontendRoutes,
    ...backendRoutes
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

  //全局前置守卫逻辑
// router.beforeEach((to, from, next) => {
//   const token = localStorage.getItem('jwt_token');
//   // 判断目标路由是否属于后台路由
//   const isBackendRoute = backendRoutes.some(route => route.path === to.path || to.matched.some(match => match.path === route.path));
//   if (isBackendRoute &&!token) {
//     // 如果是后台路由且没有JWT令牌，重定向到登录页面
//     next({name: 'Login'});
//   } else {
//     // 否则允许访问目标路由
//     next();
//   }
// });
  
//   router.beforeEach((to, from, next) => {
//     //加载动画
//     variable.router_loading.value = true
  
//     document.title = to.meta.title || title; // 设置页面标题，如果未设置则使用默认标题
//     next(); // 继续导航
//   });
  
  
//   router.afterEach((to, from) => {
//     //结束加载动画
//     setInterval(() => {
//       variable.router_loading.value = false
//     }, 1000);
//   });
  
  export default router