<template>
    <div class="leftmenu">
        <ul>
          <li v-for="v in leftmenulist" :key="v.path">
            <router-link :to="v.path">{{ v.title }}</router-link>

          </li>
        </ul>
    </div>
</template>

<script>
export default {
  data(){
    return {
      leftmenulist:[
        {
          path:'/classify/vegetable',
          title:'时令鲜蔬'
        },
        {
          path:'/classify/fruit',
          title:'新鲜水果'
        },
        {
          path:'/classify/meat',
          title:'肉禽蛋品'
        },
        {
          path:'/classify/seafood',
          title:'水产海鲜'
        },
        {
          path:'/classify/snacks',
          title:'休闲零食'
        },
        {
          path:'/classify/drinks',
          title:'酒水饮料'
        },
        {
          path:'/classify/pepper',
          title:'粮食调料'
        },
        {
          path:'/classify/frozenfood',
          title:'冷冻食品'
        },
      ]
    }
  }
    
}
</script>
  
