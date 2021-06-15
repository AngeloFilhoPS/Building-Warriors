package br.com.zup.iupp.dto

import br.com.zup.iupp.model.Instrutor

data class NovoInstrutorRequest(
    val nome:String,
    val cpf:String,
    val descricao:String,
    val numArmas:Int,
) {

    fun toModel():Instrutor{
        return Instrutor(nome, cpf, descricao,numArmas)
    }


}
