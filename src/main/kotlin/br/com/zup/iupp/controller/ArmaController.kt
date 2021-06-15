package br.com.zup.iupp.controller

import br.com.zup.iupp.dto.NovaArmaRequest
import br.com.zup.iupp.model.Arma
import br.com.zup.iupp.service.armas.ArmasService
import br.com.zup.iupp.service.instrutor.InstrutorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.transaction.Transactional

@Transactional
@Controller("/armas")
class ArmaController(private val armasService: ArmasService, private val instrutorService: InstrutorService) {

    @Post
    fun cadastra(@Body request: NovaArmaRequest):HttpResponse<Any>{

        val possivelInstrutor = instrutorService.buscaInstrutor(request.idInstrutor)

        if(possivelInstrutor){
            val arma = request.toModel()
            armasService.cadastraArma(arma)
            return (HttpResponse.created(arma))

        }

        return HttpResponse.notFound()

    }

    @Get
    fun lista():List<Arma>{
        return armasService.listaTodos()
    }

}