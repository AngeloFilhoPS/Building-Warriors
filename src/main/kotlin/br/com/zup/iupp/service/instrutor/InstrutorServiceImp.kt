package br.com.zup.iupp.service.instrutor

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.repository.InstrutorRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class InstrutorServiceImp (
    private val instrutorRepository: InstrutorRepository,
) : InstrutorService {


    override fun listaTodos(): List<Instrutor> {
        return instrutorRepository.listaTodos()
    }

    override fun cadastraInstrutor(instrutor: Instrutor) {
        instrutorRepository.salva(instrutor)

//         instrutorRepository.save(instrutor)
    }

    override fun buscaInstrutor(id: String): Optional<Instrutor> {
        return instrutorRepository.encontraPorId(id)
    }

    override fun deletaInstrutor(id: String) {

        instrutorRepository.deleteById(id)
    }

    override fun atualizaInstrutor(id: String,patchInstrutorRequest: NovoInstrutorRequest) {


        var instrutorAtualizado = instrutorRepository.encontraPorId(id).get()
        val id = UUID.fromString(id)


        instrutorAtualizado.nome=patchInstrutorRequest.nome
        instrutorAtualizado.descricao=patchInstrutorRequest.descricao
        instrutorAtualizado.cpf=patchInstrutorRequest.cpf
        instrutorAtualizado.numArmas=patchInstrutorRequest.numArmas

        instrutorRepository.atualiza(instrutorAtualizado,id)

    }
}