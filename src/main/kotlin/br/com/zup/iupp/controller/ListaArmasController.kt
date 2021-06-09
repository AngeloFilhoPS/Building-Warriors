package br.com.zup.iupp.controller

import br.com.zup.iupp.model.Arma
import br.com.zup.iupp.service.armas.ArmasService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/armas")
class ListaArmasController(private val armasService: ArmasService) {

    @Get
    fun lista():List<Arma>{
        return armasService.listaTodos()
    }


}