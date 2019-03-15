import {PreviewRow} from "../../PreviewRow/PreviewRow";
import {Preview} from "../../Preview/Preview";
import Block from "../../Block/Block";
import React, {Component} from "react";

class Home extends Component {

    render() {
        const titles = this.props.titles || [];
        return (
            <Block vertical>
                <PreviewRow title="All movies">
                    {
                        titles.map(title => (
                            <Preview title={title}/>
                        ))
                    }
                </PreviewRow>
                <PreviewRow title="Kovi specials">
                    <Preview title="A botkormanyos"/>
                    <Preview title="A botkormanyos 2"/>
                    <Preview title="A botkormanyos ujra lecsap"/>
                </PreviewRow>
            </Block>
        );
    }
}


export default Home;