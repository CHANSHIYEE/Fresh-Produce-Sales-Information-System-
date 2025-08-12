<template>
  <div class="footer">
    <div class="footer-seat ">
      <div class="footer-list">
        <ul>
          <li v-for="v in items" :key="v.path">
            <router-link :to ="v.path">
              <i class ="iconfont" :class="v.icon"></i>
              <span>{{ v.title }}</span>

            </router-link>
          </li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>

export default {
  data(){
    return {
      items:[
        {title:'首页',icon:'icon-shouye-zhihui',path:'/index'},
        {title:'分类',icon:'icon-fenlei1',path:'/classify'},
        {title:'精选',icon:'icon-jingxuanchanpinku',path:'/selected'},
        {title:'购物车',icon:'icon-a-ziyuan32',path:'/cart'},
        {title:'我的',icon:'icon-gerenzhongxin-zhihui',path:'/about'},
      ]
    }
  }
}

</script>