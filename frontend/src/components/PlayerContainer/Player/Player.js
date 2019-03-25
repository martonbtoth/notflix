import React, {Component} from 'react';
import './Player.scss';
import {Link} from "react-router-dom";

class Player extends Component {

    constructor(props, context) {
        super(props, context);
        this.videoRef = React.createRef();
    }

    componentDidMount() {
        this.props.loadContentMetadata(this.props.contentId);
    }

    componentWillUnmount() {
        if (this.videoRef.current && this.videoEventListener) {
            this.videoRef.current.removeEventListener(this.videoEventListener);
        }
    }

    render() {
        console.log("render");
        let {contentId, player} = this.props;
        return (
            <div className="player" style={{height: window.innerHeight}}>
                {player.status === 'LOADED' ?
                    <video autoPlay
                           controls
                           src={`/api/content/${contentId}/stream#t=${player.metadata.progress}`}
                    /> :
                    <div>Loading...</div>
                }
                <div className="close">
                    <Link to="/">✕</Link>
                </div>
            </div>
        );
    }
}

export default Player;
