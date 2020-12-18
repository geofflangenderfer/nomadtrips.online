import com.amadeus.Amadeus
import com.amadeus.Params
import com.amadeus.exceptions.ResponseException
import com.amadeus.resources.FlightOfferSearch
import com.google.gson.Gson
import com.impossibl.postgres.jdbc.PGDriver.logger
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.`java-time`.datetime
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.system.exitProcess
//import kotlinx.serialization.*
//import kotlinx.serialization.json.JSON

val api_key="M5m0SbU7QA4lzpwxewk8eH4RVAkyBzaP"
val api_secret="ygRsTSJQxrTxo7If"


object Trips: IntIdTable() {
    val origin: Column<String> = varchar("origin",255)
    val destination: Column<String> = varchar("destination",255)
    val duration: Column<Float> = float("duration")
    val date: Column<String> = varchar("datetime", 255)
    //val date: Column<LocalDateTime> = datetime("datetime")
    val price: Column<Float> = float("price")
}

fun main() {

    Database.connect("jdbc:pgsql://localhost:5432/nomadtrips_online", driver = "com.impossibl.postgres.jdbc.PGDriver", user = "postgres", password = "postgres")
    //val trips_data_file = "/home/geofflangenderfer/work/nomadtrips.online/backend/src/amadeus/data/"
    //val trips_data_file = "/home/geofflangenderfer/work/nomadtrips.online/backend/src/amadeus/data/AMS_AUS.json"
    //var gson = Gson()
    //val trip: Trip = gson.fromJson(File(trips_data_file).readText(Charsets.UTF_8), Trip::class.java)
    //println("origin ${getOriginAndDest(File(trips_data_file))[0]}")
    //println("dest ${getOriginAndDest(File(trips_data_file))[1]}")
    //println("duration ${getDuration(trip)}")
    //println("date ${getDate(trip)}")
    //println("price ${getPrice(trip)}")
    var gson = Gson()
    val tripsDataFile = "/home/geofflangenderfer/work/nomadtrips.online/backend/src/amadeus/data/"
    transaction {
        create(Trips)
        File(tripsDataFile).walk().forEach {
            var origin_dest = getOriginAndDest(it)
            if (origin_dest.size != 1) {
                val trip: Trip = gson.fromJson(it.readText(Charsets.UTF_8), Trip::class.java)
                    Trips.insert { t ->
                        t[origin] = origin_dest[0]
                        t[destination] = origin_dest[1]
                        t[duration] = getDuration(trip)
                        t[date] = getDate(trip)
                        t[price] = getPrice(trip)
                        println("origin ${origin_dest[0]} dest ${origin_dest[1]}")

                }
            }
        }
    }



    //println("Trips: ${Trips.selectAll()}")

    //val amadeus = Amadeus
    //    .builder(api_key, api_secret)
    //    .build()
    //val flightOffersSearches: Array<FlightOfferSearch> = amadeus.shopping.flightOffersSearch[Params
    //    .with("originLocationCode", "CUN")
    //    .and("destinationLocationCode", "BKK")
    //    .and("departureDate", "2020-12-11")
    //    .and("adults", 1)
    //    .and("max", 1)]
    //if (flightOffersSearches[0].response.statusCode != 200) {
    //    println("Wrong status code: " + flightOffersSearches[0].response.statusCode)
    //    exitProcess(-1)
    //}
    //println("Momma, we did it")
    //println(flightOffersSearches[0])
}
fun getOriginAndDest(filename: File): List<String> {
    return filename
        .toString()
        .substring(filename.toString()
        .lastIndexOf('/') + 1)
        .split(".json")[0]
        .split("_")
}
fun getDuration(t: Trip): Float {
    var duration: String = t[0]
        .itineraries[0]
        .duration
    val digits = Regex("[0-9][0-9]*").find(duration)
    val hours = digits?.value?.toFloat() ?: 0f
    val minutes = digits?.next()?.value?.toFloat() ?: 0f
    println("hours $hours min $minutes")

    return hours + minutes / 60
}
fun getDate(t: Trip): String {
    return t[0].lastTicketingDate
}
fun getPrice(t: Trip): Float {
    return t[0].price.grandTotal.toFloat()
}