//1. require
const dbConfig = require('../config/db'); // user,password,connectString
const oracledb = require('oracledb');
const bcrypt   = require('bcrypt');

// oracle 초기화
oracledb.initOracleClient();
const options = {outFormat:oracledb.OUT_FORMAT_OBJECT,autoCommit:true};

//2. 각기능 sql
// 1. create - insert
// ### 1. 사용자 등록 (Create - Insert)
// INSERT INTO appuser (
//     APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE,    CREATED_AT
// ) VALUES (
//     APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile,    SYSDATE
// )
async function createUser(email,password,nickname,mobile,mbtiTypeId,ufile) {
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const hashedPassword=await bcrypt.hash(password,10);
        const result = await conn.execute(`
            INSERT INTO appuser (
            APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE,    CREATED_AT
            ) VALUES (
             APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile,    SYSDATE
            )`,{email,password:hashedPassword,nickname,mobile,mbtiTypeId,ufile},options); // sql, 사용자입력값, 옵션
    }catch(err){
        console.log('createUser Error',err);
        throw err;
    }finally{
        if(conn)await conn.close();
    }
    
}
// 2. 사용자조회 - EMAIL
// ### 2. 사용자 조회 (Email 기준)
// 이메일을 사용해 특정 사용자의 상세 정보를 조회합니다.
// SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// WHERE EMAIL = :email
async function findUserEmail(email) {
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
            FROM appuser 
            WHERE EMAIL = :email`
            ,{email}
            ,options); //실행
            return result.rows[0]; //결과처리
    }catch(err){
        console.log(  'findUserEmail Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    }
}
// 3. 사용자조회 - APP_USER_ID
// ### 3. 사용자 조회 (ID 기준)
// 기본 키(PK)인 `APP_USER_ID`를 사용해 특정 사용자의 상세 정보를 조회합니다.
// SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// WHERE APP_USER_ID = :id
async function findUserById(id) {
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
            FROM appuser 
            WHERE APP_USER_ID = :id`,{id},options);
            return result.rows[0];
    }catch(err){
        console.log(  'findUserById Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    }
}
// 4. 로그인 - sql 빼기 pass / 로그아웃
async function verifyUser(email,password) {

    const user = await findUserById(email);
    if(!user) return null;

    const match = await bcrypt.compare(password,user.PASSWORD);
    if(!user) return null;
    
    return{
        id:user.APP_USER_ID,
        email:uesr.email,
        nickname:user.NICKNAME
    }
}
// 5. 전체조회
// ### 5. 전체 사용자 조회 (Read All)
// 가입일 역순(최신 가입자 우선)으로 전체 사용자를 조회합니다.
// SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
// FROM appuser 
// ORDER BY CREATED_AT DESC
async function getAllUsers() {
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
            FROM appuser 
            ORDER BY CREATED_AT DESC`,{},options);
            return result.rows;
    }catch(err){
        console.log(  'getAllusers Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    }
}
// 6. 닉네임 수정
// ### 6. 닉네임 수정 (Update Nickname)
// 사용자 ID를 기준으로 등록된 닉네임을 변경합니다.
// UPDATE appuser 
// SET NICKNAME = :nickname 
// WHERE APP_USER_ID = :id
async function updateUserNickname(nickname,id) {
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `UPDATE appuser 
            SET NICKNAME = :nickname 
            WHERE APP_USER_ID = :id`,{nickname,id},options);
    }catch(err){
        console.log(  'updateUserNickname Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    } 
}
// 7. 사용자 삭제
// ### 7. 사용자 삭제 (Delete)
// 사용자 ID를 기준으로 계정을 삭제(탈퇴 처리)합니다.
// DELETE FROM appuser 
// WHERE APP_USER_ID = :id
async function deleteUser(id) {
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `DELETE FROM appuser 
            WHERE APP_USER_ID = :id`,{id},options);
    }catch(err){
        console.log(  'deleteUser Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    }
    
}
// 8. 사용자조회 - NICKNAME
// ### 8. 닉네임 조회
// 특정 닉네임을 가진 사용자가 있는지 조회합니다. (주로 회원가입 시 **닉네임 중복 체크** 용도로 사용됩니다.)
// SELECT APP_USER_ID, EMAIL, NICKNAME 
// FROM appuser 
// WHERE NICKNAME = :nickname
async function findUserByNickname(nickname) {
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `SELECT APP_USER_ID, EMAIL, NICKNAME 
            FROM appuser 
            WHERE NICKNAME = :nickname`,{nickname},options);
            return result.rows[0]; 
    }catch(err){
        console.log(  'findUserByNickname Error' , err);
        throw err;
    }finally{
        if(conn) await  conn.close();
    }
}

// export
module.exports={createUser,findUserEmail,findUserById,verifyUser,
                getAllUsers,updateUserNickname,deleteUser,findUserByNickname};
