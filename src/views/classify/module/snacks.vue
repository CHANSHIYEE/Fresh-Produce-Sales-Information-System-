<template>
    <div class="classify-right">
        <ul>
            <li v-for="(v,i) in snackslist" :key="i">
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
            snackslist: [
                {
                    title: "MAGNUM梦龙 抹茶雪糕 ",
                    path: require("@/assets/images/magnum.jpg"),
                    price: 63,
                    quantity: 50,
                    count:0
                },
                {
                    title: "阿华田 薄脆巧克力饼 ",
                    path: require("@/assets/images/ovaltine.jpg"),
                    price: 9.9,
                    quantity: 88,
                    count:0
                },
                {
                    title: "农心 石锅牛肉拉面",
                    path: require("@/assets/images/noodles.jpg"),
                    price: 17,
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