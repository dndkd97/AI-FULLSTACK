import React, {useEffect, useState} from "react"; // 이벤트 변경감지, useState(변수변경)
import {useSelector,useDispatch} from "react-redux"; // 전역상태, 스토어알림
import {deletePostRequest, fetchPostRequest, updatePostRequest} from "../reducers/postReducer"
import {Spin} from "antd";
import PostList from "../components/PostList";
import EditPostModel from "../components/EditPostModel";

export default function Home(){
    const dispatch = useDispatch();
    const {posts,loading,error} = useSelector((state)=>state.post);

    // 수정모달 : isEditModalVisible , setIsEditModalVisible
    const [isEditModalVisible,setIsEditModalVisible] = useState();
    // 수정할글 : editPost, setEidtPost
    const [editPost,setEidtPost] =useState(null);
    // 수정기능 : hadleEditSubmit
    const handleEdit=(post)=>{
        setEidtPost(post); // 수정글세팅
        setIsEditModalVisible(true); // 수정화면 보이기
    };
    const handleEditSubmit=(values)=>{
        dispatch(
            updatePostRequest({postId:editPost.id , dto:{content:values.content}})
        ); // 수정기능 후
        setIsEditModalVisible(false); //화면안보이기
        setEidtPost(null);
    };
    //삭제
    const handleDelete = (postId) =>{
        dispatch(deletePostRequest(postId)); //해당글번호
    };
    // const handleDeleteSubmit=(post)=>{
    //     dispatch(deletePostRequest(post.id))
    // };

    // 페이지가 처음뜰때 게시글 조회 액션 - dispatch
    useEffect(()=>{
        dispatch(fetchPostRequest());
    },[dispatch]);
    ////////////////
    return (
        <>
            <PostList 
                posts={posts}
                handleEdit={handleEdit} 
                handleDelete={handleDelete}
                />
            <EditPostModel 
                visible={isEditModalVisible}
                onCancel={()=>setIsEditModalVisible(false)}
                editPost={editPost}
                onsubmit={handleEditSubmit}
            />
        </>
    );
}