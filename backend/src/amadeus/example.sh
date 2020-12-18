#!/usr/bin/env bash
api_key="M5m0SbU7QA4lzpwxewk8eH4RVAkyBzaP"
api_secret="ygRsTSJQxrTxo7If"
token="LIFcc46H1O7s5Fwxqb4Vu1grorsh"
#ACCESS_TOKEN=$(curl -H "Content-Type: application/x-www-form-urlencoded" \
#https://test.api.amadeus.com/v1/security/oauth2/token \
#-d "grant_type=client_credentials&client_id=$api_key&client_secret=$api_secret" \
#| grep access_token | sed 's/"access_token": "\(.*\)"\,/\1/' | tr -d '[:space:]')
 
curl -X GET "https://test.api.amadeus.com/v1/shopping/flight-dates?origin=MAD&destination=MUC" -H "Authorization: Bearer $token" -k


        
#curl -X GET 'https://test.api.amadeus.com/v1/shopping/flight-destinations?origin=PAR&maxPrice=200' -H 'Authorization: Bearer $token'

