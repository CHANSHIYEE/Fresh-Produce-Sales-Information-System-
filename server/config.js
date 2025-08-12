const { Result } = require("element-ui");
const mysql = require("mysql");

const client = mysql.createConnection({
    host : "localhost",
    user : "root",
    password : "Shiyee0000",
    database : "lgdatabase"
})

const sqlClient = (sql,arr,callback) =>{
    client.query(sql,arr,(error,result) => {
        if(error){
            console.log(error);
            return;
        }
        callback(result)
    })

}
module.export = sqlClient