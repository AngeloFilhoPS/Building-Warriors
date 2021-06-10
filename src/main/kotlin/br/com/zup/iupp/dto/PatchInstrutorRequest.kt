package br.com.zup.iupp.dto

import br.com.zup.iupp.model.Instrutor

data class PatchInstrutorRequest(
    val nome:String,
    val descricao:String,
    val numArmas:Int,
) {



}
