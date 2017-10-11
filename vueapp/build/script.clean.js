var
  shell = require('shelljs'),
  path = require('path')

shell.rm('-rf', path.resolve(__dirname, '../../src/main/resources/static/*'))
shell.rm('-rf', path.resolve(__dirname, '../../src/main/resources/static/.*'))
console.log(' Cleaned build artifacts.\n')
