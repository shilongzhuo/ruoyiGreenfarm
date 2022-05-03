<template>
  <el-table
    :data="tableData"
    style="width: 80%;margin-left: 10%;margin-top: 2%"
    max-height="80%">
    <el-table-column
      fixed
      prop="farmid"
      label="农场编号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="农场名称"
      width="120">
    </el-table-column>
    <el-table-column
      prop="price"
      label="农场面积"
      width="120">
    </el-table-column>
    <el-table-column
      prop="price"
      label="价格(每年)"
      width="120">
    </el-table-column>
    <el-table-column
      label="导航"
      width="120">
      <el-button type="primary" icon="el-icon-s-promotion" @click="ng"> </el-button>
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="350">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="详情"
      width="120">
      <template scope="scope">
        <el-button
          icon="el-icon-search"
          @click="alert_dialog"
          circle>
        </el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import axios from "../../plugins/axios"
import eventBus from "../green/js/eventBus";
export default {
  methods: {
    alert_dialog(){

      eventBus.$emit('show_dialog');
    },
    ng: function(){
      let st = "https://ditu.amap.com/search?query="+this.ast;
      window.open(st,"_blank")
    }
  },
  data() {
    return {
      ast:'长沙市橘子洲头',
      tableData: [{
        farmid: '20210714001',
        name: '阳光农场',
        area: '200',
        navagation: '3',
        address: '长沙市橘子洲头',
        price: 200333
      }]
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:9205/farm/getall').then(function (resp) {
      console.log(resp)
      _this.tableData = resp.data;
    })
  }
}

</script>

<style>

</style>
