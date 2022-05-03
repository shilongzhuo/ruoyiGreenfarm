<template>
  <div style="display:block;align-content: center;width: 80%;margin-left: 10%;">
    <el-col :span="12">
      <img src="../green/static/img/searchinput/logo.png" style="height: 40%; width: 30%;margin-left: 10px">
    </el-col>
    <el-col :span="12" style="text-align: center;display: inline-block">
    <div class="search-wrapper-box"style="display: inline-block">
      <el-input
        style="margin-top: 20px;margin-left: 10px;width: 80%"
        v-model="sceneName"
        class="search-input elc-list-input"
        size="mini"
        :placeholder="placeholderName"
        @keyup.native.enter="searchCon"
      >
        <i slot="prefix" class="el-input__icon el-icon-search search-icon" @click="searchCon" />
      </el-input>
      <!-- <div class="a"></div> -->
    </div>
      <el-button type="success" round style="margin-top: 20px;height:40px;display: inline-block">搜索</el-button>
    </el-col>
  </div>
</template>
<script>
  import logo from '../green/static/img/searchinput/logo.png'
export default {
  name: 'SearchInput',
  props: {
    placeholderName: {

      type: String,
      default: '请输入你想查找的商品',
    },
  },
  data() {
    lg : logo
    return {
      sceneName: '',
    }
  },
  methods: {
    searchCon() {
      this.$emit('sendSearchName', this.sceneName)
    },
  },
}
</script>
<style lang="scss" scoped>
.search-wrapper-box {
  right: 50px;
  top: 50px;
  width: 306px;
  // 搜索框样式覆盖
  .search-input {
    ::v-deep .el-input__inner {
      height: 45px;
      line-height: 45px;
      border-radius: 23px;
      padding-left: 40px;
      font-size: 14px;
    }
    ::v-deep .el-input__icon {
      margin: 3px 0 0 5px;
      font-size: 18px;
    }
  }
}
</style>
