<template>

  <div id="banner" style="width: 80%;margin-left: 10%;height:49.44%">
    <!--动态将图片轮播图的容器高度设置成与图片一致-->
    <el-carousel :height="bannerHeight + 'px'">
      <!--遍历图片地址,动态生成轮播图-->
      <el-carousel-item v-for="item in imgList" :key="item">
        <el-image :src="item.url" style="width: 100%;height: 100%" auto/>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "banner",
  data() {
    return {
      // 图片地址数组
      imgList: [
        {
          url: require("../green/static/img/banner/b1.png")
        },
        {
          url: require("../green/static/img/banner/b2.png")
        },
        {
          url: require("../green/static/img/banner/b3.png")
        }
      ],
      // 图片父容器高度
      bannerHeight: 1000,
      // 浏览器宽度
      screenWidth: 0
    };
  },
  methods: {
    setSize: function() {
      // 通过浏览器宽度(图片宽度)计算高度
      this.bannerHeight = (400 / 1920) * this.screenWidth;
    }
  },
  mounted() {
    // 首次加载时,需要调用一次
    this.screenWidth = window.innerWidth;
    this.setSize();
    // 窗口大小发生改变时,调用一次
    window.onresize = () => {
      this.screenWidth = window.innerWidth;
      this.setSize();
    };
  }
};
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
