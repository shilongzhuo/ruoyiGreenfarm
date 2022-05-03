<template> 
  <el-dialog title="修改农场信息"
             :visible.sync="visible"
             :before-close="handleClose"
             width="40%">
    <div>农场编号：
      <el-input
      disabled="true"
      placeholder="202107171301"
      style="width: 80%">
    </el-input></div>
    <br>
    <div>农场名称：
      <el-input
        disabled="true"
        placeholder="阳光农场"
        style="width: 80%">
      </el-input></div>
    <br>
    <div>农场面积(平方米)：
      <el-input
        style="width: 71%">
      </el-input></div>
    <br>
    <div>农场价格：
      <el-input
        style="width: 80%">
      </el-input></div>
    <br>
    <div>农场地址：
      <el-input
        style="width: 80%">
      </el-input></div>
    <br>
    <el-button
      @click="sub_alert"
      type="success"
      style="margin-left: 45%">提交</el-button>
  </el-dialog>
</template>

<script>

export default {
  name:'alert_farm',
  props: {
    value: Boolean
  },
  computed:{
    visible: {
      get() {
        return this.value;
      },
      set(visible){
        this.value=visible;
      }
    },

  },
  data() {
    return {
      logisticsList:Object.assign({},defaultLogisticsList)
    }
  },
  methods:{
    sub_alert(){
      this.value=false
    },
    show_dialog(){
      this.value=true
    },
    emitInput(val) {
      this.$emit('input', val)
    },
    handleClose(){
      this.emitInput(false);
    }
  }
}
</script>

<style scoped>

</style>
