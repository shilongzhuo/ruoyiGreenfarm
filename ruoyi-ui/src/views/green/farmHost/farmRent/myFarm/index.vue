
<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 80%;margin-left: 10%;margin-top: 2%"
      max-height="80%">
      <el-table-column
        fixed
        prop="id"
        label="农场编号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        label="农场名称"
        width="120">
      </el-table-column>
      <el-table-column
        prop="area"
        label="农场面积"
        width="120">
      </el-table-column>
      <el-table-column
        prop="price"
        label="价格(每年)"
        width="120">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址"
        width="350">
      </el-table-column>

      <el-table-column
        fixed="right"
        label="详情"
        width="240">
        <template #default="scope">
          <el-button
            type="success"
            mini
          @click="show_alert_myfarm">
            修改信息
          </el-button>
          <el-button
            @click="handleDelete(scope.$index, scope.row)"
            type="danger"
            mini>
            农场下架
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <v-alert_farm v-model="logisticsDialogVisible"></v-alert_farm>
  </div>
</template>

<script>
import alert_farm from "@/views/green/farmHost/farmRent/myFarm/alert_farm";
export default {
  name:'index',
  components:{
    'v-alert_farm':alert_farm
  },
  methods: {
    show_alert_myfarm(){
      this.logisticsDialogVisible=true
    },
    handleDelete(index, row){
      this.$confirm('确定下架该农场？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        //删除数组中指定的元素
        this.tableData.splice(index, 1);
        this.$message({
          type: 'success',
          message: '下架成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消下架'
        });
      });
    }
  },
  data() {
    return {
      tableData: [{
        id: '20210714001',
        name: '阳光农场',
        area: '200',
        navagation: '3',
        address: '长沙市橘子洲头',
        price: 200333
      }, {
        id: '20210714001',
        name: '阳光农场',
        area: '200',
        navagation: '3',
        address: '长沙市橘子洲头',
        price: 200333
      }, {
        id: '20210714001',
        name: '阳光农场',
        area: '200',
        navagation: '3',
        address: '长沙市橘子洲头',
        price: 200333
      }, {
        id: '20210714001',
        name: '阳光农场',
        area: '200',
        navagation: '3',
        address: '长沙市橘子洲头',
        price: 200333
      }],
      logisticsDialogVisible:false,
    }
  }
}
</script>

<style>

</style>
