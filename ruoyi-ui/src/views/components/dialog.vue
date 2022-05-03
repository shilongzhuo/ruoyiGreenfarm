<template>
  <div>
    <el-dialog :visible.sync="dialogFormVisible" :close-on-click-modal="false" :show-close="false">
      <div slot="title" class="header-title">
        <span style="font-size:18px;color:#333333;">农场详情</span>
        <span style="float: right;font-size: 24px;padding: 0 10px;cursor: pointer;" @click="closeDialog">×</span>
      </div>
      <v-banner></v-banner>
      <div style="clear: both; height: 15px"></div>
      <el-form :model="form" style="width: 90%">
        <el-form-item label="农场编号" :label-width="formLabelWidth">
          <el-input
            v-model="form.name"
            autocomplete="off"
            placeholder="FARM1"
            maxlength="10"
            :disabled="true"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="农场面积" :label-width="formLabelWidth">
          <el-input
            v-model="form.name"
            autocomplete="off"
            placeholder="450"
            maxlength="10"
            :disabled="true"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="价格(每年)" :label-width="formLabelWidth">
          <el-input
            v-model="form.name"
            autocomplete="off"
            placeholder="450"
            maxlength="10"
            :disabled="true"
            show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-input
            v-model="form.name"
            autocomplete="off"
            placeholder="长沙市橘子洲头"
            maxlength="10"
            :disabled="true"
            show-word-limit></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="onSubmit">立即购买</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import banner from "./banner";
import table from "./table";
import eventBus from "../green/js/eventBus";
export default {
  components:{
    'v-banner':banner,
    'v-table':table,
  },
  data () {
    return {
      dialogFormVisible: false,
      form: {
        name: ''
      },
      formLabelWidth: '120px'
    }
  },
  // 显示对话框的事件
  mounted() {
    let self = this
    eventBus.$on('show_dialog',(e)=>{
      // alert(e)
      self.dialogFormVisible = true;
    })
  },
  methods: {
    // 关闭弹框的事件
    closeDialog () {
      this.form.name = ''
      this.dialogFormVisible = false
    },
    // 点击确定事件
    onSubmit () {

  }

}
}
</script>
