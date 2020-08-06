<template>
    <div>
        <el-row :gutter="20">
        <el-col :span="3"><div class="grid-content bg-purple">.</div></el-col>
        <el-col :span="18">
         <div class="maildiv">
              <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
                <el-form-item label="To" prop="to">
                    <el-input v-model="ruleForm.to"></el-input>
                    
                </el-form-item>

                <el-form-item label="Subject" prop="subject">
                    <el-input v-model="ruleForm.subject"></el-input>
                </el-form-item>

                <el-form-item label="Message" prop="message">
                      <ejs-richtexteditor ref="rteObj" v-model="ruleForm.message" :height="380" :toolbarSettings="toolbarSettings">
                      <p><b>Key features:</b></p>
                      </ejs-richtexteditor>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">Sent</el-button>
                    
                </el-form-item>
                </el-form>
         </div>
        </el-col>
        <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
        </el-row>
    </div>
</template>

<script>
import {mapActions,mapGetters} from "vuex"
import Vue from "vue";
import { RichTextEditorPlugin, Toolbar, HtmlEditor } from "@syncfusion/ej2-vue-richtexteditor";

Vue.use(RichTextEditorPlugin);
export default {
    data() {
      return {
        ruleForm: {
          to: '',
          subject: '',
          message: '',
          getdata: ''
        },
        rules: {
          to: [
            { required: true, message: 'Please input Email', trigger: 'blur' },
            { type: 'email', message: 'Please input correct email address', trigger: ['blur', 'change'] }
            
          ],
          subject: [
            { required: true, message: 'Please input Subject', trigger: 'blur' },
             { min: 5,  message: 'Length should be min 3 ', trigger: 'blur' }
          ]
                    
        },
        toolbarSettings: {
            type: 'MultiRow',
            items: ['Bold', 'Italic', 'Underline', 'StrikeThrough',
            'FontName', 'FontSize', 'FontColor', 'BackgroundColor',
            'LowerCase', 'UpperCase', '|',
            'Formats', 'Alignments', 'OrderedList', 'UnorderedList',
            'Outdent', 'Indent', '|',
            'CreateLink', 'Image', '|', 'ClearFormat', 'Print',
            'SourceCode', 'FullScreen', '|', 'Undo', 'Redo'
          ]
        },

      };
    },
        provide:{
        richtexteditor:[Toolbar, HtmlEditor]
    },
    

    computed: mapGetters(["mailSended"]),
    methods: {
        ...mapActions(["Compose_Send"]),  
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
            const d = new Date();
          if (valid) {
            this.Compose_Send({
            "sender": sessionStorage.getItem("Email"),
            "receiver": this.ruleForm.to,
            "subject": this.ruleForm.subject,
            "message": this.ruleForm.message,
            "date": d.getDate()+'/'+(d.getMonth()+1)+'/'+d.getFullYear()
             
            }).then(data =>{
                console.log(this.mailSended.id);
                this.$refs[formName].resetFields();
                if(!this.mailSended.id)
                {
                
                this.$message({
                    message: 'E-Mail send failed',
                    type: 'primary',
                    
                });
                }
                else{
                console.log("good boy");
                this.$message({
                    message: 'E-Mail has Sended',
                    type: 'success',
                    
                });
                }
                console.log(data);
            });




          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
}
</script>


<style scoped>
@import "../../node_modules/@syncfusion/ej2-base/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-inputs/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-lists/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-popups/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-buttons/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-navigations/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-splitbuttons/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-vue-richtexteditor/styles/material.css";

  .e-richtexteditor {
    padding-right: 60px;

}
  .maildiv{
      background-color: #A9B8C0;
      padding-top: 2%;
      margin-top: 2%;
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