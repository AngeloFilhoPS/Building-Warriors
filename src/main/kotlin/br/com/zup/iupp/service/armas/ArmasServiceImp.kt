package br.com.zup.iupp.service.armas

import br.com.zup.iupp.model.Arma
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.repository.ArmasRepository
import br.com.zup.iupp.repository.InstrutorRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArmaServiceImp(
    private val armasRepository: ArmasRepository,
    private val instrutorRepository: InstrutorRepository
) : ArmasService {


    override fun listaTodos(): List<Arma> {
        return armasRepository.findAll()
    }

    override fun cadastraArma(arma: Arma) {

        val possivelInstrutor = instrutorRepository.findById(arma.idInstrutor)

        if (possivelInstrutor.isPresent){
            val armaComInstrutor = Arma(arma.nome,arma.calibre,arma.idInstrutor,possivelInstrutor.get())
            armasRepository.save(armaComInstrutor)
        }

    }

    override fun buscaArma(id: Long): Boolean {
        return armasRepository.existsById(id)
    }

    override fun deletaArma(id: Long) {
        armasRepository.deleteById(id)
    }
}