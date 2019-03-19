import React from 'react';
import Player from "./Player/Player";

const PlayerContainer = ({ match }) => (
    <Player contentId={match.params.id}/>
);

export default PlayerContainer;