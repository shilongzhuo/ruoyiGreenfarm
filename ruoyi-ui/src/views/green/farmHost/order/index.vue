<template>
  <div>
    <v-orderlist></v-orderlist>
  </div>
</template>

<script>
// import timeline from "./timeline";
import orderlist from "../order/orderlist";
export default {
  name: "index",
  data()
    {
      return {
        msg: "Hello Vue",
        orders: [{
          orderid: '',
          name: "香蕉",
          price: 20,
          src: 'https://gitee.com/shilong-com/typora-img/raw/master/typora-img/%E5%A4%A7%E7%99%BD%E8%8F%9C.png',
          details: "xxxx"
        }]
      }
      },
  components:{
    'v-orderlist':orderlist
  }
}
</script>

<style scoped>

</style>
