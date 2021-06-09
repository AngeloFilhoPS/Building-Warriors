package br.com.zup.iupp.controller

import br.com.zup.iupp.dto.NovaArmaRequest
import br.com.zup.iupp.service.armas.ArmasService
import br.com.zup.iupp.service.instrutor.InstrutorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post


@Controller("/armas")
class CadastroArmaController(private val armasService: ArmasService,private val instrutorService: InstrutorService) {

    @Post
    fun cadastra(@Body request: NovaArmaRequest):HttpResponse<Any>{

        val possivelInstrutor = instrutorService.buscaInstrutor(request.idInstrutor)
        if(possivelInstrutor){

            return HttpResponse.notFound()
        }

        val arma = request.toModel()
        armasService.cadastraArma(arma)

        return (HttpResponse.created(arma))
    }

}