package br.com.zup.iupp.repository

import br.com.zup.iupp.model.Instrutor
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.AsyncCqlSession
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import javax.inject.Singleton

@Singleton
class InstrutorRepositoryImp(private val cqlSession: CqlSession):InstrutorRepository {
    override fun salva(instrutor: Instrutor) {
    instrutor.id= UUID.randomUUID()
        cqlSession.execute(
            SimpleStatement.newInstance(
            "INSERT INTO instrutores(id, nome, cpf, descricao, numArmas) VALUES (?,?,?,?,?)",
            instrutor.id,
            instrutor.nome,
            instrutor.cpf,
            instrutor.descricao,
            instrutor.numArmas))
    }

    override fun listaTodos(): List<Instrutor> {

        val result = cqlSession.execute(SimpleStatement.newInstance("SELECT * FROM instrutores"))
        return result.all().stream().map(this::mapToInstrutor).collect(Collectors.toList())

    }

    private fun mapToInstrutor(row: Row): Instrutor {
        return Instrutor(
            id = row.getUuid("id"),
            nome = row.getString("nome")!!,
            cpf = row.getString("cpf")!!,
            descricao = row.getString("descricao")!!,
            numArmas = row.getInt("numArmas")
        )
    }

    override fun deleteById(id: String) {

        val idDeleta = UUID.fromString(id)

        cqlSession.execute(SimpleStatement.newInstance("DELETE from instrutores where id = ?", idDeleta))

    }

    override fun encontraPorId(id: String): Optional<Instrutor> {
        val idProcura = UUID.fromString(id)


        return Optional.ofNullable(
            cqlSession.execute(SimpleStatement.newInstance("SELECT * FROM instrutores WHERE id = ?", idProcura)).one()
        ).map(this::mapToInstrutor)
    }

    override fun  atualiza(instrutor: Instrutor,id: UUID) {

        cqlSession.execute(SimpleStatement.newInstance("UPDATE instrutores SET nome = ?, cpf = ?, descricao = ?, numarmas = ?  WHERE id = ?",
            instrutor.nome,
            instrutor.cpf,
            instrutor.descricao,
            instrutor.numArmas,
            id))


    }
}