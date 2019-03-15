import {loadTitles} from "../../redux/actions";
import {connect} from "react-redux";
import Home from "./Home/Home";
import React from "react";


class HomeContainer extends React.Component {

    componentDidMount() {
        this.props.loadTitles();
    }

    render() {
        return ( <div>
            <Home {...this.props} />
            </div>
        );
    }
}

const mapStateToProps = state => ({
    titles: state.titles || []
});

const mapDispatchToProps = dispatch => ({
    loadTitles: () => dispatch(loadTitles())
});

export default connect(mapStateToProps, mapDispatchToProps)(HomeContainer)