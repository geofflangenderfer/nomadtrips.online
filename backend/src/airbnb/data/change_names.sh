#!/usr/bin/env sh

for f in ls *
do
	mv $f "$(echo $f | sed 's/"//g')"

done
