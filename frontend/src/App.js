import React, {Component} from 'react';
import './App.scss';
import HomeContainer from "./components/HomeContainer/HomeContainer";
import {BrowserRouter as Router, Route} from "react-router-dom"
import PlayerContainer from "./components/PlayerContainer/PlayerContainer";
import {login} from "./redux/actions";
import {connect} from "react-redux";
import LoginContainer from "./components/LoginContainer/LoginContainer";

class App extends Component {
    render() {
        return (
            <div className="App">
                {this.props.authentication.token === null ? <LoginContainer/> :
                    (<Router>
                        <Route path="/" exact component={HomeContainer}/>
                        <Route path="/play/:id" component={PlayerContainer}/>
                    </Router>)
                }
            </div>
        );
    }
}

const mapStateToProps = state => ({
    authentication: state.authentication
});

const mapDispatchToProps = dispatch => ({
    login: (username, password) => dispatch(login(username, password))
});


export default connect(mapStateToProps, mapDispatchToProps)(App);
