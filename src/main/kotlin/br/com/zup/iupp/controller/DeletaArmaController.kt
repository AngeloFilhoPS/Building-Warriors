package br.com.zup.iupp.controller

import br.com.zup.iupp.service.armas.ArmasService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import javax.transaction.Transactional


@Controller("/armas/{id}")
class DeletaArmaController(val armasService: ArmasService) {

    @Delete
    @Transactional
    fun deleta(@PathVariable id:Long): HttpResponse<Any> {
        val possivelArma = armasService.buscaArma(id)

        if (possivelArma){
            armasService.deletaArma(id)
            return HttpResponse.ok()
        }
        return HttpResponse.notFound("Não existe tal arma para ser deletada")
    }

}