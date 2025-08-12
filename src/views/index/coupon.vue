<template>
    <div class="coupon">
        <div class="coupon-list">
            <ul>
                <li v-for="(v,i) in couponlist" :key="i">
                    <div class="coupon-price">
                        <em>￥</em>
                        <b>{{ v.price }}</b>
                    </div>
                    <div class="coupon-range">
                        <p>{{v.range}}</p>
                    </div>
                    <div class="coupon-btn">
                        <button>{{v.btn}}</button>
                    </div>
                </li>
            </ul>
        </div>

    </div>
  </template>
  
  <script>

  
export default{
    data(){
        return{
            couponlist:[
                {price:'5' ,range:'满99元使用',btn:'立即领取'},
                {price:'10' ,range:'满158元使用',btn:'立即领取'},
                {price:'30' ,range:'满258元使用',btn:'立即领取'},
                {price:'100' ,range:'满600元使用',btn:'立即领取'},
            ]
        }
    }

}
  
  </script>
  