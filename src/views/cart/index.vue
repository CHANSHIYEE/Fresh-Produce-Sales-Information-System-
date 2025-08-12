
<template>
  <div class="cart">
    <NavBottom />
    <div class="cart-header">
      <div class="cart-header-contain">
        <div class="cart-title">购物车</div>
      </div>
    </div>
      <div v-if="cartList.length !== 0">
        <div class="cart-box">
          <div v-for="(item, index) in cartList" :key="index" class="cart-list-item">
            <div class="cart-item-info">
              <div class="cart-item-left">
                <div class="left-check" v-on:click="checkCurrent(item)">
                  <div class="checkbox">
                    <div v-if="item.checked" class="selected-check"></div>
                    <div v-else></div>
                  </div>
                </div>
                <el-image :src="item.image">
                  <div slot="placeholder" class="image-slot">
                    Loading<span class="dot">...</span>
                  </div>
                  <div slot="error" class="image-slot">
                    <el-image
                      fit="contain"
                      style="height: 100px"
                      src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png"
                    ></el-image>
                  </div>
                </el-image>
              
              
              <div class="cart-item-right">
                <div class="cart-item-info-content">
                  <div class="goods-name">
                    {{ item.productName }}
                  </div>

                  <div class="numbers">
                    <div class="price">价格：{{ item.price * item.num }}</div>
                  </div>
                  
                </div>
                
                <div class="cart-item-opera">
                  <el-input-number
                    setp="1"
                    :min="1"
                    v-model="item.num"
                    plain
                    v-on:change="calTotalPrice()"
                  ></el-input-number>
                  
                </div>
              </div>
            </div>
          </div>

            <div class="del-btn" v-on:click="delGood(item.id)">
              <span class="fa fa-trash-o"></span>
            </div>
          </div>
          
        </div>
        

        <div class="bottom-all">
          <div class="left">
            <div class="left-check">
              <el-checkbox
                class="all-check-checkbox"
                v-model="isAllChecked"
                v-on:change="checkAll"
                >全选</el-checkbox
              >
            </div>
            <div class="del-text" v-show="isAllChecked" v-on:click="delAll">
              删除
            </div>
          </div>
          <div class="rights">
            合计：
            <span class="total-pay-count">{{ cartTotalPrice }}</span>
          </div>
          <div v-if="selectionData.length > 0" class="settlement-active">
            结算
          </div>
          <div v-else class="settlement-inactive">结算</div>
        </div>
      </div>
    </div>     
</template>

