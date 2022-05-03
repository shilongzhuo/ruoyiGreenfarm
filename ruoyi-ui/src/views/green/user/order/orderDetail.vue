<template>
  <div class="detail-container">
    <el-card shadow="never" style="margin-top: 15px">



      <div style="margin-top: 20px">
        <svg-icon icon-class="marker" style="color: #606266"></svg-icon>
        <span class="font-small">基本信息</span>
      </div>
      <div class="table-layout">
        <el-row>
          <el-col :span="4" class="table-cell-title">订单编号</el-col>
          <el-col :span="4" class="table-cell-title">支付方式</el-col>
          <el-col :span="4" class="table-cell-title">订单来源</el-col>
          <el-col :span="4" class="table-cell-title">订单类型</el-col>
        </el-row>
        <el-row>
          <el-col :span="4" class="table-cell">ord-1</el-col>
          <el-col :span="4" class="table-cell">支付宝</el-col>
          <el-col :span="4" class="table-cell">手机APP</el-col>
          <el-col :span="4" class="table-cell">限时秒杀</el-col>
        </el-row>
      </div>


      <div style="margin-top: 20px">
        <svg-icon icon-class="marker" style="color: #606266"></svg-icon>
        <span class="font-small">收货人信息</span>
      </div>
      <div class="table-layout">
        <el-row>
          <el-col :span="6" class="table-cell-title">收货人</el-col>
          <el-col :span="6" class="table-cell-title">手机号码</el-col>
          <el-col :span="6" class="table-cell-title">邮政编码</el-col>
          <el-col :span="6" class="table-cell-title">收货地址</el-col>
        </el-row>
        <el-row>
          <el-col :span="6" class="table-cell"></el-col>
          <el-col :span="6" class="table-cell"></el-col>
          <el-col :span="6" class="table-cell"></el-col>
          <el-col :span="6" class="table-cell"></el-col>
        </el-row>
      </div>
    </el-card>

    <div style="margin-top: 20px">
      <svg-icon icon-class="marker" style="color: #606266"></svg-icon>
      <span class="font-small">商品信息</span>
    </div>

    <el-table
      ref="orderItemTable"
      style="width: 100%;margin-top: 20px" border>
      <el-table-column label="商品图片" width="120" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.productPic" style="height: 80px">
        </template>
      </el-table-column>
      <el-table-column label="商品名称" align="center">
        <template slot-scope="scope">
          <p></p>
          <p>品牌：</p>
        </template>
      </el-table-column>
      <el-table-column label="价格/货号" width="120" align="center">
        <template slot-scope="scope">
          <p>价格：￥</p>
          <p>货号：</p>
        </template>
      </el-table-column>
      <el-table-column label="属性" width="120" align="center">
        <template slot-scope="scope">

        </template>
      </el-table-column>
      <el-table-column label="数量" width="120" align="center">
        <template slot-scope="scope">

        </template>
      </el-table-column>
      <el-table-column label="小计" width="120" align="center">
        <template slot-scope="scope">
          ￥
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "index",
  data(){
    return{

    }
  }
}
</script>

<style scoped>
.detail-container{
  width: 80%;
  padding: 20px 20px 20px 20px;
  margin: 20px auto;
}
.table-layout {
  margin-top: 20px;
  border-left: 1px solid #DCDFE6;
  border-top: 1px solid #DCDFE6;
}
.table-cell-title {
  border-right: 1px solid #DCDFE6;
  border-bottom: 1px solid #DCDFE6;
  padding: 10px;
  background: #F2F6FC;
  text-align: center;
  font-size: 14px;
  color: #303133;
}
.table-cell {
  height: 60px;
  line-height: 40px;
  border-right: 1px solid #DCDFE6;
  border-bottom: 1px solid #DCDFE6;
  padding: 10px;
  font-size: 14px;
  color: #606266;
  text-align: center;
  overflow: hidden;
}
</style>
