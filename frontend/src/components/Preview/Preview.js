import React from 'react';
import './Preview.scss';
import {Link} from "react-router-dom";

export class Preview extends React.Component {

    calculateProgress(title) {
        return ((title.progress / title.length) * 100) + "%"
    }

    render() {
        return (
            <Link to={`/play/${this.props.title.id}`}>
                <div className="preview" style={{
                    "backgroundImage": `url(/api/content/${this.props.title.id}/thumbnail)`
                }}>
                    <img className="logo" src="/logo.png"/>
                    <div className="info">
                        <div className="title">
                            {this.props.title.title}
                        </div>
                        <div className="description">
                            {this.props.title.description}
                        </div>
                    </div>
                    {
                        this.props.title.progress ?
                            <div className="progress-bar">
                                <div className="progress-bar-progress"
                                     style={{width: this.calculateProgress(this.props.title)}}
                                />
                            </div>
                            : null
                    }

                </div>
            </Link>
        );
    }

}
