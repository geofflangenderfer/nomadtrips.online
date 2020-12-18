#!/usr/bin/env bash

citiesUri="/home/geofflangenderfer/work/nomadtrips.online/backend/src/airbnb/speed_this_up.txt"
while IFS= read -r city; do
  ./monthly_search $city &> data/$city.json || echo $city >> misfire.txt
  sleep 30
done < $citiesUri

