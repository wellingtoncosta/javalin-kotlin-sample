package io.wellingtoncosta.demo.javalin.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

/**
 * @author Wellington Costa on 23/01/19
 */

const val jdbcUrl = "jdbc:postgresql://localhost:5432/usersdb"
const val jdbcDriver = "org.postgresql.Driver"
const val dbUsername = "postgres"
const val dbPassword = "postgres"

class DatabaseConfig(jdbcUrl: String, driverClassName: String, username: String, password: String) {

    val dataSource: DataSource

    init {
        dataSource = HikariConfig().let { config ->
            config.jdbcUrl = jdbcUrl
            config.username = username
            config.password = password
            config.driverClassName = driverClassName
            HikariDataSource(config)
        }
    }

}