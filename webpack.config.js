//@flow
const webpack = require('webpack');
const path = require('path');
const Uglify = require('uglifyjs-webpack-plugin');

const css = {
  module: {
    rules: [{
      test: /\.scss$/,
      use: [{
        loader: "sass-loader",
        options: {
          includePaths: [
            path.resolve(__dirname, 'src', 'resources', 'css')
          ]
        }
      }]
    }]
  }
};

const commonSettings = {
  resolve: {
    extensions: [".js"]
  },
  module: {
    rules: [{
      test: /\.js$/,
      exclude: /node_modules/,
      use: [{
        loader: 'babel-loader'
      }]
    }]
  },
  context: path.resolve(__dirname, 'src', 'main', 'resources'),
  plugins: [
    new Uglify({
      parallel: true
    }),
    new webpack.DefinePlugin({
      'process.env': {
        'NODE_ENV': JSON.stringify('production')
      }
    })
  ]
};

const guides = Object.assign({  
  entry: {
    guide: './guide/article/index.js',
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, 'target', 'main', 'resources', 'guide', 'article'),
    libraryTarget: 'this',
    library: 'guide'
  },
}, commonSettings);

const qandas = Object.assign({  
  entry: {
    qanda: './qanda/article/index.js',
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, 'target', 'main', 'resources', 'qanda', 'article'),
    libraryTarget: 'this',
    library: 'qanda'
  },
}, commonSettings);

const profiles = Object.assign({  
  entry: {
    profile: './profile/article/index.js',
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, 'target', 'main', 'resources', 'profile', 'article'),
    libraryTarget: 'this',
    library: 'profile'
  },
}, commonSettings);

const timelines = Object.assign({  
  entry: {
    timeline: './timeline/article/index.js',
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, 'target', 'main', 'resources', 'timeline', 'article'),
    libraryTarget: 'this',
    library: 'timeline'
  },
}, commonSettings);

module.exports = [
  css,
  guides,
  qandas,
  profiles,
  timelines
];


