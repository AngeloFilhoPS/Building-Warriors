package br.com.zup.iupp.service.instrutor

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import javax.inject.Singleton

@Singleton
interface InstrutorService {

    fun listaTodos():List<Instrutor>
    fun cadastraInstrutor(instrutor: Instrutor)
    fun buscaInstrutor(id:Long): Boolean
    fun deletaInstrutor(id:Long)
    fun atualizaInstrutor(id:Long,patchInstrutorRequest: NovoInstrutorRequest)

}