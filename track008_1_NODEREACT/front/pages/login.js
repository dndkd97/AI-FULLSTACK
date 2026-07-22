import{ useSelector,useDispatch }from 'react-redux'; //전역상태 , 상태알림
import { useState,useEffect } from 'react'; // 변수상태변경, 이벤트변경
import { useRouter } from 'next/router'; // 경로
import { LOG_IN_REQUEST } from '../reducers/user';

export default function LoginPage(){
           const dispatch = useDispatch();
           const router = useRouter();
           const {error,me}=useSelector((state)=>state.user);
           const [email,setEmail] = useState('');
           const [password,setPassword] = useState('');
           
           useEffect(()=>{
            if(router.query.logout=='true'){
                alert('로그아웃되었습니다.');
                router.replace('/login',undefined,{shallow:true});
            }
           },[])
           // 회원가입하면 알림창
           useEffect(()=>{
            if(router.query.signUpSuccess=='true'){
                alert('회원가입이 완료되었습니다. 로그인 해 주세요!');
                //알림창 띄우고, 쿼리 제거 / 새로고침해도 알림창이 다시 안뜨게
                //          주소표시창줄
                router.replace('/login',undefined,{shallow:true});
            }
           },[]);
           // 로그인
           const onSubmit= (e)=>{
            e.preventDefault();
            if(!email.trim()){alert('이메일을 입력해주세요.');return;}
            if(!password.trim()){alert('비밀번호를 입력해주세요.');return;}
            dispatch({type:LOG_IN_REQUEST,data:{email,password}});
           }
           //로그인후 사용자 목록 페이지 이동
           useEffect(()=>{
            if(me)//
                router.push('/users') //replace : 주소표시창줄 바뀜, history 추가 x / push : 주소표시창줄 바뀜, history추가 o
                  //  {pathname:'/users',
                  //  query:{loginSuccess:'true'}});
           // }
           },[me,router]);
    return (
        <div className="container my-4">
            <h3 className="mb-3">로그인</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/*이메일 입력*/}
                <div className="mb-3">
                    <input type="email" className="form-control" placeholder="이메일" title="이메일입력"
                    value={email} onChange={(e)=>{setEmail(e.target.value);}}/>
                </div>
                {/*비밀번호 입력*/}
                <div className="mb-3">
                    <input type="password" className="form-control" placeholder="비밀번호" title="비밀번호입력"
                    value={password} onChange={(e)=>{setPassword(e.target.value);}}/>
                </div>
                {/*버튼 입력*/}
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary w-100">로그인</button>
                </div>
            </form>
            {/*에러 메세지 */}
            {error && <div className="alert alert-danger w-50 mx-auto p-2 text-center">{error}</div>}
        </div>
    );
}