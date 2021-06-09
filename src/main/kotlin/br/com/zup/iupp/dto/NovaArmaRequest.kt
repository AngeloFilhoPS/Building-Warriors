package br.com.zup.iupp.dto

import br.com.zup.iupp.model.Arma

class NovaArmaRequest(
    val nome:String,
    val calibre:String,
    val idInstrutor:Long
) {
    fun toModel(): Arma {
        return Arma(nome,calibre,idInstrutor)
    }

}
