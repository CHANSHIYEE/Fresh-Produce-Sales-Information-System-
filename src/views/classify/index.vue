<template>
    <div>
        <Classifytop/>
        <Leftmenu/>
        <NavBottom />
        <div style="margin-left: 140px;"><router-view /></div>
    </div>
</template>
  
<script>

import Classifytop from './classifytop.vue'
import Leftmenu from './leftmenu.vue'
import NavBottom from '@/views/nav.vue'


  
export default {
  components:{
    NavBottom,
    Classifytop,
    Leftmenu,
  }
}
</script>

