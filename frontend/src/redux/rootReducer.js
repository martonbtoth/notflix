import {combineReducers} from "redux";
import {authenticationReducer, loadTitles} from "./reducers";

export default combineReducers({
    titles: loadTitles,
    authentication: authenticationReducer
})
