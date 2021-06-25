//package br.com.zup.iupp.controllers
//
//import br.com.zup.iupp.controller.ArmaController
//import br.com.zup.iupp.dto.NovaArmaRequest
//import br.com.zup.iupp.model.Instrutor
//import br.com.zup.iupp.service.armas.ArmasService
//import br.com.zup.iupp.service.instrutor.InstrutorService
//import io.kotest.core.spec.style.AnnotationSpec
//import io.micronaut.http.HttpStatus
//import io.micronaut.test.extensions.kotest.annotation.MicronautTest
//import io.mockk.every
//import io.mockk.mockk
//import java.util.*
//
//@MicronautTest
//class ArmaControllerTeste:AnnotationSpec() {
//
//    val armasService = mockk<ArmasService>(relaxed = true)
//    val instrutorService= mockk<InstrutorService>(relaxed = true)
//    val armasController = ArmaController(armasService,instrutorService)
//
//
//    @Test
//    fun `deve testar cadastro de arma`(){
//
//        val request = NovaArmaRequest("Escopeta CBC","12",1)
//        val arma= request.toModel()
//
//        every { armasService.cadastraArma(any()) } answers {}
//        every { instrutorService.buscaInstrutor(any())} answers { Optional.of(Instrutor())}
//
//        val result = armasController.cadastra(request)
//
//        result.status shouldBe HttpStatus.CREATED
//        result.body() shouldBe arma
//
//    }
//
//    @Test
//    fun`deve testar listagem de armas`(){
//
//        val request = NovaArmaRequest("Escopeta CBC","12",1)
//        val arma= request.toModel()
//
//
//        every { armasService.listaTodos() } answers { listOf(arma)}
//        every { instrutorService.buscaInstrutor(any())} answers {true}
//
//        armasController.cadastra(request)
//
//        val listaArmas = armasController.lista()
//
//        listaArmas.size shouldBe 1
//
//    }
//
//}