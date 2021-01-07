#!/usr/bin/env sh

for f in ls *json
do
  echo $f, $(cat $f) >> cheapest_prices.csv
done
