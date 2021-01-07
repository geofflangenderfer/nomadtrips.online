#!/usr/bin/env sh

postgresDbLogin='postgresql://postgres:postgres@localhost:5432/nomadtrips_online'

while IFS=, read -r dest price
do 
  #echo "The 1st field is $dest, the 2nd $price"  
  #command="update trips set dest_airbnb = '$price' where destination = '$dest';"
  #echo $command $postgresDbLogin
  psql -c "update trips set dest_airbnb = '$price' where destination = '$dest';" $postgresDbLogin
done < cheapest_prices.csv
#for f in ls *json
#do
#
#done
  
#  psql -c "update trips set dest_airbnb = '111' where destination = 'AUS';" 'postgresql://postgres:postgres@localhost:5432/nomadtrips_online'
