<template>
    <div>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>MARKET</span>
            </div>
                <el-tabs v-model="currentIndex" stretch type="border-card" @tabclick="handleTabsClick">
                    <el-tab-pane label="登录" name="login" >
                        <el-form :model="loginForm" :rules="rules" status-icon ref="loginForm">
                            <el-form-item label="用户名" prop="username">
                                <el-input type="text" v-model="loginForm.username" />
                            </el-form-item>
                            <el-form-item label="用户密码" prop="password">
                                <el-input type="password" v-model="loginForm.password" />
                            </el-form-item>
                            <el-form-item >
                                <el-button type="primary" @click="submitForm('loginForm')">  提交 </el-button>
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                    <el-tab-pane label="注册" name="register">
                        <el-form :model="registerForm" :rules="rules" status-icon ref="registerForm">
                            <el-form-item label="用户名" prop="username">
                                <el-input type="text" v-model="registerForm.username" />
                            </el-form-item>
                            <el-form-item label="用户密码" prop="password">
                                <el-input type="password" v-model="registerForm.password" />
                            </el-form-item>
                            <el-form-item label="确认密码" prop="configurepassword">
                                <el-input type="password" v-model="registerForm.configurepassword" />
                            </el-form-item>
                            <el-form-item >
                                <el-button type="primary" @click="submitForm('registerForm')">  提交 </el-button>
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                </el-tabs>
        </el-card>
    </div>
</template>
  


<script>
import request from '@/utils/request';
export default {
    data(){
        //验证规则
        var validateUserName = (rule,value,callback )=>{
            if (value === " "){
                callback(new Error ("请输入用户名"))
            }
            else if (value.length < 6 ){
                callback(new Error ("长度不足6位"))
            }
            else{
                callback();
            }
        };
        var validatePassWord = (rule,value,callback )=>{
            if (value === " "){
                callback(new Error ("请输入密码"))
            }
            else if (value.length < 4 ){
                callback(new Error ("长度不足4位"))
            }
            else{
                callback();
            }
        };
        var validateConfigurePassWord = (rule,value,callback )=>{
            if (value === ""){
                callback(new Error ("请再次输入密码"))
            }
            else if (value !== this.registerForm.password){
                callback(new Error ("两次输入的密码不一致"))
            }
            else{
                callback();
            }
        };
        return{
            user:{
                    currentIndex:"login",
                                loginForm:{
                                    username:"",
                                    password:""
                                },
                                registerForm:{
                                    username:"",
                                    password:"",
                                    configurepassword:""
                                },
                                activeTab:"login",
                                rules:{
                                    username:[
                                        {
                                            validator:validateUserName,trigger:"blur"
                                        }
                                    ],
                                    password:[
                                        {
                                            validator:validatePassWord,trigger:"blur"
                                        }
                                    ],
                                    configurepassword:[
                                        {
                                            validator:validateConfigurePassWord,trigger:"blur"
                                        }
                                    ],
                                }
            }
            
        }
    },
    methods:{
        submitForm(formName){
            this.$refs[formName].validate((valid)=>{
                if (valid){
                    if(this.activeTab === "login")
                    {
                        //登录
                        console.log(this.loginForm);
                        request.post(URL="/user/login",this.username).then(response => {
                            if(response.code ==='0'){
                                this.$message({
                                    message:'登录成功',
                                    type:'success'
                                });
                                this.$router.push("/");
                            }else{
                                this.$message({
                                    message:response.message,
                                    type:'error'
                                });
                            }
                        }
            )}
                    if(this.act ==="register")
                    {
                        //注册
                        console.log(this.registerForm);
                        request.get(URL="ser/register").then(response => {
                            console.log("success");
                        })
                    }
                }else{
                    return;
                }
            });

        },
        handleTabsClick(tab){
            console.log(tab.name);
            this.activeTab = tab.name;
        }
    }
}
</script>



