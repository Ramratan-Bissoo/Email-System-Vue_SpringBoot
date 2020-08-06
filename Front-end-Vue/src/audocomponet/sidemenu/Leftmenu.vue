<template>
  <div>
    <el-col :span="24">
        <div class="logo-container">
         <img class="logo-img" src="../../assets/audilogo.png" />
        </div>
     </el-col>
    <el-col :span="24">
     <h2 class="logo-title">Email</h2>
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#A9B8C0"
      
      text-color="black"
      active-text-color="#A8071A">

     <el-menu-item index="1">
         <i class="el-icon-user"></i>
        <router-link to="/profile">Profile</router-link>
      </el-menu-item>

      <el-menu-item index="2">
         <i class="el-icon-chat-line-round"></i>
         <router-link to="/compose">Compose</router-link>
      </el-menu-item>

      <el-menu-item index="3">
          <i class="el-icon-message"></i>
        <router-link to="/inbox">inbox</router-link>
      </el-menu-item>
      
      <el-menu-item index="4">
         <i class="el-icon-postcard"></i>
         <router-link to="/sent">Sent</router-link>
      </el-menu-item>
      
      
      
      
     </el-menu>
     </el-col>
    </div>
</template>

<script>
export default {
      methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  
}
</script>

<style scoped>
.logo-container{
   margin-top: 2px;
   margin-left: 5px;
   margin-bottom: -30px;
}
.logo-img{
    width: 100%;
    
}
.logo-title{
   text-align: center;
}
.el-menu
{
    border: 0px;
}

</style>