awk -F '","'  'BEGIN {OFS=","} { if $1 > 1 print}' stats.csv > destinations.txt

