package br.com.zup.iupp.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@Introspected
class Instrutor(
    val nome:String,
    val cpf:String,
    val descricao:String,
    val numArmas:Int,
) {
    @Id
    @GeneratedValue
    var id: Long? = null

}