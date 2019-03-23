import React, {Component} from "react";

class Login extends Component {
    constructor(props, context) {
        super(props, context);

        this.state = {};

        this.onUsernameChange = this.onUsernameChange.bind(this);
        this.onPasswordChange = this.onPasswordChange.bind(this);
        this.onLogin = this.onLogin.bind(this);
    }

    componentDidMount() {
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
            <form>
                <div>
                    <input type="text" value={this.state.username} onChange={this.onUsernameChange}/>
                </div>
                <div>
                    <input type="password" value={this.state.password} onChange={this.onPasswordChange}/>
                </div>
                <div>
                    <button onClick={this.onLogin}>
                        Login
                    </button>
                </div>
            </form>
        );
    }
}


export default Login;
