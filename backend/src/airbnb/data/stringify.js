#!/usr/bin/env node
var fs = require('fs');

fs.readFile( __dirname + '/austin.txt', function (err, data) {
  if (err) {
    throw err; 
  }
  console.log(JSON.stringify(data.toString()));
});
