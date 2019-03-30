import React, {Component} from 'react';
import './App.scss';
import HomeContainer from "./components/HomeContainer/HomeContainer";
import {BrowserRouter as Router, Route} from "react-router-dom"
import PlayerContainer from "./components/PlayerContainer/PlayerContainer";
import {login} from "./redux/actions";
import {connect} from "react-redux";
import LoginContainer from "./components/LoginContainer/LoginContainer";
import {CSSTransitionGroup} from 'react-transition-group'

class App extends Component {
    render() {
        console.log(this.props);
        return (
            <div className="App">
                <CSSTransitionGroup
                    transitionName="animate"
                    transitionAppear={true}
                    transitionEnterTimeout={500}
                    transitionLeaveTimeout={500}
                >
                    {!this.props.authentication.token ? <LoginContainer key={1}/> :
                        (<Router key={5}>
                            <Route path="/" exact component={HomeContainer}/>
                            <Route path="/play/:id" component={PlayerContainer}/>
                        </Router>)
                    }
                </CSSTransitionGroup>
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
