<template>
    <div class="details">
        <div class="details-item1">
            <div class="details-header">
                <el-page-header content="商品详情" @back="goBack()" ></el-page-header>
            </div>
        </div>
        <div class="details-item2">
            <img src="@/assets/images/egg.png" alt="">
        </div>
        <div class="details-item3 p10">
            <div class="details-price">
                <i> ￥ </i>
                <em> 70 </em>
            </div>
            <div class="details-title">日日鲜 无抗土鸡蛋</div>
        </div>
        <div class="details-item4 p10">
            <b>优惠</b>
            <span>换购</span>
            <p>购买一件商品课优惠换购热销产品</p>
        </div>
        <div class="details-item5 p10">
            <h3>图文详情</h3>
            <img src="@/assets/images/eggd.png" alt="">
        </div>
        <Guide/>
    </div>
</template>
  
<script>
import Guide from './guide.vue'

  
export default{
    methods: {
      goBack() {
        this.$router.push("/index");
      }
    },
    components:{
        Guide
    }
}
</script>
  