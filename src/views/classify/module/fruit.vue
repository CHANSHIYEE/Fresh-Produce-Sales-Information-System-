<template>
    <div class="classify-right">
        <ul>
            <li v-for="(v,i) in fruitlist" :key="i">
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
            fruitlist: [
                {
                    title: "恰好庄园 番茄 ",
                    path: require("@/assets/images/fruit1.jpg"),
                    price: 24,
                    quantity: 50,
                    count:0
                },
                {
                    title: "佳沛 新西兰金奇异果  ",
                    path: require("@/assets/images/kiwi.jpg"),
                    price: 178,
                    quantity: 88,
                    count:0
                },
                {
                    title: "美吉蔬 草莓淡雪 ",
                    path: require("@/assets/images/strawberry.jpg"),
                    price: 116,
                    quantity: 34,
                    count:0
                },
                {
                    title: "越南 红心火龙果 ",
                    path: require("@/assets/images/dragonfruit.jpg"),
                    price: 57,
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
  