/**
 * sagas/user.js
 * ---------------------------
 * 사용자 관련 비동기 작업을 처리하는 saga
 * - 로그인, 로그아웃, 회원가입, 사용자 조회,닉네임 수정,사용자 삭제
 * - axios로 API를 호출 → 성공/실패에 따라 reducer로 액션 전달
 */
import {all,fork,call,put,takeLatest} from 'redux-saga/effects' // saga 기본 함수
import axios from 'axios';
import reducer, {
    initialState,
    LOG_IN_REQUEST,LOG_IN_SUCCESS,LOG_IN_FAILURE,
    LOG_OUT_REQUEST,LOG_OUT_SUCCESS,LOG_OUT_FAILURE,
    SIGN_UP_REQUEST,SIGN_UP_SUCCESS,SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST,LOAD_USERS_SUCCESS,LOAD_USERS_FAILURE,
    UPDATE_NICKNAME_REQUEST,UPDATE_NICKNAME_SUCCESS,UPDATE_NICKNAME_FAILURE,
    DELETE_USERS_REQUEST,DELETE_USERS_SUCCESS,DELETE_USERS_FAILURE,
    FIND_NICKNAME_REQUEST,FIND_NICKNAME_SUCCESS,FIND_NICKNAME_FAILURE,
    FIND_EMAIL_REQUEST,FIND_EMAIL_SUCCESS,FIND_EMAIL_FAILURE
} from '../reducers/user'; //액션 타입 불러오기
// import { findUserByNickname } from '../../back/models/users';

const client = axios.create({
    baseURL:'http://localhost:3065', // API 서버 주소
    withCredentials:true, // 쿠키/세션 인증포함
});

