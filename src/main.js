import Vue from 'vue'//什么也没有在前面，表示依赖
import App from './App.vue' //./表示同级；../表示上一级；@表示根目录下
import router from './router'
import ElementUI from 'element-ui';    
import 'element-ui/lib/theme-chalk/index.css';  
import store from './store'
import '@/assets/css/common.css';
import '@/assets/css/index.css';
import '@/assets/font/iconfont.css';
// import './router/permission';


Vue.config.productionTip = false
Vue.use(ElementUI); 


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
