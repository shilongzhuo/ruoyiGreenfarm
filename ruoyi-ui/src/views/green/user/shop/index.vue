<template>
  <div>
    <div style="clear: both; height: 5px"></div>   <!--起换行加间隔效果-->
    <v-searchinput></v-searchinput>
    <div style="clear: both; height: 15px"></div>
    <v-banner></v-banner>
    <div style="clear: both; height: 15px"></div>
    <v-navigation></v-navigation>
    <div style="clear: both; height: 15px"></div>
    <v-card></v-card>
  </div>

</template>

<script>
import banner from "../../../components/banner";
import searchinput from "../../../components/searchinput";
import navigation from "../../../components/navigation";
import card from "../../../components/card";
export default {
  name: "index",
  components:{
    'v-banner':banner,
    'v-searchinput':searchinput,
    'v-navigation' :navigation,
    'v-card':card
  }
}


</script>

<style scoped>

</style>
