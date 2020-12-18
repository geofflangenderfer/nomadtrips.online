#!/usr/bin/env node
const fs = require('fs')
let input_city = process.argv[2]
let nomadListJson= "/home/geofflangenderfer/work/nomadtrips.online/backend/src/nomadlist/nomadlist.json"
let cost_for_local = -1
fs.readFile(nomadListJson, function read(err, data) {
  if (err) {
      throw err;
  }
  const content = JSON.parse(data);

  // Invoke the next step here however you like
  //console.log(content.cities);   // Put all of the code here (not the best solution)
  cost_for_local = getCostForLocal(content);   // Or put the next step in a function and invoke it
  console.log(`cost_for_local ${cost_for_local}`)
});

function getCostForLocal(content) {
  for (city of content.cities) {
    if (city.short_slug === input_city) {
      return city.cost_for_local_in_usd
    }
  }
}

