<template>
    <div>
     <el-row :gutter="24" v-if="dialogVisible">
      <el-col :xs="24" :sm="21" :md="21" :lg="21" :xl="21">
        <div class="">
          
          <el-table :data="allSentMail" style="width: 100%; background-color:#A9B8C0">
                       
            <el-table-column label="Subject" prop="subject"> </el-table-column>
            <el-table-column label="Receiver" prop="receiver"> </el-table-column>
            <el-table-column label="Date" prop="date"></el-table-column>
            <el-table-column align="right">
            
            <template slot-scope="scope">
                <el-button  size="mini" type="Info" @click="handleView(scope.$index, scope.row)">
                  View
                </el-button>
                <el-button  size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">
                  Delete
                </el-button>
            </template>
            </el-table-column>
        </el-table>


        </div>
      </el-col>
     </el-row>
     <el-row v-if="!dialogVisible">
         <el-row>
             <el-col style="background-color: black;">
               <el-button type="text" @click="inbox"> 
                   <i class="el-icon-back" style="font-size:20px;"></i>
                   Sent</el-button>
             
               <el-button type="text" style=" margin-left: 35%;" @click="mailReply"> 
                   <i class="el-icon-right" style="font-size:20px;"></i>
                   Forword</el-button>
                   <el-button style=" float: right; margin-top: 10px; margin-right: 3vh;" size="mini" type="danger" @click="DeleteMailInView()">
                  Delete
                </el-button>
             </el-col>
         </el-row>
         <el-row style="background-color: aliceblue; height:50vh">
             <el-col :md="24">
               <h2 style="margin-left:5%">{{this.viewdata.subject}}</h2>
               
             </el-col>
             <el-col :md="18">
               <h2 style="margin-left:5%">{{this.viewdata.receiver}}</h2>
               
             </el-col>
             <el-col :md="6">
               <h3 style="float: right; margin-right:5vh">{{this.viewdata.date}}</h3>
              
             </el-col>
             <el-col>
                  <hr style="border: 10px solid #A9B8C0; border-radius: 5px;">
             </el-col>
             <el-col>
              <ejs-richtexteditor ref="rteObj" v-model="viewdata.message" :height="450">
                 <p><b>Key features:</b></p>
              </ejs-richtexteditor>
             </el-col>
         </el-row>
     </el-row>
    <el-dialog title="Reply & Forword" :visible.sync="dialogVisibleReply" width="70%" :before-close="handleClose">
       <div class="popUpReply">
              <el-form :model="replyData" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
                <el-form-item label="To" prop="sender">
                    <el-input v-model="replyData.sender"></el-input>
                    
                </el-form-item>

                <el-form-item label="Subject" prop="subject">
                    <el-input v-model="replyData.subject"></el-input>
                </el-form-item>

                <el-form-item label="Message" prop="message">
                 <div style="padding-right:20px">
                      <ejs-richtexteditor ref="rteObj" v-model="replyData.message" :height="380" :toolbarSettings="toolbarSettings">
                      <p><b>Key features:</b></p>
                      </ejs-richtexteditor>
                 </div>     
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="replyForm('ruleForm')">Sent</el-button>
                    
                </el-form-item>
                </el-form>
         </div>
      
    </el-dialog>
    </div>
</template>

<script>
import Vue from "vue";
import { RichTextEditorPlugin, Toolbar, HtmlEditor } from "@syncfusion/ej2-vue-richtexteditor";

Vue.use(RichTextEditorPlugin);
import { mapGetters, mapActions } from 'vuex';
export default {
  
    computed: mapGetters(["allSentMail","mailSended"]),
    created(){
      this.getMail();
    },
    data(){
        return{
         dialogVisible:true,
         viewdata:[],
         replyData:[],
         garbage:'',dialogVisibleReply: false,
         rules: {
          sender: [
            { required: true, message: 'Please input Email', trigger: 'blur' },
            { type: 'email', message: 'Please input correct email address', trigger: ['blur', 'change'] }
            
          ],
          subject: [
            { required: true, message: 'Please input Subject', trigger: 'blur' },
             { min: 3,  message: 'Length should be min 3 ', trigger: 'blur' }
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
        }
    },
       provide:{
        richtexteditor:[Toolbar, HtmlEditor]
    },
    methods: {
       ...mapActions(["getSentMail","deleteSentMail","Compose_Send"]),

      getMail(){
            const id =sessionStorage.getItem("Email");
            this.getSentMail(id);
      },
      mailReply()
      {
         this.dialogVisibleReply = true;
         this.replyData = this.viewdata;
         
      },
      handleDelete(index, row) {
        this.$confirm('Do you want Delete Mail. Continue?', 'Warning', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
            this.deleteSentMail(row.id).then(data=>{
            this.getMail();
            this.garbage = data;
            this.$message({
              message: 'Mail has Deleted',
              type: 'success',
              
          });
        })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Delete canceled'
          });          
        });
        
      },
      DeleteMailInView(){
          this.$confirm('Do you want Delete Mail. Continue?', 'Warning', {
          confirmButtonText: 'OK',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          this.deleteSentMail(this.viewdata.id).then(data=>{
            this.getMail();
            this.garbage = data;
            this.dialogVisible = !this.dialogVisible
            this.$message({
              message: 'Mail has Deleted',
              type: 'success',
              
          });
        })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Delete canceled'
          });          
        });


      },
      handleView(index, row) {
          
          this.viewdata = row;
          this.dialogVisible = false
        
      },
      inbox(){
          this.dialogVisible = !this.dialogVisible
      },
       replyForm(formName) {
        this.$refs[formName].validate((valid) => {
            const d = new Date();
          if (valid) {
            this.Compose_Send({
            "sender": sessionStorage.getItem("Email"),
            "receiver": this.replyData.sender,
            "subject": this.replyData.subject,
            "message": this.replyData.message,
            "date": d.getDate()+'/'+(d.getMonth()+1)+'/'+d.getFullYear()
             
            }).then(data =>{
                
                this.$refs[formName].resetFields();
                if(!this.mailSended.id)
                {
                
                this.$message({
                    message: 'E-Mail send failed',
                    type: 'primary',
                    
                });
                
                this.$router.push('/sent');
                }
                else{
                console.log("good boy");
                this.$message({
                    message: 'Reply has Sended',
                    type: 'success',
                    
                });
                this.dialogVisibleReply = false;
                this.dialogVisible = !this.dialogVisible
                this.$router.push('/sent');
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

<style>
@import "../../node_modules/@syncfusion/ej2-base/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-inputs/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-lists/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-popups/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-buttons/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-navigations/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-splitbuttons/styles/material.css";
@import "../../node_modules/@syncfusion/ej2-vue-richtexteditor/styles/material.css";
</style>

<style scoped>
.el-main[data-v-fae5bece] {
     padding: 0px !important; 
}
.inbox_back{
    height: 80vh;
    background-color: aliceblue;
}
.popUpReply{
    background-color: #A9B8C0;
    padding-top: 3%;

    padding-bottom: 1%;
}
</style>
