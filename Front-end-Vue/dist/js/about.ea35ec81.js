(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["about"],{"29d7":function(t,e,o){t.exports=o.p+"img/loginBackground.1c5d499d.jpg"},"731b":function(t,e,o){},aef3:function(t,e,o){"use strict";o.r(e);var s=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",[o("div",{staticClass:"cotn_principal"},[o("div",{staticClass:"cont_centrar"},[o("div",{staticClass:"cont_login"},[o("div",{staticClass:"cont_info_log_sign_up"},[o("div",{staticClass:"col_md_login"},[o("div",{staticClass:"cont_ba_opcitiy"},[o("h2",[t._v("LOGIN")]),o("p",[t._v("welcome to ATCS Login ")]),o("button",{staticClass:"btn_login",on:{click:function(e){return t.cambiar_login()}}},[t._v("LOGIN")])])]),o("div",{staticClass:"col_md_sign_up"},[o("div",{staticClass:"cont_ba_opcitiy"},[o("h2",[t._v("SIGN UP")]),o("p",[t._v("welcome to ATCS Sign Up")]),o("button",{staticClass:"btn_sign_up",on:{click:function(e){return t.cambiar_sign_up()}}},[t._v("SIGN UP")])])])]),t._m(0),o("div",{staticClass:"cont_forms"},[t._m(1),o("form",{staticClass:"cont_form_login",on:{submit:function(e){return e.preventDefault(),t.onLogin(e)}}},[o("h2",[t._v("LOGIN")]),o("input",{directives:[{name:"model",rawName:"v-model",value:t.log_Email,expression:"log_Email"}],attrs:{type:"email",placeholder:"Email",required:""},domProps:{value:t.log_Email},on:{input:function(e){e.target.composing||(t.log_Email=e.target.value)}}}),o("input",{directives:[{name:"model",rawName:"v-model",value:t.log_Pass,expression:"log_Pass"}],attrs:{type:"password",placeholder:"Password",required:""},domProps:{value:t.log_Pass},on:{input:function(e){e.target.composing||(t.log_Pass=e.target.value)}}}),o("button",{staticClass:"btn_login"},[t._v("LOGIN")])]),o("form",{staticClass:"cont_form_sign_up",on:{submit:function(e){return e.preventDefault(),t.onSignUp(e)}}},[o("h2",[t._v("SIGN UP")]),o("input",{directives:[{name:"model",rawName:"v-model",value:t.S_up_Email,expression:"S_up_Email"}],attrs:{type:"text",placeholder:"Email without @atcs.com ",required:""},domProps:{value:t.S_up_Email},on:{input:function(e){e.target.composing||(t.S_up_Email=e.target.value)}}}),o("input",{directives:[{name:"model",rawName:"v-model",value:t.Fullname,expression:"Fullname"}],attrs:{type:"text",placeholder:"Full Name",required:""},domProps:{value:t.Fullname},on:{input:function(e){e.target.composing||(t.Fullname=e.target.value)}}}),o("input",{directives:[{name:"model",rawName:"v-model",value:t.S_up_Pass,expression:"S_up_Pass"}],attrs:{type:"password",placeholder:"Password"},domProps:{value:t.S_up_Pass},on:{input:function(e){e.target.composing||(t.S_up_Pass=e.target.value)}}}),o("button",{staticClass:"btn_sign_up"},[t._v("SIGN UP")])])])])])])])},n=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"cont_back_info"},[s("div",{staticClass:"cont_img_back_grey"},[s("img",{attrs:{src:o("29d7"),alt:""}})])])},function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"cont_img_back_"},[s("img",{attrs:{src:o("29d7"),alt:""}})])}],a=o("5530"),i=o("2f62"),c={data:function(){return{S_up_Email:"",Fullname:"",S_up_Pass:"",log_Email:"",log_Pass:"",temp:""}},computed:Object(i["c"])(["loginData"]),methods:Object(a["a"])(Object(a["a"])({cambiar_login:function(){document.querySelector(".cont_forms").className="cont_forms cont_forms_active_login",document.querySelector(".cont_form_login").style.display="block",document.querySelector(".cont_form_sign_up").style.opacity="0",setTimeout((function(){document.querySelector(".cont_form_login").style.opacity="1"}),400),setTimeout((function(){document.querySelector(".cont_form_sign_up").style.display="none"}),200)},cambiar_sign_up:function(){document.querySelector(".cont_forms").className="cont_forms cont_forms_active_sign_up",document.querySelector(".cont_form_sign_up").style.display="block",document.querySelector(".cont_form_login").style.opacity="0",setTimeout((function(){document.querySelector(".cont_form_sign_up").style.opacity="1"}),100),setTimeout((function(){document.querySelector(".cont_form_login").style.display="none"}),400)},ocultar_login_sign_up:function(){document.querySelector(".cont_forms").className="cont_forms",document.querySelector(".cont_form_sign_up").style.opacity="0",document.querySelector(".cont_form_login").style.opacity="0",setTimeout((function(){document.querySelector(".cont_form_sign_up").style.display="none",document.querySelector(".cont_form_login").style.display="none"}),500)}},Object(i["b"])(["Sign_Up","Sign_In"])),{},{onSignUp:function(){var t=this;this.Sign_Up({fullName:this.Fullname,emailId:this.S_up_Email+"@atcs.com",password:this.S_up_Pass}).then((function(e){t.Sign_In({emailId:t.S_up_Email+"@atcs.com",password:t.S_up_Pass}).then((function(e){sessionStorage.setItem("Email",t.S_up_Email+"@atcs.com"),sessionStorage.setItem("FullName",t.loginData[0]["fullName"]),t.$message({message:"Welcome buddy",type:"success"}),t.temp=e,t.$router.push("/compose")})),t.temp=e})).catch((function(e){t.$message({message:"This "+t.S_up_Email+" already exists",type:"primary"}),t.S_up_Email="",t.temp=e}))},onLogin:function(){var t=this;this.Sign_In({emailId:this.log_Email,password:this.log_Pass}).then((function(e){t.loginData.length?(sessionStorage.setItem("Email",t.log_Email),sessionStorage.setItem("FullName",t.loginData[0]["fullName"]),t.$message({message:"Welcome buddy",type:"primary"}),t.$router.push("/compose")):t.$message({message:"Please check username password",type:"primary"}),t.temp=e}))}})},l=c,r=(o("c9e1"),o("2877")),u=Object(r["a"])(l,s,n,!1,null,"2e4ecbac",null);e["default"]=u.exports},c9e1:function(t,e,o){"use strict";var s=o("731b"),n=o.n(s);n.a}}]);
//# sourceMappingURL=about.ea35ec81.js.map