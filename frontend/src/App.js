import React, {Component} from 'react';
import './App.scss';
import Header from "./components/Header/Header";
import HomeContainer from "./components/HomeContainer/HomeContainer";
import { BrowserRouter as Router, Route, Link } from "react-router-dom"
import PlayerContainer from "./components/PlayerContainer/PlayerContainer";

class App extends Component {
    render() {
        return (
            <div className="App">
                <Router>
                    <Route path="/" exact component={HomeContainer} />
                    <Route path="/play/:id" component={PlayerContainer} />
                </Router>
            </div>
        );
    }
}

export default App;
