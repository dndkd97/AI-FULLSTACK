import React, {useEffect, useState} from "react"; // 이벤트 변경감지, useState(변수변경)
import {useSelector,useDispatch} from "react-redux"; // 전역상태, 스토어알림
import {deletePostRequest, fetchPostRequest, updatePostRequest} from "../reducers/postReducer"
import {Spin, message} from "antd";
import PostList from "../components/PostList";
import EditPostModel from "../components/EditPostModel";

export default function Home(){
    const dispatch = useDispatch();
    const {posts,loading,error} = useSelector((state)=>state.post);
    const {user} = useSelector((state)=>state.auth); // 추가: 로그인 유저 정보 가져오기 // ## 

    // 수정모달 : isEditModalVisible , setIsEditModalVisible
    const [isEditModalVisible,setIsEditModalVisible] = useState(false);
    const [uploadFiles,setUploadFiles]=useState([]); // ## 

    // 수정할글 : editPost, setEidtPost
    const [editPost,setEidtPost] =useState(null);

    // 수정기능 : hadleEditSubmit
    const handleEdit=(post)=>{
            console.log("post:", post);
    console.log("user:", user);
        if(post.userNickname !== user?.nickname){
            message.warning("작성자만 수정 할 수 있습니다.");
            return;
        }
        setEidtPost(post); // 수정글세팅
        setIsEditModalVisible(true); // 수정화면 보이기
    };

    // ## 2. saga 넘기는 데이터 확인 userId,postId,dto,files
    const handleEditSubmit=(values)=>{
            console.log("user:", user);
            console.log("editPost:", editPost);
                if (!user?.id) {
                message.error("로그인 정보가 없습니다. 다시 로그인해주세요.");
                return;
                }           
        dispatch(
            updatePostRequest({
                userId:user.id,
                postId:editPost.id , 
                dto:{
                    content:values.content,
                    hashtags:Array.isArray(values.hashtags)
                                            ?values.hashtags.join(",")
                                            :values.hashtags},
                    files:uploadFiles})
        ); // 수정기능 후
        setIsEditModalVisible(false); //화면안보이기
        setEidtPost(null);
        setUploadFiles([]);
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
                key={editPost?.id}
                visible={isEditModalVisible}
                onCancel={()=>setIsEditModalVisible(false)}
                editPost={editPost}
                onsubmit={handleEditSubmit}
                uploadFiles={uploadFiles}
                setUploadFiles={setUploadFiles}
            />
        </>
    );
}