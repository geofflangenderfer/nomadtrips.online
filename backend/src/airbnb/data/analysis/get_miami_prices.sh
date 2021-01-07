#!/usr/bin/env sh

postgresDbLogin='postgresql://postgres:postgres@localhost:5432/nomadtrips_online'

psql -c "select destination, round(duration) as flight_duration, round(price + dest_airbnb) as flight_and_airbnb_price from trips where origin = '$1' order by flight_and_airbnb_price asc limit 10;" $postgresDbLogin
#  psql -c "update trips set dest_airbnb = '111' where destination = 'AUS';" 'postgresql://postgres:postgres@localhost:5432/nomadtrips_online'
