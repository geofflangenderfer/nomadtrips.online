let has_dups = [
  "ATL",
  "PEK",
  "LAX",
  "DXB",
  "HND",
  "ORD",
  "LHR",
  "PVG",
  "CDG",
  "DFW",
  "CAN",
  "AMS",
  "HKG",
  "ICN",
  "FRA",
  "DEN",
  "DEL",
  "SIN",
  "BKK",
  "JFK",
  "KUL",
  "MAD",
  "SFO",
  "CTU",
  "CGK",
  "SZX",
  "BCN",
  "IST",
  "SEA",
  "LAS",
  "ATL",
  "LAX",
  "ORD",
  "DFW",
  "DEN",
  "JFK",
  "SFO",
  "SEA",
  "LAS",
  "MCO",
  "EWR",
  "CLT",
  "PHX",
  "IAH",
  "MIA",
  "BOS",
  "MSP",
  "FLL",
  "DTW",
  "PHL",
  "LGA",
  "BWI",
  "SLC",
  "SAN",
  "IAD"
]

let cities = []

for (city of has_dups) {
  if (!cities.includes(city)) {cities.push(city)}
}
console.log(cities)