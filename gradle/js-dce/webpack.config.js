var webpack = require("webpack");
var path = require("path");

module.exports = {
    entry: path.resolve(__dirname, "build/classes/main/min/kotlin-dce-example_main.js"),
    output: {
        path: path.resolve(__dirname, "build"),
        filename: "bundle.js"
    },
    resolve: {
        alias: {
            kotlin: path.resolve(__dirname, "build/classes/main/min/kotlin.js")
        }
    },
    plugins: [
        new webpack.optimize.UglifyJsPlugin()
    ]
};