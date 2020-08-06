<template>
 <div>
  <el-container class="background_main">
    <el-aside><Leftmenu/></el-aside>
        <el-container>
        <el-header class="Top_First_header" style="height:auto"><TopFirstHeader/></el-header>
         
        <el-main class="Main_component"> <router-view></router-view></el-main>
        
    </el-container>
  </el-container>
  </div>
</template>

<script>
import Leftmenu from '@/audocomponet/sidemenu/Leftmenu.vue'
import TopFirstHeader from '@/audocomponet/topheader/TopFirstHeader.vue'


export default {
    name: 'Maincom',
    components:{
        Leftmenu,
        TopFirstHeader,
       
       
    }

}
</script>

<style scoped>
.el-aside{
    background-color:#A9B8C0;
    min-height: 100vh;
    color: black;
    max-width: 250px;
    padding-left: 5px;
}
.background_main{
    background-color: gray;
}
 .Top_First_header{
     background-color: whitesmoke;
    
    border-bottom: 2px solid black;
 }
 .Top_Second_header{
     background-color: white;
     
 }
  .Main_component{
     background-image: url("../assets/loginBackground.jpg");
       background-color: #cccccc;
  
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
  
  }
  .el-main{
     padding: 10px;
  } 
  el-header{
      padding: 0;
  }
</style>