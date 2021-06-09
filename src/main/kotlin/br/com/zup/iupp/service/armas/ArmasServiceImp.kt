package br.com.zup.iupp.service.armas

import br.com.zup.iupp.model.Arma
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.repository.ArmasRepository
import br.com.zup.iupp.repository.InstrutorRepository
import javax.inject.Inject


class ArmaServiceImp(
    @Inject
    private val armasRepository: ArmasRepository
) : ArmasService {


    override fun listaTodos(): List<Arma> {
        return armasRepository.findAll()
    }

    override fun cadastraArma(arma: Arma) {
        armasRepository.save(arma)

    }

}