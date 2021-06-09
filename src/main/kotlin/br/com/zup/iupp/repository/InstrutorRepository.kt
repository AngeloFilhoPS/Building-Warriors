package br.com.zup.iupp.repository

import br.com.zup.iupp.model.Instrutor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface InstrutorRepository : JpaRepository<Instrutor,Long> {
    override fun existsById(id:Long): Boolean
}