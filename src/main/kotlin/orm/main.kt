package orm

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


object Users : Table() {
    val id = varchar("id", 10).uniqueIndex()
    val name = varchar("name", length = 50)
    val cityId = (integer("city_id") references Cities.id).nullable()

    override val primaryKey = PrimaryKey(id, name = "PK_User_ID")
}

object Cities : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    override val primaryKey = PrimaryKey(id, name = "PK_Cities_ID")
}


fun main() {
    Database.connect(
        "jdbc:postgresql://localhost:5435/english_train",
        driver = "org.postgresql.Driver",
        user = "haxul",
        password = "testpassword"
    )


    transaction {
        SchemaUtils.create(Cities, Users)

        try {

            (Users innerJoin Cities).select { Users.id.eq("123123") }.forEach {
                println("${it[Users.name]} lives in ${it[Cities.name]}")
            }
        } catch (e: Exception) {
            println(e.message)
            rollback()
        }


    }


}