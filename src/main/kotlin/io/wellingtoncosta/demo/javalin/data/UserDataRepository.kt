package io.wellingtoncosta.demo.javalin.data

import io.wellingtoncosta.demo.javalin.domain.model.User
import io.wellingtoncosta.demo.javalin.domain.exception.UserNotFoundException
import io.wellingtoncosta.demo.javalin.domain.contract.UserRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

/**
 * @author Wellington Costa on 21/01/19
 */
class UserDataRepository(private val dataSource: DataSource) :
    UserRepository {

    init {
        transaction(Database.connect(dataSource)) {
            SchemaUtils.create(UserTable)
        }
    }

    private fun <T> transaction(body: () -> T) = transaction(Database.connect(dataSource)) { body() }

    override fun getAll() = transaction {
        UserTable.selectAll().map { it.toUserDomain() }
    }

    override fun getOne(id: Long) = transaction {
        UserTable.select { UserTable.id eq(id) }.map { it.toUserDomain() }.firstOrNull()
            ?: throw UserNotFoundException(id)
    }

    override fun create(user: User) = transaction {
        val userId = UserTable.insert {
            it[name] = user.name
            it[email] = user.email
            it[phone] = user.phone
        } get UserTable.id

        user.copy(id = userId)
    }

    override fun update(id: Long, user: User) = transaction {
        UserTable.update({ UserTable.id eq id }) {
            it[name] = user.name
            it[email] = user.email
            if(user.phone != null) {
                it[phone] = user.phone
            }
        }.let {
            UserTable.select { UserTable.id  eq id }.map { user -> user.toUserDomain() }.first()
        }
    }

    override fun delete(id: Long) = transaction {
        UserTable.deleteWhere { UserTable.id eq id }.let { Unit }
    }

}