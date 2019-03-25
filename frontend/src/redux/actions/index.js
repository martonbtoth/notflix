import axios from "axios";

const checkAuth = async (error) => {
    return false;
};

const createAuthHeader = (getState) => {
    return `Bearer ${getState().authentication.token}`;
};

export const loadTitles = () => async (dispatch, getState) => {
    try {
        const response = await axios.get('/api/titles', {
            headers: {"Authorization": createAuthHeader(getState)}
        });

        return dispatch({
            type: "LOAD_TITLES",
            titles: response.data
        });
    } catch (e) {
        let authStatus = await checkAuth(e);

        if (!authStatus) {
            return dispatch({
                type: "UNAUTHORIZED"
            });
        }
    }
};

export const logout = () => {
    return {
        type: "LOGOUT"
    }
};

export const login = (username, password) => async (dispatch) => {
    try {
        const response = await axios.post("/api/login", {username, password});
        return dispatch({
            type: "LOGGED_IN",
            token: response.data.token
        })
    } catch (e) {
        return dispatch({
            type: "LOGIN_FAILED"
        })
    }
};


export const loadProfile = () => async (dispatch) => {
    const response = await axios.get("/api/profile");

    let authStatus = await checkAuth(response);

    if (!authStatus) {
        return dispatch({
            type: "UNAUTHORIZED"
        });
    }

    return dispatch({
        type: "PROFILE_RESPONSE",
        profile: response.data
    });
};

export const resetPlayer = () => {
    return {
        type: 'RESET_PLAYER'
    };
};

export const loadContentMetadata = (titleId) => async (dispatch, getState) => {
    dispatch(resetPlayer());

    const response = await axios.get(`/api/titles/${titleId}`,
        {
            headers: {"Authorization": createAuthHeader(getState)}
        });

    return dispatch({
        type: 'PLAYING_CONTENT_METADATA_LOADED',
        metadata: response.data
    })
};
