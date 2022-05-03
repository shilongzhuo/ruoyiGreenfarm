<template>
<div style="magin-top:50px">
  <el-card class="box-card" >
    <div style="width:80%;margin-left:10%">
  <!-- 图片上传组件辅助-->
  <div >商品名称：<el-input v-model="input1" placeholder="请输入内容" style="width:70%"></el-input></div>
  <br>
  <div >订单编号：<el-input v-model="input2" placeholder="请输入内容" style="width:70%"></el-input></div>
  <el-upload
  class="avatar-uploader"
  :action="serverUrl"
  name="img"
  :headers="header"
  :show-file-list="false"
  :on-success="uploadSuccess"
  :on-error="uploadError"
  :before-upload="beforeUpload">
  </el-upload>
  <quill-editor
  v-model="content"
  ref="myQuillEditor"
  :options="editorOption"
  @change="onEditorChange($event)"
  >
  </quill-editor>
 </div>
 <br>
 <el-button type="primary" style="margin-left:50%" @click="success">提交</el-button>
</el-card>
</div>

</template>

<script>
 const toolbarOptions = [
 ['bold', 'italic', 'underline', 'strike'],  // toggled buttons
 [{'header': 1}, {'header': 2}],    // custom button values
 [{'list': 'ordered'}, {'list': 'bullet'}],
 [{'indent': '-1'}, {'indent': '+1'}],   // outdent/indent
 [{'direction': 'rtl'}],       // text direction
 [{'size': ['small', false, 'large', 'huge']}], // custom dropdown
 [{'header': [1, 2, 3, 4, 5, 6, false]}],
 [{'color': []}, {'background': []}],   // dropdown with defaults from theme
 [{'font': []}],
 [{'align': []}],
 ['link', 'image'],
 ['clean']

 ]
 export default {
 data() {
  return {
  input1:'',
  input2:'',
  quillUpdateImg: false, // 根据图片上传状态来确定是否显示loading动画，刚开始是false,不显示
  content: null,
  editorOption: {
   placeholder: '',
   theme: 'snow', // or 'bubble'
   modules: {
   toolbar: {
    container: toolbarOptions,
    handlers: {
    'image': function (value) {
     if (value) {
     // 触发input框选择图片文件
     document.querySelector('.avatar-uploader input').click()
     } else {
     this.quill.format('image', false);
     }
    }
    }
   }
   }
  },
  serverUrl: '/manager/common/imgUpload', // 这里写你要上传的图片服务器地址
  header: {
   // token: sessionStorage.token
  } // 有的图片服务器要求请求头需要有token
  }
 },
 methods: {
   success(){
     this.$confirm("提交成功","系统提示",{
       confirmButtonText:"确定"
     }).then(()=>{
       location.reload();
     })
   },
  onEditorChange({editor, html, text}) {//内容改变事件
  console.log("---内容改变事件---")
  this.content = html
  console.log(html)
  },
  // 富文本图片上传前
  beforeUpload() {
  // 显示loading动画
  this.quillUpdateImg = true
  },

  uploadSuccess(res, file) {
  // res为图片服务器返回的数据
  // 获取富文本组件实例
  console.log(res);
  let quill = this.$refs.myQuillEditor.quill
  // 如果上传成功
  if (res.code == 200 ) {
   // 获取光标所在位置
   let length = quill.getSelection().index;
   // 插入图片 res.url为服务器返回的图片地址
   quill.insertEmbed(length, 'image', res.url)
   // 调整光标到最后
   quill.setSelection(length + 1)
  } else {
   this.$message.error('图片插入失败')
  }
  // loading动画消失
  this.quillUpdateImg = false
  },
  // 富文本图片上传失败
  uploadError() {
  // loading动画消失
  this.quillUpdateImg = false
  this.$message.error('图片插入失败')
  }
 }
 }
</script>
<style>
 .ql-editor.ql-blank, .ql-editor {
 height: 350px;
 }
</style>
