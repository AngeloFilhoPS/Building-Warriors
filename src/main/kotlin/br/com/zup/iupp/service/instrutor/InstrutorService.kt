package br.com.zup.iupp.service.instrutor

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import java.util.*
import javax.inject.Singleton

@Singleton
interface InstrutorService {

    fun listaTodos():List<Instrutor>
    fun cadastraInstrutor(instrutor: Instrutor)
    fun buscaInstrutor(id: String): Optional<Instrutor>
    fun deletaInstrutor(id:String)
    fun atualizaInstrutor(id:String,patchInstrutorRequest: NovoInstrutorRequest)

}