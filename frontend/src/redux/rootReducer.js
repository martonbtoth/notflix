import { combineReducers } from "redux";
import { loadTitles } from "./reducers";

export default combineReducers({
    titles: loadTitles
})