<script>
import NavBottom from '@/views/nav.vue'
export default {
      name: "shopCart",
      data() {
        return {
          //选中数据
          selectionData: [],
          // 购物车列表
          cartList: [],
          // 加载
          loading: false,
          // 购物车总数
          cartTotalCount: 0,
          // 购物车总价格
          cartTotalPrice: 0.0,
          // 是否是移动端
          isMobile: false,
          // 是否全选
          isAllChecked: false,
        };
      },
      created() {
        let _this = this;
        // 初始化数据
        _this.initData();
      },
      mounted() {
        let _this = this;
        // 自适应
        _this.resizeLayout();
        window.onresize = function () {
          _this.resizeLayout();
        };
      },
        //组件
        components:{
          NavBottom, 
        },
        methods: {
    // 选择当前商品
    checkCurrent(item) {
      let _this = this;
      // 如果商品是被勾选的
      if (item.checked) {
        // 从被选择数组中清除
        _this.selectionData.forEach((sItem, sIndex) => {
          if (sItem.id === item.id) {
            _this.selectionData.splice(sIndex, 1);
          }
        });
        // 勾选状态变为false
        _this.cartList.forEach((cItem, cIndex) => {
          if (cItem.id === item.id) {
            _this.cartList[cIndex]["checked"] = false;
          }
        });
      } else {
        // 如果商品是未被勾选的
        // 勾选状态变为true
        _this.cartList.forEach((cItem, cIndex) => {
          if (cItem.id === item.id) {
            _this.cartList[cIndex]["checked"] = true;
          }
        });
        // 添加到被选择数组中
        _this.selectionData.push(item);
      }
      // 如果被选择数组没有数据 则全选为false
      if (_this.selectionData.length <= 0) {
        _this.isAllChecked = false;
      }
      // 如果被选择数组数组长度和购物车数组长度相同 则全选为true
      if (_this.selectionData.length === _this.cartList.length) {
        _this.isAllChecked = true;
      }
      // 计算商品总价和总数量
      _this.calTotalPrice();
    },
    //响应式布局
    resizeLayout() {
      // 浏览器宽
      let width =
        document.documentElement.offsetWidth || document.body.offsetWidth;
      let height =
        document.documentElement.clientHeight || document.body.clientHeight;
      let _this = this;
      if (width > 700) {
        _this.isMobile = false;
      } else {
        _this.isMobile = true;
      }
    },

    // 初始化数据
    initData() {
      let _this = this;
      _this.getList();
    },

    // 获取购物车列表
    getList() {
      let _this = this;
      _this.cartList = [
        {
          id: "2142423",
          image: "",
          productName: "测试商品1",
          // 单价
          price: 12,
          // 购买数量
          num: 1,
          // 如果api返回的数据中没有类似checked这种判断是否选中的字段
          // 可以在获取收据后 初始化时遍历添加一遍
          checked: false,
        },
        {
          id: "2142423424",
          image: "",
          productName: "测试商品2",
          price: 32,
          num: 2,
          checked: false,
        },
      ];
    },

    // 计算总价和总数量
    calTotalPrice() {
      let _this = this;
      _this.cartTotalPrice = 0;
      _this.cartTotalCount = 0;
      // 如果有选中项
      if (_this.selectionData.length > 0) {
        _this.selectionData.forEach((item) => {
          _this.cartTotalPrice += item.num * item.price;
          _this.cartTotalCount += item.num;
        });
      }
    },
    // 控制选择商品
    handleSelectionChange(data) {
      let _this = this;
      _this.selectionData = data;
      // 这里嵌套循环需要优化
      _this.cartList.forEach((good) => {
        if (_this.selectionData.length > 0) {
          // 如果在被选择数组中存在 则checked为true
          _this.selectionData.forEach((selectedItem) => {
            if (selectedItem.id === good.id) {
              good.checked = true;
            } else {
              good.checked = false;
            }
          });
        } else {
          // 如果在被选择数组中没有数据则checked全设置为false
          good.checked = false;
        }
      });
      let cartTotalChecked = _this.selectionData.length;
      if (_this.cartList.length === cartTotalChecked) {
        _this.isAllChecked = true;
      } else {
        _this.isAllChecked = false;
      }
      _this.calTotalPrice();
    },
    // 	全部删除
    delAll() {
      let _this = this;
      _this
        .$confirm("确定要删除全部商品吗?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
        .then(function () {
          // 这里只是前端删除
          _this.cartList = [];
          _this.isAllChecked = false;
          // 删除后需要重新获取数据刷新页面
          //   _this.getList();
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // 单个删除
    delGood(id) {
      let _this = this;
      if (!id) {
        _this.$message.error("商品有误，请刷新后重试");
        return;
      }
      _this
        .$confirm("确定要删除此商品吗?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
        .then(function () {
          let goodIndex = 0;
          _this.cartList.forEach((item, index) => {
            if (item.id === id) {
              goodIndex = index;
            }
          });
          _this.cartList.splice(goodIndex, 1);
          //   _this.getList();
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // 全选
    checkAll() {
      let _this = this;
      // 如果全选
      if (_this.isAllChecked) {
        _this.getList();
        // 将购物车列表复制给被选择数组
        _this.selectionData = JSON.parse(JSON.stringify(_this.cartList));
        _this.cartList.forEach((cItem, cIndex) => {
          _this.cartList[cIndex]["checked"] = true;
        });
        if (_this.$refs.cartTable) {
          _this.$refs.cartTable.clearSelection();
          // el table全部选中
          _this.$refs.cartTable.toggleAllSelection();
        }
      } else {
        _this.cartList.forEach((cItem, cIndex) => {
          _this.cartList[cIndex]["checked"] = false;
        });
        _this.selectionData = [];
        if (_this.$refs.cartTable) {
          // el table清空选中
          _this.$refs.cartTable.clearSelection();
        }
      }
      _this.calTotalPrice();
    },
  },
};
</script>
  
<style>
</style>
