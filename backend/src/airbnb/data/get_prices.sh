#!/usr/bin/env sh

#for f in ls *json
#do
#  grep -o "price_string: '[$][0-9][0-9,][0-9]*'" $f > prices/"$f"
#done
f="miami.json"
grep -o "price_string: '[$][0-9][0-9,][0-9]*'" $f > prices/"$f"
