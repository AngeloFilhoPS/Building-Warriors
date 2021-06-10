package br.com.zup.iupp.model

import io.micronaut.core.annotation.Introspected
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Introspected
class Arma (
    val nome:String,
    val calibre:String,
    val idInstrutor:Long,
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    val instrutor:Instrutor?=null
        ){
    @Id
    @GeneratedValue
    var id: Long? = null


}