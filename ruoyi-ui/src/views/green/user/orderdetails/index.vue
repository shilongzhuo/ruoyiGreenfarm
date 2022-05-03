<template>
  <div class="detail-container">
    <el-card shadow="never" style="margin-top: 15px">



      <div style="margin-top: 20px">
        <svg-icon icon-class="marker" style="color: #606266"></svg-icon>
        <span class="font-small">基本信息</span>
      </div>
      <div class="table-layout">
        <el-row>
          <el-col :span="6" class="table-cell-title">订单编号</el-col>
          <el-col :span="6" class="table-cell-title">支付方式</el-col>
          <el-col :span="6" class="table-cell-title">订单来源</el-col>
          <el-col :span="6" class="table-cell-title">订单类型</el-col>
        </el-row>
        <el-row>
          <el-col :span="6" class="table-cell">ord-1</el-col>
          <el-col :span="6" class="table-cell">支付宝</el-col>
          <el-col :span="6" class="table-cell">手机APP</el-col>
          <el-col :span="6" class="table-cell">今日优选</el-col>
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
          <el-col :span="6" class="table-cell">陶永东</el-col>
          <el-col :span="6" class="table-cell">19108475144</el-col>
          <el-col :span="6" class="table-cell">410011</el-col>
          <el-col :span="6" class="table-cell">中南大学铁道学院 </el-col>
        </el-row>
      </div>
    </el-card>

    <div style="margin-top: 20px">
      <svg-icon icon-class="marker" style="color: #606266"></svg-icon>
      <span class="font-small">商品信息</span>
    </div>

    <el-table
      :data="tableData"
      style="width: 100%;margin-top: 20px" border>
      <el-table-column label="商品图片" width="120" align="center" prop="productPic">
        <template slot-scope="scope">
          <img :src="scope.row.productPic" style="height: 80px">
        </template>
      </el-table-column>
      <el-table-column label="商品名称" align="center" prop="productName">
        <template slot-scope="scope">
          <p>{{scope.row.productName}}</p>
        </template>
      </el-table-column>
      <el-table-column label="价格" width="120" align="center" prop="productPrice">
        <template slot-scope="scope">
          <p>价格：￥{{scope.row.productPrice}}</p>
        </template>
      </el-table-column>
      <el-table-column label="属性" width="120" align="center" prop="productAttr">
        <template slot-scope="scope">
          {{scope.row.productAttr}}
        </template>
      </el-table-column>
      <el-table-column label="数量" width="120" align="center" prop="productQuantity">
        <template slot-scope="scope">
          {{scope.row.productQuantity}}
        </template>
      </el-table-column>
      <el-table-column label="小计" width="120" align="center">
        <template slot-scope="scope">
          ￥{{scope.row.productPrice*scope.row.productQuantity}}
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
      tableData:[
        {
          'productPic':'https://gitee.com/shilong-com/typora-img/raw/master/typora-img/%E4%B8%8A%E6%B5%B7%E9%9D%92.png',
          'productName':'上海青',
          'productPrice':4.79,
          'productAttr':'蔬菜',
          'productQuantity':2,
        },
        {
          'productPic':'https://gitee.com/shilong-com/typora-img/raw/master/typora-img/%E6%9F%9A%E5%AD%90.png',
          'productName':'新鲜柚子',
          'productPrice':26.8,
          'productAttr':'水果',
          'productQuantity':1,
        }
      ]
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
