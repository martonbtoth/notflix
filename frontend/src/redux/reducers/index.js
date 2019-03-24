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
            window.localStorage.token = null;
            return {...state, token: null, loginAttemptFailed: false};
        case 'LOGGED_IN':
            window.localStorage.token = action.token;
            return {...state, token: action.token, loginAttemptFailed: false};
        case 'LOGIN_FAILED':
            return {...state, loginAttemptFailed: true};
        case 'LOGOUT':
            window.localStorage.token = null;
            return {...state, token: null, loginAttemptFailed: false};
        default:
            return state;
    }
};
