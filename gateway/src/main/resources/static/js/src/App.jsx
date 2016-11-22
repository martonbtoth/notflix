import * as React from "react";
import Header from "./Header.jsx";
import * as axios from "axios";

function Placeholder(props) {
    return <img src={'http://placehold.it/' + props.x + 'x' + props.y}/>;
}


export default class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    componentDidMount() {
        let _this = this;
        axios.get('/api/users/me').then((response) => _this.setState({username: response.data.username}));
    }

    render() {
        return <div>
            <Header username={this.state.username}/>
            <h1>Hello, world!</h1>
            <Placeholder x="200" y="300"/>
        </div>;
    }
}

