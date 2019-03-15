import axios from "axios";

export const loadTitles = () => async (dispatch) =>  {

    const titles = await axios.get("/api/titles");

    return dispatch({
        type: "LOAD_TITLES",
        titles: titles.data
    })
};