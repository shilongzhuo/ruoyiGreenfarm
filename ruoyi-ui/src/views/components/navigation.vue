<!--导航栏-->
<template>
  <div style="align-content: center;width: 80%;margin-left: 10%">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b">
      <el-col :span="24" style="text-align: center">
        <el-menu-item index="1">今日优选</el-menu-item>
      </el-col>
  </el-menu>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
