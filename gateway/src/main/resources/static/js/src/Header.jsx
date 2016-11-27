import * as React from "react";

export default class Header extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return <div style={{float: 'right'}}>{this.props.username}</div>;
    }
}