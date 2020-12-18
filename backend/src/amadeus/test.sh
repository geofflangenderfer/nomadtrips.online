origin='CUN'
dest='MDE'
./api.js $origin $dest > ./data/${origin}_${dest}.json
echo "${origin}_${dest}.json done!"
