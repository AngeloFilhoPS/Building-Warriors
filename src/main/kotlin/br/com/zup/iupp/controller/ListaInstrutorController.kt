package br.com.zup.iupp.controller

import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.service.instrutor.InstrutorService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/instrutores")
class ListaInstrutorController(private val instrutorService: InstrutorService) {

    @Get
    fun lista():List<Instrutor>{
        return instrutorService.listaTodos()
    }


}