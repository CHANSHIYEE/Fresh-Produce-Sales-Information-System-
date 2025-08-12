<template>
    <div class="classify-right">
        <ul>
            <li v-for="(v,i) in vegetablelist" :key="i">
                <div class="classify-right-img">
                    <img :src="v.path" />
                </div>
                <div class="classify-right-list">
                    <h3>{{v.title}}</h3>
                    <b>月售 {{v.quantity}}</b>
                    <div class="classify-right-price">
                        <u> ￥ </u>
                        <span> {{v.price}} </span>
                        <i class="iconfont icon-a-ziyuan32" @click="add(v)"></i>
                    </div>
                </div>
                <div class="purchase" v-show="v.count>0"> {{ v.count }}</div>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
            vegetablelist: [
                {
                    title: "有机农 大白菜 ",
                    path: require("@/assets/images/vege1.jpg"),
                    price: 26.8,
                    quantity: 50,
                    count:0
                },
                {
                    title: "薯小萌 天目山香薯  ",
                    path: require("@/assets/images/vege2.jpg"),
                    price: 14,
                    quantity: 100,
                    count:0
                },
                {
                    title: "有机汇 土豆/马铃薯 ",
                    path: require("@/assets/images/vege3.jpg"),
                    price: 17,
                    quantity: 100,
                    count:0
                },
                {
                    title: "绿行者 生菜 ",
                    path: require("@/assets/images/vege4.jpg"),
                    price: 158,
                    quantity: 100,
                    count:0
                },
                {
                    title: "恰好庄园 糯玉米 ",
                    path: require("@/assets/images/jagong.jpg"),
                    price: 15,
                    quantity: 100,
                    count:0

                },
            ]
        }
    },
    methods:{
        add(v){
            v.count++
        }
    }
}
</script>
  
