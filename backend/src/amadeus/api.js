#!/usr/bin/env node
const Amadeus = require('amadeus');
const util = require('util')


const api_key="M5m0SbU7QA4lzpwxewk8eH4RVAkyBzaP"
const api_secret="ygRsTSJQxrTxo7If"
let origin = process.argv[2]
let dest = process.argv[3]

var amadeus = new Amadeus({
  clientId: api_key,
  clientSecret: api_secret
});

amadeus.shopping.flightOffersSearch.get({
    originLocationCode: origin,
    destinationLocationCode: dest,
    departureDate: '2020-12-10',
    currencyCode: 'USD',
    adults: '1',
    max: '1'
}).then(function(response){
  //console.log(response.data);
  console.log(util.inspect(response.data, {showHidden: false, depth: null}))
}).catch(function(responseError){
  console.log(responseError.code);
});
