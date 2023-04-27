// @flow
const webpack = require('webpack');
const path = require('path');
const TerserPlugin = require('terser-webpack-plugin');
const atomTypes = require('./webpack/atomTypes');

const createJsSettings = rendering => atomType => ({
  mode: 'production',
  entry: {
    [atomType]: `./${atomType}/${rendering}/index.fjs`
  },
  module: {
    rules: [
      {
        test: /\.fjs$/,
        exclude: /node_modules/,
        loader: 'babel-loader'
      }
    ]
  },
  resolve: {
    extensions: ['.fjs'],
    modules: [path.join(__dirname, 'core', 'src', 'main', 'resources', 'lib')]
  },
  context: path.resolve(__dirname, 'core', 'src', 'main', 'resources'),
  plugins: [new webpack.EnvironmentPlugin(['NODE_ENV'])],
  output: {
    filename: 'index.js',
    path: path.resolve(__dirname, 'dist', atomType, rendering),
    libraryTarget: 'commonjs',
    library: atomType
  },
  optimization: {
    minimizer: [
      new TerserPlugin({
        parallel: true,
        terserOptions: {
          sourceMap: true
        }
      })
    ]
  }
});

module.exports = atomTypes.map(createJsSettings('article'));
