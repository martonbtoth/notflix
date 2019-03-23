export const loadTitles = (state = [], action) => {
    switch (action.type) {
        case 'LOAD_TITLES':
            return action.titles;
        default:
            return state;
    }
};

const authenticationDefaultState = {
    token: window.localStorage.token
};

export const authenticationReducer = (state = authenticationDefaultState, action) => {
    switch (action.type) {
        case 'UNAUTHORIZED':
            window.localStorage.token = null;
            return {...state, token: null};
        case 'LOGGED_IN':
            window.localStorage.token = action.token;
            return {...state, token: action.token};
        default:
            return state;
    }
};
