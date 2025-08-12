<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import NavBottom from './views/nav.vue'

export default {
  components: {
  }
}
</script>

<!-- <template>
  <div id="app">
    <router-view/>
    <NavBottom />
  </div>
</template>

<script>
import { mapState } from 'vuex'
import NavBottom from './views/nav.vue'

export default {
  components: {
    NavBottom
  }
}
</script> -->


