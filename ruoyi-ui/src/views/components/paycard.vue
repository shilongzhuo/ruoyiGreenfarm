<template>
  <el-dialog
    title="商品结算"
    :visible.sync="dialogVisible"
    width="30%"
    :before-close="handleClose">
    <div style="height: 60%">
      <el-dropdown>
        <el-button type="primary">
          请选择支付方式<i class="el-icon-arrow-down el-icon--right"></i>
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item><p @click="pay_wechat">微信支付</p></el-dropdown-item>
          <el-dropdown-item><p @click="pay_zhifubao">支付宝支付</p></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <br>
      <img :src=img_src style="margin-top: 10px;width: 80%;height:88.96%;margin-left: 10%">
    </div>
<!--    <span slot="footer" class="dialog-footer">-->
<!--    <el-button @click="dialogVisible = false">取 消</el-button>-->
<!--    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>-->
<!--  </span>-->
  </el-dialog>
</template>

<script>
import wechat from '../green/static/img/pay/wechat.jpg'
import zhifubao from '../green/static/img/pay/zhifubao.jpg'
import eventBus from "../green/js/eventBus";
export default {
  // 显示支付界面的事件
  mounted() {
    let self = this
    eventBus.$on('show_paycard',()=>{
      self.dialogVisible = true;
    })
  },
  data() {
    return {
      dialogVisible: false,
      img_src:wechat,
    };
  },
  methods: {
    pay_wechat() {
      this.img_src = wechat
    },
    pay_zhifubao() {
      this.img_src = zhifubao
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    }
  }
};
</script>

<style>
.el-dropdown {
  vertical-align: top;
}
.el-dropdown + .el-dropdown {
  margin-left: 15px;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>
