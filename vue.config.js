module.exports = {
  devServer:{
        port:8080,
        host:'localhost'
    }
  }
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
 lintOnSave:false
})

