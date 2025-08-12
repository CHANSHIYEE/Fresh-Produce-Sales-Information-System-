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
                    title: "东方树叶 茉莉花茶 ",
                    path: require("@/assets/images/tea.jpg"),
                    price: 27,
                    quantity: 50,
                    count:0
                },
                {
                    title: "特仑苏 纯牛奶 ",
                    path: require("@/assets/images/milk.jpg"),
                    price: 43.9,
                    quantity: 88,
                    count:0
                },
                {
                    title: "舍得 52度浓香白酒",
                    path: require("@/assets/images/alcohol.jpg"),
                    price: 938,
                    quantity: 5,
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