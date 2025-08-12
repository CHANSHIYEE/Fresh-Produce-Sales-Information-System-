<template>
    <div class="banner">
        <img v-for="(v,i) in bannerList" :key="i" class="responsive-image" :src="v" alt="" v-show="n==i">

        <ul>
            <li v-for="(v,i) in bannerList" :key="i" :class="n==i?'select':''"></li>
        </ul>
    </div>
  </template>
  
  <script>

  
  export default{
    data(){
        return{
            n:3,
            bannerList:[
                require("@/assets/images/banner1.jpg"),
                require("@/assets/images/banner2.jpg"),
                require("@/assets/images/banner3.jpg"),
                require("@/assets/images/banner4.jpg"),
                require("@/assets/images/banner5.jpg"),
            ]
        }
    },
    mounted(){ //生命周期
        this.play()
    },
    methods:{
        autoPlay(){
            this.n++
            if(this.n==this.bannerList.length){//当this.n的值和banner.List长度相等
                this.n=0;
            }
        },
        play(){
            setInterval(this.autoPlay,2000)//定时器，2秒
        }
    }



  }


  </script>
  