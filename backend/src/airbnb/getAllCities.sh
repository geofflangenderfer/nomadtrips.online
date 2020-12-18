#!/usr/bin/env bash

citiesUri="/home/geofflangenderfer/work/nomadtrips.online/backend/src/nomadlist/cities.txt"
while IFS= read -r city; do
  ./monthly_search $city &> data/$city.json || echo $city >> misfire.txt
  sleep 111
done < $citiesUri

