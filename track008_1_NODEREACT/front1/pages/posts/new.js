//1. import
import React , {useState,useEffect} from "react";
import {useSelector,useDispatch} from "react-redux";
import { Card,Form,Button,Input,message } from "antd"; // 전역정보,이벤트발생
import {useRouter} from "next/router"; // 화면이동
import { createPostRequest } from "../../reducers/postReducer"; //액션
import { Content } from "antd/lib/layout/layout";
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
    const {user} = useSelector((state)=>state.auth); //유저정보

    //2. 게시글 작성(dispatch(createPostRequest(dto)):이벤트발생알림)
    const onFinish =(values)=>{
        const dto = {
            content:values.content,
            userId:1
        };
        dispath(createPostRequest(dto));
        message.success("게시글 작성요청완료")
        router.push("/");
        };

    /////////////////////
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
                    <Button type="primary" htmlType="submit">게시글 작성</Button>
               </Form>
            </Card>
        </div>
    );
}

// export default function NewPostpage(){
//     return "NewPostPage";
// }