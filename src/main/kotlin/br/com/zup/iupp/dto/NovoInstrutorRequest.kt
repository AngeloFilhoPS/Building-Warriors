package br.com.zup.iupp.dto

import br.com.zup.iupp.model.Instrutor

data class NovoInstrutorRequest(
    var nome:String,
    var cpf:String,
    var descricao:String,
    var numArmas:Int,
) {

    fun toModel():Instrutor{
        return Instrutor(nome, cpf, descricao,numArmas)
    }


}
