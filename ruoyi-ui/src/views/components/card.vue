<template>
  <div style="width: 80%;margin-left: 10%;text-align: center">
    <el-row>
      <el-col :span="8" v-for="item in goods" :key="item">
        <el-card :body-style="{ padding: '0px' }" shadow="hover">
          <img :src= "item.src" class="image">

          <div style="padding: 0px;">
            <div class="bottom" @click="add(item)">
              <p>----------------------------------------</p>
              <p class="desc">{{item.details}}</p>
              <p style="font-size: 25px;font-weight: 700;">￥{{item.price}}</p>
<!--              <p style="font-size: 25px;font-weight: 700;">简介：{{item.details}}</p>-->
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from "../../plugins/axios"
export default {
  methods:{
    add(e){
      this.$confirm('是否将该商品加入购物车?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'success'
      }).then(() => {
        // alert(e.name)
        axios.post(
          'http://localhost:9205/cartitem/add',e)
        //   .then( (res)=>{
        //     this.list = res.data;
        //     alert(res.data)
        //   }).catch( (err)=>{
        //   console.log(err)
        // })
        this.$message({
          type: 'success',
          message: '已成功加入!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消加入'
        });
      });
    }
  },

  data() {
    return {
      msg: "Hello Vue",
      goods: [{
        itemid:'',
        name: "香蕉",
        price: 20,
        src: 'https://gitee.com/shilong-com/typora-img/raw/master/typora-img/%E5%A4%A7%E7%99%BD%E8%8F%9C.png',
        details:"xxxx"
      }]
    };

  },
  created() {
    const _this = this
    axios.get('http://localhost:9205/item/getall').then(function (resp) {
      console.log(resp)
      _this.goods = resp.data;
    })
  }
}
</script>

<style>
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  padding: 5px 15px;
  font-size: 12px;
  color: #009688;
  line-height: 1.5;
  cursor: pointer;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 133px;
  height: 130px;
  margin-left: 15px;
  margin-top: 15px;

  /*display: block;*/
}
.desc{
  font-size: 20px;
  margin: 0;
  padding: 0;

}

</style>
