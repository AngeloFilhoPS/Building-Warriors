package br.com.zup.iupp.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Entity
@Introspected
class Arma (
    val nome:String,
    val calibre:String,
    val idInstrutor:Long
        ){
    @Id
    @GeneratedValue
    var id: Long? = null

    @ManyToOne
    val instrutor:Instrutor?=null
}