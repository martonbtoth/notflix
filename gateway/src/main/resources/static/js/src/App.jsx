import * as React from "react";

function Placeholder(props) {
    return <img src={'http://placehold.it/' + props.x + 'x' + props.y}/>;
}

export default class App extends React.Component {
    render() {
        return <div>
            <h1>Hello, world!</h1>
            <Placeholder x="200" y="300"/>
        </div>;
    }
}

