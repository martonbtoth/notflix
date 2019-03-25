import {combineReducers} from "redux";
import {authenticationReducer, loadTitles, playerReducer} from "./reducers";

export default combineReducers({
    titles: loadTitles,
    authentication: authenticationReducer,
    player: playerReducer
})
