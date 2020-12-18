#!/usr/bin/env node
const fs = require('fs');

const obj = JSON.parse(fs.readFileSync('nomadlist.json', 'utf8'));
let cities = []

for (city of obj.cities) {
 cities.push(city.short_slug)
}
fs.writeFile('cities.txt', JSON.stringify(cities), function (err) {
	  if (err) return console.log(err);
});
