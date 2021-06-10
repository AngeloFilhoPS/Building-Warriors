package br.com.zup.iupp.service.instrutor

import br.com.zup.iupp.dto.PatchInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import java.util.*
import javax.inject.Singleton

@Singleton
interface InstrutorService {

    fun listaTodos():List<Instrutor>
    fun cadastraInstrutor(instrutor: Instrutor)
    fun buscaInstrutor(id:Long): Boolean
    fun deletaInstrutor(id:Long)
    fun atualizaInstrutor(id:Long,patchInstrutorRequest: PatchInstrutorRequest)

}