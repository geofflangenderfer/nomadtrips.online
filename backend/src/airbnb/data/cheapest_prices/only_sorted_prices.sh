#!/usr/bin/env sh

for f in ls *json
do
  # grab only digits
  #grep -o "[0-9][0-9,][0-9]*" $f > $f.tmp
  #mv $f.tmp $f

  ## remove commas
  #sed -i 's/,//g' $f

  # sort
  #sort -n $f > $f.tmp
  #mv $f.tmp $f

  head -1 $f > $f.tmp
  mv $f.tmp $f
done
