import React from 'react';
import './PreviewRow.scss';

export class PreviewRow extends React.Component {

    render() {
        return (
            <div className="preview-row">
                <div className="title">
                    {this.props.title}
                </div>
                <div className="content">
                    {this.props.children}
                </div>

            </div>
        );
    }

}