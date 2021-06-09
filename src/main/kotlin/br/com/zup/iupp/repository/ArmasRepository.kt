package br.com.zup.iupp.repository

import br.com.zup.iupp.model.Arma
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository


@Repository
interface ArmasRepository:JpaRepository<Arma,Long> {
}