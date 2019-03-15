import React, { Component } from 'react';
import './Preview.scss';

export class Preview extends React.Component {


    render() {
        return (
            <div className="preview">
                <div className="info">
                    <div className="title">
                        {this.props.title}
                    </div>
                </div>
            </div>
        );
    }

}