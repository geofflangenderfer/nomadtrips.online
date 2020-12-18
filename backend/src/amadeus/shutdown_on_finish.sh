#!/usr/bin/env bash

while true
do
  pgrep -f getAllTrips.sh && shutdown 0
  sleep 300
done

