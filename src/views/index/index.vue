<template>
  <div>
    <Header/>
    <Banner/>
    <Classifylist/>
    <Coupon/>
    <Main/>
    <NavBottom />
  </div>
</template>

<script>
import Header from './header.vue'
import Banner from './banner.vue'
import Classifylist from './classifylist.vue'
import Coupon from './coupon.vue';
import Main from './main.vue';
import NavBottom from '@/views/nav.vue'


export default{
  components:{
    NavBottom,
    Header,
    Banner,
    Classifylist,
    Coupon,
    Main,
    
  }
}

</script>
