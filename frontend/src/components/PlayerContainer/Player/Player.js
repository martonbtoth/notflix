import React from 'react';
import './Player.scss';
import {Link} from "react-router-dom";

const PlayerContainer = ({contentId}) => (
    <div className="player" style={{height: window.innerHeight}}>
        <video autoPlay controls src={`/api/content/${contentId}/stream`}/>
        <div className="close">
            <Link to="/">X</Link>
        </div>
    </div>
);

export default PlayerContainer;
