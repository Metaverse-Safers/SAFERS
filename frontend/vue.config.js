module.exports = {
    devServer: {
      compress: true,
      disableHostCheck: true,
      https: true,
      port: 8080,
      open: true,
  
      proxy: {
        '/api': {
          target: 'https://localhost:8080/'
        },
      },
      historyApiFallback: true,
      hot: true
    },
  
  }