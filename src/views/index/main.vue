<template>
    <div class="main">
        <div class="main1">
            <div class="main-list-img">
                <img src="@/assets/images/content-1.jpg" alt="">
            </div>
            <div class="main-list-item">
                <ul>
                    <li v-for="(v,i) in mainlist" :key="i">
                        <router-link to = "/details" >
                            <div class="main-list-item-img">
                                <img :src="v.path" alt="">
                            </div>
                            <div class="main-list-item-title"> 
                                <h4>{{ v.title }}</h4>
                            </div>
                            
                            <div class="main-list-item-price">
                                <h5> ￥ {{v.price}}</h5>
                            </div>
                            <div class="main-list-item-button">
                                <button>立即订购</button>
                            </div>
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main2">
            <div class="main-list-img1">
                <img src="@/assets/images/content-2.jpg" alt="">
            </div>
            <div class="main-list-item">
                <ul>
                    <li v-for="(v,i) in mainlist2" :key="i">
                        <router-link to = "/details" >
                            <div class="main-list-item-img">
                                <img :src="v.path" alt="">
                            </div>
                            <div class="main-list-item-title"> 
                                <h4>{{ v.title }}</h4>
                            </div>
                            <div class="main-list-item-price">
                                <h5> ￥ {{v.price}}</h5>
                            </div>
                            <div class="main-list-item-button">
                                <button>立即订购</button>
                            </div>
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main3">
            <div class="main-list-img2">
                <img src="@/assets/images/content-3.jpg" alt="">
            </div>
            <div class="main-list-item">
                <ul>
                    <li v-for="(v,i) in mainlist3" :key="i">
                        <router-link to = "/details" >
                            <div class="main-list-item-img">
                                <img :src="v.path" alt="">
                            </div>
                            <div class="main-list-item-title"> 
                                <h4>{{ v.title }}</h4>
                            </div>
                            <div class="main-list-item-price">
                                    <h5> ￥ {{v.price}}</h5>
                                </div>
                            <div class="main-list-item-button">
                                <button>立即订购</button>
                            </div>
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
export default{
    data(){
        return{
            mainlist: [
                {title:"日日鲜 无抗土鸡蛋 ",price:12,path:require("@/assets/images/egg.png")},
                {title:"草原队长 呼伦贝尔原切牛肉 ",price:148,path:require("@/assets/images/beef.png")},
                {title:"东来顺 内蒙古原切羊肉 ",price:178,path:require("@/assets/images/lamb.png")},
                {title:"肉管家 西班牙进口黑猪颈骨 ",price:158,path:require("@/assets/images/pork.png")}
            ],
            mainlist2: [
                {title:"佳沛 新西兰金奇异果 ",price:178,path:require("@/assets/images/kiwi.jpg")},
                {title:"恰好庄园 软糯玉米 ",price:18,path:require("@/assets/images/jagong.jpg")},
                {title:"美吉蔬 草莓淡雪 ",price:116,path:require("@/assets/images/strawberry.jpg")},
                {title:"越南 红心火龙果 ",price:57,path:require("@/assets/images/dragonfruit.jpg")}
            ],
            mainlist3: [
                {title:"MAGNUM梦龙 抹茶雪糕 ",price:63,path:require("@/assets/images/magnum.jpg")},
                {title:"阿华田 薄脆巧克力饼 ",price:9.9,path:require("@/assets/images/ovaltine.jpg")},
                {title:"东方树叶 茉莉花茶 ",price:21,path:require("@/assets/images/tea.jpg")},
                {title:"农心 石锅牛肉拉面 ",price:17,path:require("@/assets/images/noodles.jpg")}
            ]         
        }
    }
}
</script>
  