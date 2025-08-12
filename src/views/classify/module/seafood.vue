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
                    title: "美威 欧式三文鱼 ",
                    path: require("@/assets/images/sea2.jpg"),
                    price: 68.5,
                    quantity: 50,
                    count:0
                },
                {
                    title: "鱼誓 海鲈鱼 ",
                    path: require("@/assets/images/sea1.jpg"),
                    price: 18,
                    quantity: 88,
                    count:0
                },
                {
                    title: "厄瓜多尔 大虾",
                    path: require("@/assets/images/sea3.jpg"),
                    price: 89,
                    quantity: 34,
                    count:0
                },
                {
                    title: "贝司令 生蚝",
                    path: require("@/assets/images/sea4.jpg"),
                    price: 83.9,
                    quantity: 59,
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