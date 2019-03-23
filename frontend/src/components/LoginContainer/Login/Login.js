import React, {Component} from "react";
import "./Login.scss"

class Login extends Component {
    constructor(props, context) {
        super(props, context);

        this.state = {};

        this.onUsernameChange = this.onUsernameChange.bind(this);
        this.onPasswordChange = this.onPasswordChange.bind(this);
        this.onLogin = this.onLogin.bind(this);
    }

    onUsernameChange(e) {
        this.state.username = e.target.value;
    }

    onPasswordChange(e) {
        this.state.password = e.target.value;
    }

    onLogin(e) {
        e.preventDefault();
        const {login} = this.props;

        login(this.state.username, this.state.password);
        return false;
    }

    render() {
        return (
            <div className="login" style={{height: window.innerHeight}}>
                <div className="login-card">
                    <div className="row">
                        <img src="/logo.png" />
                    </div>
                    <div className="row label">
                        Username
                    </div>
                    <div className="row">
                        <input
                            type="text"
                            name="username"
                            value={this.state.username}
                            onChange={this.onUsernameChange}
                            onSubmit={this.onLogin}
                        />
                    </div>
                    <div className="row label">
                        Password
                    </div>
                    <div className="row">
                        <input
                            type="password"
                            value={this.state.password}
                            onChange={this.onPasswordChange}
                            onSubmit={this.onLogin}
                        />
                    </div>
                    <div className="row">
                        <button onClick={this.onLogin}>
                            Login
                        </button>
                    </div>
                </div>

            </div>
        );
    }
}


export default Login;
