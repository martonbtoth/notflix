import React, {Component} from "react";
import "./Login.scss"

class Login extends Component {
    constructor(props, context) {
        super(props, context);

        this.state = {
            username: '',
            password: ''
        };

        this.onUsernameChange = this.onUsernameChange.bind(this);
        this.onPasswordChange = this.onPasswordChange.bind(this);
        this.onLogin = this.onLogin.bind(this);
    }

    onUsernameChange(e) {
        this.setState({username: e.target.value});
    }

    onPasswordChange(e) {
        this.setState({password: e.target.value});
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
                    <form onSubmit={this.onLogin}>
                        <div className="row">
                            <img src="/logo.png"/>
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
                        {
                            this.props.authentication.loginAttemptFailed ?
                                (<div className="row error-message">Could not log you in &#x1f937;&#x200d;</div>)
                                : <div className="row error-message">&nbsp;</div>
                        }
                        <div className="row">
                            <button onClick={this.onLogin}>
                                Login
                            </button>
                        </div>
                    </form>
                </div>

            </div>
        );
    }
}


export default Login;
