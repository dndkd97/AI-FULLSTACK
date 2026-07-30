// components/AppLayout.js # 재사용 가능한 UI 컴포넌트 폴더
//1. require
import { Layout,Menu,Input,Drawer,Grid,Button,Row,Col } from 'antd';
import { MenuQutlined,SearchOutlined } from "@ant-design/icons";

import { useSelector,useDispatch } from 'react-redux'; // 전역상태, 액션
import { useRouter }               from 'next/router'; // 경로이동
import { useEffect,useState }      from 'react';       // 이벤트변경감지, 변수
import Link                        from 'next/link';   
import MenuItem from 'antd/lib/menu/MenuItem';

const {Header,Content} = Layout;    // <Layout.Header> → <Header>
const {userBreakpoint} = Grid;
//2. 부품
// Header / Drawer
function AppLayout(){
    const menuItems = [
        { key: "new",     label: <Link href="/posts/new">✏️ NEW POST</Link> },
        { key: "profile", label: <Link href="/mypage">👤 MYPAGE </Link> },
        { key: "home",    label: <Link href="/signup">🏠 JOIN</Link> },
    ];
    /////////////////////////
    return (<Layout>
        {/* Header */}
        <Header style={{display:"flex"}}>
            <Row align="middle" justify="space-between" style={{width:"100%"}}>
                <Col>
                    <Link href="/">
                        <a style={{color:"#fff",fontWeight:"bold",fontSize:"18px"}}>
                            THEJOA703 (POST VER)
                        </a>
                    </Link>
                </Col>
                <Col flex="auto">
                    <Menu
                    theme="dark"
                    mode="horizontal"
                    items={menuItems}
                    />
                 </Col>
            </Row>
        </Header>
        <Content>123123</Content>
    </Layout>);
}

//3. export
export default AppLayout;

// Layout: https://ant.design/components/layout 
// Menu: https://ant.design/components/menu 
// Input: https://ant.design/components/input 
// Drawer: https://ant.design/components/drawer 
// Grid(Row/Col): https://ant.design/components/grid 
// Button: https://ant.design/components/button