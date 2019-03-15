
export const loadTitles = (state = [], action) => {
    switch (action.type) {
        case 'LOAD_TITLES':
            return action.titles;
        default:
            return state;
    }
};