package br.com.zup.iupp.controller

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.dto.NovoInstrutorResponse
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.service.instrutor.InstrutorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/instrutores")
class CadastroInstrutorController(private val instrutorService: InstrutorService) {

    @Post
    fun cadastra(@Body request: NovoInstrutorRequest): HttpResponse<Any> {

        val instrutor = request.toModel()
        instrutorService.cadastraInstrutor(instrutor)


        val reponse = NovoInstrutorResponse(instrutor.nome,instrutor.descricao,instrutor.numArmas)

        return HttpResponse.created(reponse)

    }


}