<template>
  <div>
   <el-row>
     <el-col :span="16" :lg="12" :md="12" :sm="24" :xs="24"><div class="grid-content"><h2>Hii, {{User}}</h2></div></el-col>
     <el-col :span="8" :lg="12" :md="12" :sm="24" :xs="24">
         <div class="grid-content" style="float: right;">
             <el-button type="text" @click="logout"> <i class="el-icon-lock" style="font-size:20px;"></i>LogOut</el-button>
            
                             
            
         </div>
    </el-col>
   </el-row>
  </div>    
</template>

<script>
export default {
    data(){
        return{
           User: sessionStorage.getItem("FullName")
        }
    },
    methods:{
        logout(){
     sessionStorage.removeItem("Email");
     this.$router.push('/login');
     }
    }
}
</script>

<style scoped>
   
    button.el-button--text{
    color:black!important;
    } 
 .el-dropdown-link{
     padding-left: 20px;
 }
 .avatar_img{
     border-radius: 50%;
    margin-top: 15px;
    margin-right: 15px;
     width:30px; 
     height:30px
 } 
  
  
</style>