import React from 'react';
import './Player.scss';
import {Link} from "react-router-dom";

const PlayerContainer = ({ contentId }) => (
    <div className="player">
        <Link to="/">Brexit</Link>
        <video autoPlay controls src={`/api/content/${contentId}/stream`} />
    </div>
);

export default PlayerContainer;