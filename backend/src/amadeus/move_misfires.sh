#!/usr/bin/env bash

for f in ls data/*
do
	lines=$(wc -l $f | sed 's/[^0-9]*//g')
	if [ $lines -lt "2" ]
	then
		#mv $f misfireTrips/
		echo $f
	fi
done

