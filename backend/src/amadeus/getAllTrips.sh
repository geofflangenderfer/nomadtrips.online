#!/usr/bin/env bash

origins="/home/geofflangenderfer/work/nomadtrips.online/backend/src/origins/unique_codes_remaining.txt"
destinations="/home/geofflangenderfer/work/nomadtrips.online/backend/src/airbnb/data/analysis/destination_airport_codes.txt"
while IFS="" read -r origin || [ -n "$origin" ]
do
  while IFS="" read -r dest || [ -n "$dest" ]
  do
    if [[ -n "$origin" && -n "$dest" ]]
    then
      ./api.js $origin $dest > ./data/${origin}_${dest}.json
      echo "${origin}_${dest}.json done!"
      sleep 10
    fi
  done < $destinations
done < $origins

shutdown 0
