import React, {Component} from 'react';
import './Player.scss';
import {Link} from "react-router-dom";

class Player extends Component {

    constructor(props, context) {
        super(props, context);
        this.prevTimestamp = new Date().getTime();

        this.onProgressChange = this.onProgressChange.bind(this)
    }

    componentDidMount() {
        this.props.loadContentMetadata(this.props.contentId);
    }

    onProgressChange(e) {
        const progress = Math.floor(e.target.currentTime);
        let currentTime = new Date().getTime();
        if (currentTime - 2500 > this.prevTimestamp) {
            this.prevTimestamp = currentTime;
            this.props.updateProgress(this.props.contentId, progress);
        }
    }

    render() {
        let {contentId, player} = this.props;
        return (
            <div className="player" style={{height: window.innerHeight}}>
                {player.status === 'LOADED' ?
                    <video ref={(e) => e ? e.ontimeupdate = this.onProgressChange : null}
                           autoPlay
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
