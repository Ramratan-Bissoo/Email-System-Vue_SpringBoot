<template>
    <div class="maildiv">
        <el-row>
        <el-col :span="2"><div class="grid-content bg-purple">.</div></el-col>
        <el-col :span="20">
          <el-row style="text-align: center">
              <h1 style="font-size: 3vh;">Email ID </h1>
              <h2 style="font-size: 4vh; padding-bottom:5vh">{{ruleForm.email}}</h2>
              <div>
               <el-col :span="24">
                   
                      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
                          <el-form-item label="Fullname" prop="name">
                            <el-input v-model="ruleForm.name" required ></el-input>
                          </el-form-item>
                          <el-form-item label="Password" prop="pass">
                            <el-input v-model="ruleForm.pass"></el-input>
                          </el-form-item>
                          <el-form-item>
                            <el-button type="primary" @click="profileChange('ruleForm')">Update</el-button>
                          </el-form-item>
                       </el-form>
                   
               </el-col>
              </div> 
              
          </el-row>

        </el-col>
        <el-col :span="2"><div class="grid-content bg-purple"></div></el-col>
        </el-row>
    </div>
</template>

<script>
import {mapActions,mapGetters} from "vuex"
export default {
    data() {
      return {
        ruleForm: {
          name: '',
          pass: '',
          email: ''
          
        },
        temp:""
        ,
        rules: {
          name: [
            { required: true, message: 'Please input Email', trigger: 'blur' },
            
            
          ],
          pass: [
            { required: true, message: 'Please input Subject', trigger: 'blur' },
             { min: 5,  message: 'Length should be min 3 ', trigger: 'blur' }
          ]
                    
        }
      };
    },
    created(){
        this.getAccoutDetail()
    },

    computed: mapGetters(["fullProfile"]),
    methods: {
        ...mapActions(["Get_Profile","Set_Profile"]),  

      profileChange(formName) {
          
        this.$refs[formName].validate((valid) => {
           if(valid){
              
              this.Set_Profile({
                  "id":this.fullProfile[0].id,
                   "fullName": this.ruleForm.name,
                   "password": this.ruleForm.pass
              }).then(d=>{
                  this.temp = d;
                  this.$message({
                    message: 'Profile has Updated',
                    type: 'success',
                    
                });
                sessionStorage.removeItem("Email");
                this.$router.push('/login');
              }) 
           }
        })
      },
      

      getAccoutDetail()
      {
          this.Get_Profile(sessionStorage.getItem("Email")             
            ).then(d=>{
              this.ruleForm = {
                name: this.fullProfile[0].fullName,
               pass: this.fullProfile[0].password,
               email: this.fullProfile[0].emailId

          
             }
             this.temp = d;
            });

      }
    }
}
</script>

<style>
  .maildiv{
      background-color: #A9B8C0;
      padding-top: 3%;
      margin-top: 5%;
      padding-bottom: 1%;
  }
  .el-form-item__label{
      width: 10vh !important;
  }
  .el-form-item__content{
      margin-left: 80px !important;
  }
  .el-input__inner{
      width: 90% !important;
  }
  .el-textarea .el-textarea__inner{
      height: 35vh;
      margin-top: 0px;
      margin-bottom: 0px;
      resize: none;
      width: 90%;
  }
</style>