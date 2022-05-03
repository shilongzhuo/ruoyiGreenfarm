<template>
  <div>
    <v-cart></v-cart>
    <v-paycard></v-paycard>
  </div>
</template>

<script>
import cart from "../../../components/cart";
import paycard from "../../../components/paycard";
export default {
  name: "index",
  components:{
    'v-cart':cart,
    'v-paycard':paycard,
  }
}
</script>

<style scoped>

</style>
