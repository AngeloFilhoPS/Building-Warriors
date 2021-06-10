package br.com.zup.iupp.model

import io.micronaut.core.annotation.Introspected
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@Introspected
class Instrutor(
    var nome:String,
    val cpf:String,
    var descricao:String,
    var numArmas:Int,
) {
    @Id
    @GeneratedValue
    var id: Long? = null

}