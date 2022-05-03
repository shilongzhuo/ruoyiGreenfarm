<template> 
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets"></i>
      <span>申请列表</span>
    </el-card>
    <div class="table-container">
      <el-table ref="returnApplyTable"
                :data="list"
                style="width: 100%;"
                @selection-change="handleSelectionChange"
                border>
        <el-table-column type="selection" width="60" align="center"></el-table-column>
        <el-table-column label="申请单号" width="180" align="center">
          <template slot-scope="scope">{{scope.row.myId}}</template>
        </el-table-column>
        <el-table-column label="申请时间" width="180" align="center">
          <template slot-scope="scope">{{scope.row.myDate}}</template>
        </el-table-column>
        <el-table-column label="用户账号" align="center">
          <template slot-scope="scope">{{scope.row.myAccount}}</template>
        </el-table-column>
        <el-table-column label="身份证号" width="180" align="center">
          <template slot-scope="scope">{{scope.row.mySfid}}</template>
        </el-table-column>
        <el-table-column label="申请状态" width="180" align="center">
          <template slot-scope="scope">{{scope.row.myStatus}}</template>
        </el-table-column>
        <!--        <el-table-column label="操作" width="180" align="center">-->
        <!--          <template slot-scope="scope">-->
        <!--            <el-button-->
        <!--            size="mini"-->
        <!--            @click="handleViewDetail(scope.$index, scope.row)">查看详情</el-button>-->
        <!--          </template>-->
        <!--        </el-table-column>-->
      </el-table>
    </div>
    <!--    <div class="batch-operate-container">-->
    <!--      <el-select-->
    <!--        size="small"-->
    <!--        v-model="operateType" placeholder="批量操作">-->
    <!--        <el-option-->
    <!--          v-for="item in operateOptions"-->
    <!--          :key="item.value"-->
    <!--          :label="item.label"-->
    <!--          :value="item.value">-->
    <!--        </el-option>-->
    <!--      </el-select>-->
    <!--      <el-button-->
    <!--        style="margin-left: 20px"-->
    <!--        class="search-button"-->
    <!--        @click="handleBatchOperate()"-->
    <!--        type="primary"-->
    <!--        size="small">-->
    <!--        确定-->
    <!--      </el-button>-->
    <!--    </div>-->
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="total, sizes,prev, pager, next,jumper"
        :current-page.sync="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[5,10,15]"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {formatDate} from '../rentMessage/js/date';
// import {fetchList,deleteApply} from '@/api/returnApply';
const defaultListQuery = {
  pageNum: 1,
  pageSize: 10,
  id: null,
  receiverKeyword: null,
  status: null,
  createTime: null,
  handleMan: null,
  handleTime: null
};
const defaultStatusOptions=[
  {
    label: '待处理',
    value: 0
  },
  {
    label: '已同意',
    value: 1
  },
  {
    label: '已拒绝',
    value: 2
  },
];
export default {
  name:'returnApplyList',
  data() {
    return {
      listQuery:Object.assign({},defaultListQuery),
      statusOptions: Object.assign({},defaultStatusOptions),
      list:[{
        myId:'APPLY-001',
        myDate:"2021年7月17日",
        'myAccount':"钟震坤",
        'mySfid':"412826200111056018",
        'myStatus':"已同意"
      },
        {
          myId:'APPLY-002',
          myDate:"2021年7月20日",
          'myAccount':"陶永东",
          'mySfid':"412826200111056018",
          'myStatus':"待处理"
        }
      ],
      total:null,
      listLoading:false,
      multipleSelection:[],
      operateType:1,
      operateOptions: [
        {
          // label: "批量删除",
          value: 1
        }
      ],
    }
  },
  created(){
    this.getList();
  },
  filters:{
    formatTime(time) {
      if(time==null||time===''){
        return 'N/A';
      }
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
    },
    formatStatus(status){
      for(let i=0;i<defaultStatusOptions.length;i++){
        if(status===defaultStatusOptions[i].value){
          return defaultStatusOptions[i].label;
        }
      }
    },
    formatReturnAmount(row){
      return row.productRealPrice*row.productCount;
    }
  },
  methods:{
    handleSelectionChange(val){
      this.multipleSelection = val;
    },
    handleViewDetail(index,row){
      this.$router.push({path:'/oms/returnApplyDetail',query:{id:row.id}})
    },
    handleBatchOperate(){
      if(this.multipleSelection==null||this.multipleSelection.length<1){
        this.$message({
          message: '请选择要操作的申请',
          type: 'warning',
          duration: 1000
        });
        return;
      }
      if(this.operateType===1){
        //批量删除
        this.$confirm('是否要进行删除操作?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let params = new URLSearchParams();
          let ids=[];
          for(let i=0;i<this.multipleSelection.length;i++){
            ids.push(this.multipleSelection[i].id);
          }
          params.append("ids",ids);
          // deleteApply(params).then(response=>{
          //   this.getList();
          //   this.$message({
          //     type: 'success',
          //     message: '删除成功!'
          //   });
          // });
        })
      }
    },
    handleSizeChange(val){
      this.listQuery.pageNum = 1;
      this.listQuery.pageSize = val;
      this.getList();
    },
    handleCurrentChange(val){
      this.listQuery.pageNum = val;
      this.getList();
    },
    getList(){
      this.listLoading=true;
      // fetchList(this.listQuery).then(response => {
      //   this.listLoading = false;
      //   this.list = response.data.list;
      //   this.total = response.data.total;
      // });
    }
  }
}
</script>
<style scoped>
.input-width {
  width: 203px;
}
</style>


