package br.com.zup.iupp.controller

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.service.instrutor.InstrutorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import javax.transaction.Transactional

@Controller("/instrutores")
class InstrutorController(private val instrutorService: InstrutorService) {

    @Post
    fun cadastra(@Body request: NovoInstrutorRequest): HttpResponse<Any> {

        val instrutor = request.toModel()
        instrutorService.cadastraInstrutor(instrutor)

        return HttpResponse.created(request)

    }
    @Get
    fun lista():List<Instrutor>{
        return instrutorService.listaTodos()
    }


    @Delete("/{id}")
    @Transactional
    fun deleta(@PathVariable id: Long): HttpResponse<Any> {
        val possivelInstrutor = instrutorService.buscaInstrutor(id)


        if (possivelInstrutor) {
            instrutorService.deletaInstrutor(id)
            return HttpResponse.ok()
        }

        return HttpResponse.notFound()
    }

    @Patch("/{id}")
    @Transactional
    fun edita(@PathVariable id:Long, @Body request : NovoInstrutorRequest):HttpResponse<Any>{

        val possivelInstrutor =  instrutorService.buscaInstrutor(id)

        if(possivelInstrutor){
            instrutorService.atualizaInstrutor(id,request)
            return HttpResponse.ok(request)
        }

        return HttpResponse.notFound()
    }


}