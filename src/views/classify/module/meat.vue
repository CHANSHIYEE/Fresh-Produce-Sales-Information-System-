<template>
    <div class="classify-right">
        <ul>
            <li v-for="(v,i) in meatlist" :key="i">
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
            meatlist: [
                {
                    title: "日日鲜 无抗土鸡蛋 ",
                    path: require("@/assets/images/egg.png"),
                    price: 12,
                    quantity: 50,
                    count:0
                },
                {
                    title: "草原队长 呼伦贝尔原切牛肉  ",
                    path: require("@/assets/images/beef.png"),
                    price: 148,
                    quantity: 88,
                    count:0
                },
                {
                    title: "东来顺 内蒙古原切羊肉  ",
                    path: require("@/assets/images/lamb.png"),
                    price: 178,
                    quantity: 34,
                    count:0
                },
                {
                    title: "肉管家 西班牙进口黑猪颈骨 ",
                    path: require("@/assets/images/pork.png"),
                    price: 158,
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