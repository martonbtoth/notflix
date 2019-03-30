export const loadTitles = (state = [], action) => {
    switch (action.type) {
        case 'LOAD_TITLES':
            return action.titles;
        default:
            return state;
    }
};

const authenticationDefaultState = {
    token: window.localStorage.token,
    loginAttemptFailed: false
};

export const authenticationReducer = (state = authenticationDefaultState, action) => {
    switch (action.type) {
        case 'UNAUTHORIZED':
            delete window.localStorage.token;
            return {...state, token: null, loginAttemptFailed: false};
        case 'LOGGED_IN':
            window.localStorage.token = action.token;
            return {...state, token: action.token, loginAttemptFailed: false};
        case 'LOGIN_FAILED':
            return {...state, loginAttemptFailed: true};
        case 'LOGOUT':
            delete window.localStorage.token;
            return {...state, token: null, loginAttemptFailed: false};
        default:
            return state;
    }
};

const playerDefaultState = {
    status: "LOADING",
    metadata: null
};

export const playerReducer = (state = playerDefaultState, action) => {
    switch (action.type) {
        case 'PLAYING_CONTENT_METADATA_LOADED':
            return {status: 'LOADED', metadata: action.metadata};
        case 'RESET_PLAYER':
            return playerDefaultState;
        default:
            return state;
    }
};
