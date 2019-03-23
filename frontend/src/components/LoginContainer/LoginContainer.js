import React from "react";
import {login} from "../../redux/actions";
import {connect} from "react-redux";
import Login from "./Login/Login";


class LoginContainer extends React.Component {

    render() {
        return <Login {...this.props} />;
    }
}

const mapStateToProps = state => ({
    authentication: state.authentication
});

const mapDispatchToProps = dispatch => ({
    login: (username, password) => dispatch(login(username, password))
});

export default connect(mapStateToProps, mapDispatchToProps)(LoginContainer)
