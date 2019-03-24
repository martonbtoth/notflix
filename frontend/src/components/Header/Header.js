import React from "react";
import './Header.scss'
import Block from "../Block/Block";
import HeaderNav from "./HeaderNav/HeaderNav";
import {logout} from "../../redux/actions";
import {connect} from "react-redux";

const Header = (props) => (
    <div className="header">
        <Block>
            <HeaderNav {...props}/>
        </Block>
    </div>
);

const mapStateToProps = (state) => ({});

const mapDispatchToProps = (dispatch) => ({
    logout: () => dispatch(logout())
});

export default connect(mapStateToProps, mapDispatchToProps)(Header);
