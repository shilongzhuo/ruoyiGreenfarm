
<template>
  <el-table
    :data="tableData"
    style="width: 80%;margin-left: 10%;margin-top: 2%"
    max-height="80%">
    <el-table-column
      fixed
      prop="id"
      label="订单编号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="提交时间"
      width="160">
    </el-table-column>
    <el-table-column
      prop="area"
      label="订单金额"
      width="120">
    </el-table-column>
    <el-table-column
      prop="price"
      label="订单状态"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="配送地址"
      width="250">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="详情"
      width="220">
      <template #default="scope">
        <el-button plain size="small">订单跟踪</el-button>
        <el-button type="danger" size="small">取消订单</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import eventBus from "../green/js/eventBus";
export default {
  methods: {
    alert_dialog(){
      eventBus.$emit('show_dialog');
    }
  },
  data() {
    return {
      tableData: [{
        id: '20210714001',
        name: '2018-09-15 12:24:27',
        area: '￥194.00',
        navagation: '3',
        address: '上海市普陀区金沙江路 1518 弄',
        price: "已发货"
      }, {
        id: '20210714001',
        name: '2018-09-15 12:24:27',
        area: '￥194.00',
        navagation: '3',
        address: '上海市普陀区金沙江路 1518 弄',
        price: "已发货"
      }, {
        id: '20210714001',
        name: '2018-09-15 12:24:27',
        area: '￥194.00',
        navagation: '3',
        address: '上海市普陀区金沙江路 1518 弄',
        price: "已发货"
      }, {
        id: '20210714001',
        name: '2018-09-15 12:24:27',
        area: '￥194.00',
        navagation: '3',
        address: '上海市普陀区金沙江路 1518 弄',
        price: "已发货"
      }, {
        id: '20210714001',
        name: '2018-09-15 12:24:27',
        area: '￥194.00',
        navagation: '3',
        address: '上海市普陀区金沙江路 1518 弄',
        price: "已发货"
      }, {
        id: '20210714001',
        name: '2018-09-15 12:24:27',
        area: '￥194.00',
        navagation: '3',
        address: '上海市普陀区金沙江路 1518 弄',
        price: "已发货"
      }, {
        id: '20210714001',
        name: '2018-09-15 12:24:27',
        area: '￥194.00',
        navagation: '3',
        address: '上海市普陀区金沙江路 1518 弄',
        price: "已发货"
      }]
    }
  }
}
</script>

<style>

</style>
