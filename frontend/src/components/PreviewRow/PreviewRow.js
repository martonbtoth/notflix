import React, { Component } from 'react';
import './PreviewRow.scss';

export class PreviewRow extends React.Component {


    render() {
        return (
            <div className="preview-row">
                {this.props.children}
            </div>
        );
    }

}