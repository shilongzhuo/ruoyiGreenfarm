<template>
  <div>
    <el-card style="width: 80%;margin-left: 10%">
      <div slot="title" class="header-title">
        <span style="font-size:18px;color:#333333;">农场详情</span>
        <span style="float: right;font-size: 24px;padding: 0 10px;cursor: pointer;" @click="closeDialog">×</span>
      </div>
      <div style="clear: both; height: 15px"></div>
      <el-form :model="form" style="width: 90%">
        <el-form-item label="订单编号" :label-width="formLabelWidth">
          <el-input
            placeholder="65865325365966"
            :disabled="true"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="消费时间" :label-width="formLabelWidth">
          <el-input
            placeholder="2021年7月20日"
            maxlength="10"
            :disabled="true"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="消费金额" :label-width="formLabelWidth">
          <el-input
            :placeholder=this.$route.query.id
            :maxlength="10"
            :disabled="true"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="收件人" :label-width="formLabelWidth">
          <el-input
          v-model="myRecipient"
            maxlength="20"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="联系方式" :label-width="formLabelWidth">
          <el-input
            maxlength="11"
            minlength="11"
            v-model="myTel"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="收货地址" :label-width="formLabelWidth">
          <el-input v-model="myAddress"></el-input>
        </el-form-item>

      </el-form>
      <el-footer>
        <el-button type="info" style="float: left" round @click="cancel_order">取消</el-button>
        <el-button type="success" style="float: right" round @click="alter_paycard">提交</el-button>
      </el-footer>
    </el-card>
    <v-paycard></v-paycard>
  </div>
</template>
<script>

import eventBus from "../../js/eventBus";
import paycard from "../../../components/paycard";
import axios from "@/plugins/axios";
export default {
  name:"index",
  components:{
    'v-paycard':paycard,
  },
  data () {

    return {
      money:0,
      myRecipient:'',
      myTel:'',
      myAddress:'',
      dialogFormVisible: true,
      form: {
        name: ''
      },
      formLabelWidth: '120px'
    }
  },
  // 显示对话框的事件
  mounted() {
    let self = this
    eventBus.$on('show_dialog',()=>{
      self.dialogFormVisible = true;
    })
  },
  methods: {
    // 取消订单,返回购物车
    cancel_order () {
      this.$router.push({path:'cart',query: {id:'1'}})    //跳转
    },
    alter_paycard () {
      eventBus.$emit('show_paycard');
    },
    // 关闭弹框的事件
    closeDialog () {
      this.form.name = ''
      this.dialogFormVisible = false
    },
    data()
    {

    },
    // 点击确定事件
    onSubmit () {
      if (this.form.name === '') {
        this.commonTip('请输入分类名称')
        return false
      }
      this.dialogFormVisible = false
      // 这里写你确定之后的事件

      axios.post(
        'http://localhost:9205/order/add',e)

    }
  },
  created() {
  }

}
</script>

