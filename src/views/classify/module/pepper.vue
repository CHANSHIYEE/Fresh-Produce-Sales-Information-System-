<template>
    <div class="classify-right">
        <ul>
            <li v-for="(v,i) in seafoodlist" :key="i">
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
            seafoodlist: [
                {
                    title: "莫顿 无碘海盐",
                    path: require("@/assets/images/pepper1.jpg"),
                    price: 39.9,
                    quantity: 22,
                    count:0
                },
                {
                    title: "太古 白砂糖 ",
                    path: require("@/assets/images/pepper2.jpg"),
                    price: 5.9,
                    quantity: 88,
                    count:0
                },
                {
                    title: "伯爵 西班牙橄榄油",
                    path: require("@/assets/images/pepper3.jpg"),
                    price: 16.5,
                    quantity: 34,
                    count:0
                }
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