module.exports = {
    runtimeCompiler: true,
    devServer: {
      compress: true,
      disableHostCheck: true,
      https: true,
      port: 8081,
      open: true,
  
      proxy: {
        '/api': {
          target: 'https://localhost:8080/'
        },
      },
      historyApiFallback: true,
      hot: true
    },
    outputDir: '../backend/src/main/resources/dist'
  }