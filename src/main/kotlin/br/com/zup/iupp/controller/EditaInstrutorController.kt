package br.com.zup.iupp.controller

import br.com.zup.iupp.dto.PatchInstrutorRequest
import br.com.zup.iupp.service.instrutor.InstrutorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Patch
import io.micronaut.http.annotation.PathVariable
import javax.transaction.Transactional


@Controller("/instrutores/{id}")
class EditaInstrutorController(private val instrutorService: InstrutorService) {

    @Patch
    @Transactional
    fun edita(@PathVariable id:Long, @Body request : PatchInstrutorRequest):HttpResponse<Any>{

        val possivelInstrutor =  instrutorService.buscaInstrutor(id)

        if(possivelInstrutor){
            instrutorService.atualizaInstrutor(id,request)
            return HttpResponse.ok(request)
        }

        return HttpResponse.notFound()
    }

}