// --------- 로그아웃 ---------watchLogout
// post: /user/logout
export function logoutApi(data){
    return client.post( '/user/logout', data );  // http://localhost:3065/user/logout
}
export function* logout(action){
    try{
        yield call( logoutApi );  // API 호출 action.data: email, password
        yield put( {type:LOG_OUT_SUCCESS} );  // 성공 액션 dispatch
        //  return { ...state, isLoading: false, signUpDone: true };
    }catch(err){
        yield put( {type:LOG_OUT_FAILURE, error: err.response?.data || err.message} );
        // return { ...state, isLoading: false, error:action.error?.message || action.error };

    }
}
function* watchLogout(){
    yield takeLatest( LOG_OUT_REQUEST, logout );
    // LOG_OUT_REQUEST 액션발생 -> 여러번 요청시 가장 마지막 요청처리 1개
    // return { ...state, isLoading: true, error: null }
}
// --------- 로그인 ---------watchLogin
// postL /user/login
export function loginApi(data){
    return client.post('/user/login',data); // http://localhost:3065
}
export function* login(action){
    try{
        const result = yield call(loginApi,action.data); //api 호출, action.data:email,password
        const user = {id:result.data.APP_USER_ID,
                      email:result.data.EMAIL,
                      nickname:result.data.NICKNAME
        }
        yield put({type:LOG_IN_SUCCESS,data:user}); //성공 액션 dispatch
    }catch(err){
        yield put({type:LOG_IN_FAILURE,error:err.response?.data || err.message});//실패 액션 dispatch
    }
}
function*watchLogin(){
    yield takeLatest(LOG_IN_REQUEST,login);
}
// --------- 회원가입 ---------watchSignUp
// post : /user/register (requestBody)
export function signUpApi(data){
    return client.post('/user/register',data); // http://localhost:3065
}
export function* signUp(action){
    try{
        yield call(signUpApi,action.data); //api 호출, 결과물
        yield put({type:SIGN_UP_SUCCESS}); //성공 액션 dispatch
    }catch(err){
        yield put({type:SIGN_UP_FAILURE,error:err.response?.data || err.message});//실패 액션 dispatch
    }
}
function* watchSignUp(){
    yield takeLatest(SIGN_UP_REQUEST,signUp); 
    // SIGN_UP_REQUEST 액션발생 → 여러번요청시 가장 마지막 요청처리 1개
}
// --------- 사용자 조회 ---------watchLoadUsers
//get:/user/
export function loadUsersApi(){
    return client.get('/user'); // http://localhost:3065
}
export function* loadUsers(){
    try{
        const result = yield call(loadUsersApi); //api 호출, action.data:email,password
        const user = result.data.map((u)=>({
                      id:u.APP_USER_ID,
                      email:u.EMAIL,
                      nickname:u.NICKNAME
        }));
        
        yield put({type:LOAD_USERS_SUCCESS,data:user}); //성공 액션 dispatch
    }catch(err){
        yield put({type:LOAD_USERS_FAILURE,error:err.response?.data || err.message});//실패 액션 dispatch
    }
}
function*watchLoadUsers(){
    yield takeLatest(LOAD_USERS_REQUEST,loadUsers);
}
// --------- 닉네임 수정 ---------watchUpdateNickname
export function updateNicknameApi(data){
    return client.patch(`/user/${data.id}/nickname`,{nickname:data.nickname}); // http://localhost:3065
}
export function* updateNickname(action){
    try{
      yield call(updateNicknameApi,action.data); //api 호출, action.data:email,password
      yield put({type:UPDATE_NICKNAME_SUCCESS,data:{id:action.data.id,nickname:action.data.nickname}});
    }catch(err){
        yield put({type:UPDATE_NICKNAME_FAILURE,error:err.response?.data || err.message});//실패 액션 dispatch
    }
}
function*watchUpdateNickname(){
    yield takeLatest(UPDATE_NICKNAME_REQUEST,updateNickname);
}
// --------- 사용자 삭제 ---------watchDeleteUser
//delete:/user/{id}
export function deleteUserApi(id){
    return client.delete(`/user/${id}`); // http://localhost:3065
}
export function* deleteUser(action){
    try{
      yield call(deleteUserApi,action.data.id); //api 호출, action.data:email,password
      yield put({type:DELETE_USERS_SUCCESS,data:{id:action.data.id}});
    }catch(err){
        yield put({type:DELETE_USERS_FAILURE,error:err.response?.data || err.message});//실패 액션 dispatch
    }
}
function*watchDeleteUser(){
    yield takeLatest(DELETE_USERS_REQUEST,deleteUser);
}

//-- 닉네임 중복 검사 --watchFindNickname
// /user/checkNickname/{nickname}:
export function findUserByNicknameApi(nickname){
    return client.post(`/user/checkNickname?nickname=${nickname}`);
}
export function* findUserByNickname(action){
    try{
        const result = yield call(findUserByNicknameApi,action.data.nickname);
        yield put({type:FIND_NICKNAME_SUCCESS,data:result.data});
    }catch(err){
        yield put({type:FIND_NICKNAME_FAILURE,error:err.response?.data || err.message});
    }
}
function*watchFindNickname(){
    yield takeLatest(FIND_NICKNAME_REQUEST,findUserByNickname);
}

//--이메일 중복 검사 --watchFindEmail
export function findUserByEmailApi(email){
    return client.post(`/user/checkEmail?email=${email}`);
}
export function* findUserByEmail(action){
    try{
        const result = yield call(findUserByEmailApi,action.data.email);
        yield put({type:FIND_EMAIL_SUCCESS,data:result.data});
    }catch(err){
        yield put({type:FIND_EMAIL_FAILURE,error:err.response?.data || err.message});
    }
}
function*watchFindEmail(){
    yield takeLatest(FIND_EMAIL_REQUEST,findUserByEmail);
}

export default function* userSaga(){
    yield all([
        fork(watchLogin),
        fork(watchLogout),
        fork(watchSignUp),
        fork(watchLoadUsers),
        fork(watchUpdateNickname),
        fork(watchDeleteUser),
        fork(watchFindNickname),
        fork(watchFindEmail)
    ]);
}