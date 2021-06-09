package br.com.zup.iupp.service.instrutor

import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.repository.InstrutorRepository
import java.util.*
import javax.inject.Inject


class InstrutorServiceImp(
    @Inject
    private val instrutorRepository: InstrutorRepository
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
}