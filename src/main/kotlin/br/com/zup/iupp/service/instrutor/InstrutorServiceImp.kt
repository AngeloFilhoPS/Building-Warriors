package br.com.zup.iupp.service.instrutor

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.repository.ArmasRepository
import br.com.zup.iupp.repository.InstrutorRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InstrutorServiceImp (
    @Inject
    private val instrutorRepository: InstrutorRepository,
    @Inject val armasRepository: ArmasRepository
) : InstrutorService {


    override fun listaTodos(): List<Instrutor> {
        return instrutorRepository.findAll()
    }

    override fun cadastraInstrutor(instrutor: Instrutor) {
         instrutorRepository.save(instrutor)
    }

    override fun buscaInstrutor(id: Long): Boolean {
        return instrutorRepository.existsById(id)
    }

    override fun deletaInstrutor(id: Long) {

        instrutorRepository.deleteById(id)
    }

    override fun atualizaInstrutor(id: Long,patchInstrutorRequest: NovoInstrutorRequest) {
        val instrutorAtualizado = instrutorRepository.findById(id).get()

        instrutorAtualizado.nome=patchInstrutorRequest.nome
        instrutorAtualizado.descricao=patchInstrutorRequest.descricao
        instrutorAtualizado.numArmas=patchInstrutorRequest.numArmas

        instrutorRepository.update(instrutorAtualizado)

    }
}