#!/usr/bin/env bash
api_key="M5m0SbU7QA4lzpwxewk8eH4RVAkyBzaP"
api_secret="ygRsTSJQxrTxo7If"
curl "https://test.api.amadeus.com/v1/security/oauth2/token" \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -d "grant_type=client_credentials&client_id=$api_key&client_secret=$api_secret"
