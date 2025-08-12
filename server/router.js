const express = require("express");
const router = express.Router();
const sqlClient = require("./config")

/**
 * 注册
 */ 

router.post("/register",(req,res) => {
    const{username,password,email} = req.body;
    const sql = "insert into user values(null,?,?,?)";
   
    sqlClient(sql,arr,result =>{
        console.log(result);
        if(result.affectdRows >0 ){
            res.send({
                status:200,
                result
            })
        }else {
            res.send({
                status:401,
                msg:'注册失败'
            })
        }
    })
    
})
module.exports = router;