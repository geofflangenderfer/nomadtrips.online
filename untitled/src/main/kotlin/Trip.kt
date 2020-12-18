class Trip : ArrayList<TripItem>()

data class TripItem(
    val id: String,
    val instantTicketingRequired: Boolean,
    val itineraries: List<Itinerary>,
    val lastTicketingDate: String,
    val nonHomogeneous: Boolean,
    val numberOfBookableSeats: Int,
    val oneWay: Boolean,
    val price: Price,
    val pricingOptions: PricingOptions,
    val source: String,
    val travelerPricings: List<TravelerPricing>,
    val type: String,
    val validatingAirlineCodes: List<String>
)

data class Itinerary(
    val duration: String,
    val segments: List<Segment>
)

data class Price(
    val base: String,
    val currency: String,
    val fees: List<Fee>,
    val grandTotal: String,
    val total: String
)

data class PricingOptions(
    val fareType: List<String>,
    val includedCheckedBagsOnly: Boolean
)

data class TravelerPricing(
    val fareDetailsBySegment: List<FareDetailsBySegment>,
    val fareOption: String,
    val price: PriceX,
    val travelerId: String,
    val travelerType: String
)

data class Segment(
    val aircraft: Aircraft,
    val arrival: Arrival,
    val blacklistedInEU: Boolean,
    val carrierCode: String,
    val departure: Departure,
    val duration: String,
    val id: String,
    val number: String,
    val numberOfStops: Int,
    val operating: Operating
)

data class Aircraft(
    val code: String
)

data class Arrival(
    val at: String,
    val iataCode: String,
    val terminal: String
)

data class Departure(
    val at: String,
    val iataCode: String,
    val terminal: String
)

data class Operating(
    val carrierCode: String
)

data class Fee(
    val amount: String,
    val type: String
)

data class FareDetailsBySegment(
    val brandedFare: String,
    val cabin: String,
    val `class`: String,
    val fareBasis: String,
    val includedCheckedBags: IncludedCheckedBags,
    val segmentId: String
)

data class PriceX(
    val base: String,
    val currency: String,
    val total: String
)

data class IncludedCheckedBags(
    val quantity: Int
)