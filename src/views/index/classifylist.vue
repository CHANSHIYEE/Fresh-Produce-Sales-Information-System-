<template>
    <div class="classifylist">
        <ul>
            <li v-for="v in classifylist" :key="v.path">
                <img :src="v.path" alt="">
                <p>{{ v.title }}</p>
            </li>
        </ul>
    </div>
  </template>
  
  <script>

  
export default{
    data(){
        return{
            classifylist:[
                {title:'时令鲜蔬',path:require("@/assets/images/vegetable.png")},
                {title:'新鲜水果',path:require("@/assets/images/orange.png")},
                {title:'肉禽蛋品',path:require("@/assets/images/meat.png")},
                {title:'水产海鲜',path:require("@/assets/images/fish.png")},
                {title:'休闲零食',path:require("@/assets/images/snacks.png")},
                {title:'酒水饮料',path:require("@/assets/images/cola.png")},
                {title:'粮食调味',path:require("@/assets/images/pepper.png")},
                {title:'冷冻食品',path:require("@/assets/images/jiaozi.png")},
            ]
        }
    }

}
  
  </script>
  