package br.com.zup.iupp.dto

import br.com.zup.iupp.model.Instrutor

data class NovoInstrutorResponse(
    val nome:String,
    val descricao:String,
    val numArmas:Int,
) {
    fun toResponse(instrutor: Instrutor):NovoInstrutorResponse{
        return (
                NovoInstrutorResponse(instrutor.nome,instrutor.descricao,instrutor.numArmas)
                )
    }
}
