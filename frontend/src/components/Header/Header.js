import React from "react";
import './Header.scss'
import Block from "../Block/Block";
import HeaderNav from "./HeaderNav/HeaderNav";

const Header = ({ props }) => (
    <div className="header">
        <Block>
            <img src="/logo.png" />
            <HeaderNav />
        </Block>
    </div>
);

export default Header;