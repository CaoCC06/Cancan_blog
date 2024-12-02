import { createRouter, createWebHashHistory,createWebHistory } from 'vue-router'

const title = '灿灿的博客'

//路由配置
const routes = [
    {
      meta: { title: title},
      path: '/',
      component: () => import('../views/myIndex.vue'),
    },
    {
      meta: { title: '测试' },
      path: '/myTest',
      component: () => import('../views/myTest.vue'),
    },
    {
      path: '/404',
      component: () => import('../views/404.vue')
    },
    {
      path: '/:pathMatch(.*)',
      redirect: '/404'
    },
  ]
  
  const router = createRouter({
    routes, // 你的路由配置
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