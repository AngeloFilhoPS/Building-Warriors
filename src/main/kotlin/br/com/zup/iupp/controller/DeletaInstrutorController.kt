package br.com.zup.iupp.controller

import br.com.zup.iupp.service.instrutor.InstrutorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import javax.transaction.Transactional

@Controller("/instrutores/{id}")
class DeletaInstrutorController(val instrutorService: InstrutorService) {

    @Delete
    @Transactional
    fun deleta(@PathVariable id: Long): HttpResponse<Any> {
        val possivelInstrutor = instrutorService.buscaInstrutor(id)


        if (possivelInstrutor) {
            instrutorService.deletaInstrutor(id)
            return HttpResponse.ok()
        }

        return HttpResponse.notFound()
    }

}