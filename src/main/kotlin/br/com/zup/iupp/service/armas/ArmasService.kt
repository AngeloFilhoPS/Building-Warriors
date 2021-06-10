package br.com.zup.iupp.service.armas

import br.com.zup.iupp.model.Arma
import br.com.zup.iupp.model.Instrutor
import java.util.*
import javax.inject.Singleton

@Singleton
interface ArmasService {


    fun buscaArma(id:Long):Boolean
    fun listaTodos():List<Arma>
    fun cadastraArma(arma: Arma)
    fun deletaArma(id: Long)

}