<template>
  <div style="width: 80%;margin-left: 10%;margin-top: 30px">
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      @selection-change="selected">
      <el-table-column
        type="selection"
        width="50">
      </el-table-column>
      <el-table-column
        label="商品名称"
        width="680">
        <template slot-scope="scope">
          <div style="margin-left: 50px">
            <img :src="scope.row.src" style="height: 50px;width: 50px">
            <span style="font-size: 18px;padding-left: 200px;">{{scope.row.name}}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        label="单价"
        width="150"
        prop="price">
      </el-table-column>
      <el-table-column
        label="数量"
        width="200">
        <template slot-scope="scope">
          <div>
            <el-input
              v-model="scope.row.number" @change="handleInput(scope.row)">
              <el-button slot="prepend" @click="del(scope.row)"><i class="el-icon-minus"></i></el-button>
              <el-button slot="append" @click="add(scope.row)"><i class="el-icon-plus"></i></el-button>
            </el-input>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        label="小计"
        width="150"
        prop="totalprice">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="danger" @click="handleDelete(scope.$index, scope.row)">
            删除<i class="el-icon-delete2 el-icon--right"></i>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <br>
    <div>
      <el-button type="success" style="float: right" @click="sub_order">结算</el-button>
      <el-button type="danger" style="float: contour">{{"商品总额：" + moneyTotal.toFixed(2)}}</el-button>

    </div>

  </div>
</template>

<script>
import axios from "../../plugins/axios"
export default{
  name:"cart",
  data() {
    return {
      tableData: [{
        itemid:'',
        cartid:'',
        src:'',
        name:'好好学习',
        price:5,
        number:1,
        totalprice:5,
      }],
      moneyTotal:0.00,
      multipleSelection:[],
    }
  },
  methods: {
    sub_order(){
      this.$router.push({path:'sub_order',query: {id:"￥"+this.moneyTotal.toString()}})    //跳转
    },
    handleDelete(index, row) {
      this.$confirm('确定删除该商品？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        //删除数组中指定的元素

        // this.tableData.splice(index, 1);
        axios.post(
          'http://localhost:9205/cartitem/del',this.tableData[index])
        this.$message({
          type: 'success',
          message: '删除成功!'
        });

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleInput: function (value) {
      if (null == value.number || value.number == "") {
        value.number = 1;
      }
      value.totalprice = (value.number * value.price).toFixed(2);//保留两位小数
      //增加商品数量也需要重新计算商品总价
      this.selected(this.multipleSelection);
    },
    add: function (addGood) {
      //输入框输入值变化时会变为字符串格式返回到js
      //此处要用v-model，实现双向数据绑定
      if (typeof addGood.number == 'string') {
        addGood.number = parseFloat(addGood.number);
      }
      addGood.number += 1;
      addGood.totalprice=(addGood.number * addGood.price).toFixed(2);  //保留两位小数
      //增加商品数量也需要重新计算商品总价
      this.selected(this.multipleSelection);
    },
    del: function (delGood) {
      if (typeof delGood.number == 'string') {
        delGood.number = parseFloat(delGood.number);
      }
      if (delGood.number > 1) {
        delGood.number -= 1;
      }
      delGood.totalprice=(delGood.number * delGood.price).toFixed(2); //保留两位小数
      //增加商品数量也需要重新计算商品总价
      this.selected(this.multipleSelection);
    },
    //返回的参数为选中行对应的对象
    selected: function (selection) {
      this.multipleSelection = selection;
      this.moneyTotal = 0.00;
      //此处不支持forEach循环，只能用原始方法了
      for (var i = 0; i < selection.length; i++) {
        //判断返回的值是否是字符串
        if (typeof selection[i].totalprice == 'string') {
          selection[i].totalprice = parseFloat(selection[i].totalprice);
        }
        this.moneyTotal += selection[i].totalprice;
      }
    }
  },
   created() {
    const _this = this
    axios.get('http://localhost:9205/cartitem/getall').then(function (resp) {
      console.log(resp)
      _this.tableData = resp.data;
    })
  }
}
</script>
