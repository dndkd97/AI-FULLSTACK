//npx jest reducers/user.test.js
import reducer, {
    initialState,
    LOG_IN_REQUEST,LOG_IN_SUCCESS,LOG_IN_FAILURE,
    LOG_OUT_REQUEST,LOG_OUT_SUCCESS,LOG_OUT_FAILURE,
    SIGN_UP_REQUEST,SIGN_UP_SUCCESS,SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST,LOAD_USERS_SUCCESS,LOAD_USERS_FAILURE,
    UPDATE_NICKNAME_REQUEST,UPDATE_NICKNAME_SUCCESS,UPDATE_NICKNAME_FAILURE,
    DELETE_USERS_REQUEST,DELETE_USERS_SUCCESS,DELETE_USERS_FAILURE
} from './user';

describe('user reducer',()=>{

    it('LOG_IN_REQUEST',()=>{ //return {...state,isLoading:true,error:null};
        const state = reducer(initialState,{type:LOG_IN_REQUEST});
        expect(state.isLoading).toBe(true);
    });
    it('LOG_IN_SUCCESS',()=>{ //return{...state,isLoading:false,me:action.data};
        const fakeUser = {id:1,email:'1@1',nickname:'first'};
        const state = reducer(initialState,{type:LOG_IN_SUCCESS,data:fakeUser});
        expect(state.me).toBe(fakeUser);
    });
    it('LOG_IN_FAILURE',()=>{//return{...state,isLoading:false,error:action.error?.message||action.error};
        const state = reducer(initialState,{type:LOG_IN_FAILURE,error:'로그인 실패'});
        expect(state.error).toBe('로그인 실패');
        expect(state.isLoading).toBe(false);
    });
    //////////////////////////////////////
    it('LOG_OUT_REQUEST',()=>{//return {...state,isLoading:true,error:null};
    const state = reducer(initialState,{type:LOG_OUT_REQUEST});
    expect(state.isLoading).toBe(true);
    });
    it('LOG_OUT_SUCCESS',()=>{//return{...state,isLoading:false,me:null};
    const state = reducer(initialState,{type:LOG_OUT_SUCCESS});
    expect(state.isLoading).toBe(false);
    expect(state.me).toBeNull();
    });
    it('LOG_OUT_FAILURE',()=>{//return{...state,isLoading:false,error:action.error?.message||action.error};
    const state = reducer(initialState,{type:LOG_OUT_FAILURE,error:'로그아웃 실패'});
    expect(state.error).toBe('로그아웃 실패');
    expect(state.isLoading).toBe(false);
    });
    //////////////////////////////////////
    it('SIGN_UP_REQUEST',()=>{//return {...state,isLoading:true,error:null};
    const state = reducer(initialState,{type:SIGN_UP_REQUEST});
    expect(state.isLoading).toBe(true);
    });
    it('SIGN_UP_SUCCESS',()=>{// return{...state,isLoading:false,signUpDone:true};
    const state = reducer(initialState,{type:SIGN_UP_SUCCESS});
    expect(state.isLoading).toBe(false);
    expect(state.signUpDone).toBe(true);
    });
    it('SIGN_UP_FAILURE',()=>{//return{...state,isLoading:false,error:action.error?.message||action.error};
    const state = reducer(initialState,{type:SIGN_UP_FAILURE,error:'회원가입 실패'});
    expect(state.error).toBe('회원가입 실패');
    expect(state.isLoading).toBe(false);
    });
    //////////////////////////////////////
    it('LOAD_USERS_SUCCESS',()=>{//return{...state,isLoading:false,users:action.data};
    const fakeUser = {id:1,email:'1@1',nickname:'first'};
    const state = reducer(initialState,{type:LOAD_USERS_SUCCESS,data:fakeUser});
    expect(state.users).toBe(fakeUser);
    });
    //////////////////////////////////////
    it('UPDATE_NICKNAME_SUCCESS',()=>{//return{...state,isLoading:false,me:state.me && state.me.id===action.data.id
                                      //       ?{ ...state.me,nickname:action.data.nickname }
                                      //       :state.me
    const prev = {...initialState,me:{id:1,nickname:'old'},users:[{id:1,nickname:'old'}]};
    const state = reducer(prev,{type:UPDATE_NICKNAME_SUCCESS,data:{id:1,nickname:'new'}});
    expect(state.me.nickname).toBe('new');
    expect(state.users[0].nickname).toBe('new');
    });
    //////////////////////////////////////
    it('DELETE_USERS_SUCCESS',()=>{//return{...state,isLoading:false,me:state.me?.id===action.data.id?null:state.me,
                                   //users:state.users.filter((u)=>u.id!==action.data.id)
    const prev = {...initialState,me:{id:1},users:[{id:1},{id:2}]};
    const state = reducer(prev,{type:DELETE_USERS_SUCCESS,data:{id:1}});
    expect(state.me).toBeNull();
    expect(state.users).toEqual([{id:2}]);
    });

});