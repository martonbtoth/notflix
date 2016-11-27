var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: './static/js/src/index.jsx',
    output: {path: __dirname, filename: './static/js/dist/bundle.js'},
    devtool: 'source-map',
    module: {
        loaders: [
            {
                test: /.jsx?$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};