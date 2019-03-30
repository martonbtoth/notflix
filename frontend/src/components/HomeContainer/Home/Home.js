import {PreviewRow} from "../../PreviewRow/PreviewRow";
import {Preview} from "../../Preview/Preview";
import Block from "../../Block/Block";
import React, {Component} from "react";
import Header from "../../Header/Header";
import './Home.scss'

class Home extends Component {

    render() {
        const titles = this.props.titles || [];
        return (
            <div className="home">
                <Header/>
                <Block vertical>
                    <PreviewRow title="All movies">
                        {
                            titles.map(title => (
                                <Preview key={title.id} title={title}/>
                            ))
                        }
                    </PreviewRow>
                </Block>
            </div>
        );
    }
}


export default Home;
