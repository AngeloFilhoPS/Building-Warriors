package br.com.zup.iupp.repository

import br.com.zup.iupp.model.Instrutor
import java.util.*

interface InstrutorRepository  {

    fun salva(instrutor: Instrutor)
    fun listaTodos():List<Instrutor>
    fun deleteById(id:String)
    fun encontraPorId(id:String):Optional<Instrutor>
    fun atualiza(instrutor: Instrutor,id:UUID)

}