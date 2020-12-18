import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.`java-time`.datetime
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal
import java.time.LocalDateTime

//import org.postgresql.Driver

// https://github.com/JetBrains/Exposed/wiki/Transactions
// https://www.youtube.com/watch?v=Ph9RYiQGodY&t=32s&ab_channel=CleanCodeCast


object Users: Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name",255)
    val age: Column<Int> = integer("age")

    override val primaryKey = PrimaryKey(id, name="PK_User_ID")
}

object StarWarsFilms : IntIdTable() {
    val sequelId = integer("sequel_id").uniqueIndex()
    val name = varchar("name", 50)
    val director = varchar("director", 50)
}
fun main() {
    //Database.connect("jdbc:postgresql://localhost:5432/test", driver = "org.postgresql.Driver", user = "postgres", password = "postgres")
    Database.connect("jdbc:pgsql://localhost:5432/test", driver = "com.impossibl.postgres.jdbc.PGDriver", user = "postgres", password = "postgres")

    transaction {
        // print sql to std-out
        addLogger(StdOutSqlLogger)

        SchemaUtils.create(Users)
        transaction {
            Users.insert {
                it[name] = "cunty"
                it[age] = 22
            }
            Users.insert {
                it[name] = "cuntyMcCakes"
                it[age] = 32
            }
            Users.insert {
                it[name] = "cuntyCakes"
                it[age] = 42
            }
        }
        println("Users: ${Users.selectAll()}")


    }
}

object Cities: IntIdTable() {
    val name = varchar("name", 50)
}