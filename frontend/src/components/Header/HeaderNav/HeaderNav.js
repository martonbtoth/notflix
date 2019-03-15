import './HeaderNav.scss';
import React from "react";


const HeaderItem = ({ children }) => (
    <div className="header-item">
        {children}
    </div>
);

const HeaderNav = () => (
    <div className="header-nav">
        <HeaderItem>Home</HeaderItem>
        <HeaderItem>Stuff</HeaderItem>
        <HeaderItem>Other stuff</HeaderItem>
    </div>
);

export default HeaderNav;