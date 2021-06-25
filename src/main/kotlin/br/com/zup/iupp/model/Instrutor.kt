package br.com.zup.iupp.model

import io.micronaut.core.annotation.Introspected

import java.util.*

@Introspected
data class Instrutor(
    var nome:String="",
    var cpf:String="",
    var descricao:String="",
    var numArmas:Int=0,
    var id: UUID? = null
) {


}