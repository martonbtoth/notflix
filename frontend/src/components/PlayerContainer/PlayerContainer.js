import React from 'react';
import Player from "./Player/Player";
import {loadContentMetadata} from "../../redux/actions";
import {connect} from "react-redux";

const PlayerContainer = (props) => (
    <Player contentId={props.match.params.id} {...props} />
);

const mapStateToProps = (state) => ({
    player: state.player
});

const mapDispatchToProps = (dispatch) => ({
    loadContentMetadata: (id) => dispatch(loadContentMetadata(id))
});

export default connect(mapStateToProps, mapDispatchToProps)(PlayerContainer);
