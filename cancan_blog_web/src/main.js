import { createApp } from 'vue'
import './style.css'
import router from './router'
import { MotionPlugin } from '@vueuse/motion'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'    //引入中文语言包

const app = createApp(App);



app.use(router)
app.use(ElementPlus, {
    locale: zhCn,
  })
app.use(MotionPlugin)
app.mount('#app')
