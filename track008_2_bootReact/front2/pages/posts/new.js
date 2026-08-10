//1. import
import React , {useState,useEffect} from "react"; // 5. 변수 4. 이벤트알림
import {useSelector,useDispatch} from "react-redux";
import { Card,Form,Button,Input,message,Upload,Select } from "antd"; // 1. 전역정보,2. 이벤트발생
import {useRouter} from "next/router"; // 3. 화면이동
import { createPostRequest,resetPostState } from "../../reducers/postReducer"; //액션
import { UploadOutlined } from "@ant-design/icons";
// import { Content } from "antd/lib/layout/layout";
// store : useSelector(전역) , useDispatch(스토어이벤트알림)
//   감지 : useEffect(이벤트변경감지) , useState(변수) 
//   경로 : useRouter
//2. export + 부품
export default function NewPostpage(){
    //1. 글정보(state.post) 유저정보(state.user)가져오기 (useSelector: 전역정보)
    const router = useRouter();
    const dispath = useDispatch();
    const {loading,error,success} = useSelector((state)=>state.post) // 글정보
    //2. 유저정보 
    const {user} = useSelector((state)=>state.auth); // 유저정보 user
    console.log("user 확인:", user);
    const [fileList,setfileList] = useState([]);

    //2. 게시글 작성(dispatch(createPostRequest(dto)):이벤트발생알림)
    // {userId,dto(content,해쉬태그),files}
    const onFinish =(values)=>{
        const dto = {
            content:values.content,
            hashtags:values.hashtags?values.hashtags.join(","):"",
        };
        const files= fileList.map((f)=>f.originFileObj);

        dispath(createPostRequest({userId:user.id,dto,files}));

        };
        //useSelect(전역) / useDispatch(알림) / useState(변수) / useEffect(이벤트변화감지) / 리스트

        useEffect(()=>{
    dispath(resetPostState()); // 마운트되자마자 이전 상태 초기화
},[]);
        useEffect(()=>{
            if(success){
                message.success("게시글이 성공적으로 작성되었습니다.");
                setfileList([]);
                dispath(resetPostState());
                router.push("/");
            }
                return ()=>{if(success){dispath(resetPostState());}
        };
        },[success,router,dispath]);

    ///////////////////// View
    return (
        <div style={{maxWidth:600 , margin: "40px auto"}}>
            <Card title="게시글 작성" style={{maxWidth:600,margin:"0 auto"}}>
               <Form onFinish={onFinish} layout="vertical">
                    <Form.Item
                    label="내용"
                    name="content"
                    hasFeedback
                    rules={[{required:true,message:'내용을 입력하세요'}]}
                    >
                        <Input.TextArea rows={4} placeholder="게시글 내용을 입력하세요." />
                    </Form.Item>
                    {/* 해시태그 입력 */}
                    <Form.Item labe="해시태그" name="hashtags">
                        <Select mode="tags" style={{width:"100%"}} placeholder="해시태그 입력 후 Enter"></Select>
                    </Form.Item>
                    {/* 이미지 업로드 */}
                    <Form.Item labe="이미지업로드">
                        <Upload multiple beforeUpload={()=>false} fileList={fileList} 
                        onChange={({fileList})=>setfileList(fileList)} listType="picture-card">
                            <Button icon={<UploadOutlined/>}>이미지 선택</Button>
                        </Upload>
                    </Form.Item>
                    <Button type="primary" htmlType="submit" loading={loading}>게시글 작성</Button>
                    {error && <p style={{color:"red"}}>{error}</p>}
               </Form>
            </Card>
        </div>
    );
}

// export default function NewPostpage(){
//     return "NewPostPage";
// }