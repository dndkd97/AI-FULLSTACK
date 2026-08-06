import { Button,Modal,Form,Input } from "antd";

export default function EditPostModel({visible,onCancel,editPost,onsubmit}){
    return(<Modal title="글수정" open={visible} onCancel={onCancel} footer={null} >
            <Form
            initialValues={{
                content:editPost?.content,
            }}
            onFinish={onsubmit}
            layout="vertical"
            >
                <Form.Item name="content" label="내용">
                    <Input.TextArea rows={4}/>
                </Form.Item>
                <Button type="primary" htmlType="submit">
                    수정완료
                </Button>
            </Form>
        </Modal>);
}