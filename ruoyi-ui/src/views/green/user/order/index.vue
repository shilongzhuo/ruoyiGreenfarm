<template>
  <el-table
    :data="tableData"
    style="width: 80%;margin-left: 10%;margin-top: 2%"
    max-height="80%">
    <el-table-column
      fixed
      prop="orderid"
      label="订单编号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="orderdate"
      label="下单时间"
      width="200">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="联系电话"
      width="150">
    </el-table-column>
    <el-table-column
      prop="address"
      label="收货地址"
      width="350">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="查看订单"
      width="120">
      <template>
        <el-button icon="el-icon-search" circle @click="look_order"></el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import axios from "../../../../plugins/axios"
export default {
  methods: {
    look_order(){
      this.$router.push({path:'orderdetails',query: {id:'1'}})
    }
  },
  data() {
    return {
      tableData: [{
        orderid: 'ord-1',
        orderdate: '2021-07-13',
        address: '中南大学铁道学院',
        phone: '19108475144'
      }]
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:9205/order/getall').then(function (resp) {
      console.log(resp)
      _this.tableData = resp.data;
    })
  }
}
</script>

<style>

</style>
