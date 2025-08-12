import Vue from 'vue'
import VueRouter from 'vue-router'
// import { component } from 'vue/types/umd'

Vue.use(VueRouter)

const routes = [
  // {
  //     path: '/',          // 路径
  //     redirect: 'login'  // 重定向
  // },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login/loginpage.vue') //首页地址
  },
  {
    path: '/layout',
    name: 'layout',
    component: () => import('../views/index/Layout.vue'),
  },
  {
    path: '/',
    name: 'index',
    component: () => import('../views/index/index.vue'), //首页地址
  },
  {
    path: '/index',
    name: 'index',
    component: () => import('../views/index/index.vue'), //首页地址
  },
  {
    path: '/classify',
    name: 'classify',
    redirect:'/classify/vegetable',
    component: () => import('../views/classify/index.vue') ,//分类地址
    children:[
      {
        path: '/classify/vegetable',
        name: 'vegetable',
        component: () => import('../views/classify/module/vegetable.vue') //首页地址
      },
      {
        path: '/classify/fruit',
        name: 'fruit',
        component: () => import('../views/classify/module/fruit.vue') //首页地址
      },
      {
        path: '/classify/meat',
        name: 'meat',
        component: () => import('../views/classify/module/meat.vue') //首页地址
      },
      {
        path: '/classify/seafood',
        name: 'seafood',
        component: () => import('../views/classify/module/seafood.vue') //首页地址
      },
      {
        path: '/classify/snacks',
        name: 'snacks',
        component: () => import('../views/classify/module/snacks.vue') //首页地址
      },
      {
        path: '/classify/drinks',
        name: 'drinks',
        component: () => import('../views/classify/module/drinks.vue') //首页地址
      },
      {
        path: '/classify/pepper',
        name: 'pepper',
        component: () => import('../views/classify/module/pepper.vue') //首页地址
      },
      {
        path: '/classify/frozenfood',
        name: 'frozenfood',
        component: () => import('../views/classify/module/frozenfood.vue') //首页地址
      },
     ]
    }, 
    {
    path: '/selected',
    name: 'selected',
    component: () => import('../views/selected/index.vue') //精选地址
    },  
    {
    path: '/cart',
    name: 'cart',
    component: () => import('../views/cart/index.vue') //购物车地址
    },  
    {
    path: '/about',
    name: 'about',
    component: () => import('../views/about/index.vue') //我的地址
    },
    {
    path: '/details',
    name: 'details',
    component: () => import('../views/index/details.vue') //我的地址
    },
    {
    path: '/staff',
    name: 'staff',
    component: () => import('../components/Manage.vue'), //首页地址
    // redirect:"/staffview",
    children:[
      {path:'staffview',name:'用户管理',component:()=>import('../views/Staffview.vue')}
      ]
    },
  ]

const router = new VueRouter({
  mode:'history',
  routes,
  linkActiveClass:'selected' //路由跳转时动态添加样式

})

export default router
