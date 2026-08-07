import { Button,Modal,Form,Input, Select, Upload } from "antd";
//import { useEffect } from "react";

export default function EditPostModel({visible,onCancel,editPost,onsubmit,uploadFiles,setUploadFiles}){
    return(<Modal title="글수정" open={visible} onCancel={onCancel} footer={null} >
            <Form
            initialValues={{
                content:editPost?.content,
                hashtags:editPost?.hashtags
            }}
            onFinish={onsubmit}
            layout="vertical"
            >
                <Form.Item name="content" label="내용">
                    <Input.TextArea rows={4}/>
                </Form.Item>
                <Form.Item label="해시태그" name="hashtags">
                    <Select mode="tags" style={{width:"100%"}} placeholder="해시 태그 입력 후 Enter" />
                </Form.Item>
                <Form.Item>
                    <Upload multiple
                    beforeUpload={()=>false}
                    onChange={({fileList})=>setUploadFiles(fileList.map((f)=>f.originFileObj))}>
                        <Button>이미지선택</Button>
                    </Upload>
                </Form.Item>
                <Button type="primary" htmlType="submit">
                    수정완료
                </Button>
            </Form>
        </Modal>);
}