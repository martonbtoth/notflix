import './HeaderNav.scss';
import React from "react";


const HeaderItem = ({children, onClick}) => (
    <div onClick={onClick} className="header-item">
        {children}
    </div>
);

const HeaderNav = ({logout}) => (
    <React.Fragment>
        <div className="header-nav">
            <img src="/logo.png"/>
            <HeaderItem>Home</HeaderItem>
            <HeaderItem>Stuff</HeaderItem>
            <HeaderItem>Other stuff</HeaderItem>
        </div>
        <div className="header-nav">
            <HeaderItem onClick={() => logout()}>Logout</HeaderItem>
        </div>
    </React.Fragment>
);

export default HeaderNav;
