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
                    title: "西贝 牛奶果蔬馒头 ",
                    path: require("@/assets/images/frozen1.jpg"),
                    price: 29.9,
                    quantity: 12,
                    count:0
                },
                {
                    title: "希杰必品阁 牛肉水饺",
                    path: require("@/assets/images/frozen2.jpg"),
                    price: 37.90,
                    quantity: 43,
                    count:0
                },
                {
                    title: "金三麦 事事如意汤圆",
                    path: require("@/assets/images/frozen3.jpg"),
                    price: 12.9,
                    quantity: 33,
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