#!/usr/bin/env sh

sum=0
count=0
while IFS= read -r line
do
  sum=$(echo "$(($sum + $line))")
  count=$(echo "$(($count + 1))")
done < miami_prices.txt
echo "$(($sum/$count))"
