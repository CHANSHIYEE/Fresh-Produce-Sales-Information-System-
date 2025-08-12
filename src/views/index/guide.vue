<template>
    <div class="guide">
        <div class="guide-item1 p10">
            <h3>选购指南</h3>
        </div>
        <div class="guide-item2 p10">
            <el-steps direction="vertical" :active="1">
            <el-step title="在线下单" description="每天中午12点前下单将会当天派送,反之将次日进行派送"></el-step>
            <el-step title="物流配送" description="物流派送当天回发送短信给您,再配送到您所选择的自提点"></el-step>
            <el-step title="温馨提示" description="如商品为冷冻食品,请即使取货,并妥善保存在冰箱。若商品出现异常,请在1小时内拍照并联系客服,以便我们尽快为您解决"></el-step>
            <el-step title="售后无忧" description="如您购买的商品出现任何问题,请在小程序中[关于],[客服咨询]处联系客服处理"></el-step>
        </el-steps>
        </div>
    </div>

</template>
  
<script>

  
export default{
    methods: {
      goBack() {
        this.$router.push("/index");
      }
    }
}
</script>
  