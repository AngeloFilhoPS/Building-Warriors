package br.com.zup.iupp.services

import br.com.zup.iupp.controller.InstrutorController
import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.service.instrutor.InstrutorService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class InstrutorControllerCadastraTeste: AnnotationSpec(){

    val instrutorService = mockk<InstrutorService>(relaxed = true)

    val instrutorController = InstrutorController(instrutorService)


    @Test
    fun `espera receber e responder que o instrutor foi cadastrado`(){

        val request= NovoInstrutorRequest("Angelo","02315527360","top",1)
        val instrutor= request.toModel()
        val response = NovoInstrutorRequest(instrutor.nome,instrutor.cpf,instrutor.descricao,instrutor.numArmas)


        every { instrutorService.cadastraInstrutor(any()) } answers {}

        val result = instrutorController.cadastra(request)

        result.status shouldBe HttpStatus.CREATED
        result.body() shouldBe response

    }

    @Test
    fun `deve listar o instrutor que foi cadastrado`(){

        val request= NovoInstrutorRequest("Angelo","02315527360","top",1)
        val instrutor= request.toModel()
        val response = NovoInstrutorRequest(instrutor.nome,instrutor.cpf,instrutor.descricao,instrutor.numArmas)


        every { instrutorService.listaTodos() } answers { listOf(instrutor)}

        instrutorController.cadastra(response)

        val lista = instrutorController.lista()


        lista.size shouldBe 1

    }

    @Test
    fun `deve deletar o instrutor que foi cadastrado`(){

        val request= NovoInstrutorRequest("Angelo","02315527360","top",1)
        val instrutor= request.toModel()
        val response = NovoInstrutorRequest(instrutor.nome,instrutor.cpf,instrutor.descricao,instrutor.numArmas)


        every {
            instrutorService.deletaInstrutor(any())
        } answers {}


        val deletado = instrutor.id?.let { instrutorController.deleta(it.toString()) }


        if (deletado != null) {
            deletado.status shouldBe HttpStatus.OK
        }

    }

    @Test
    fun `deve editar um instrutor caso ele exista`(){

        val request= NovoInstrutorRequest("Angelo","02315527360","top",1)
        val instrutor= request.toModel()
        val response = NovoInstrutorRequest(instrutor.nome,instrutor.cpf,instrutor.descricao,instrutor.numArmas)

        var atualizado = NovoInstrutorRequest("Angelo","02313329240","top",2)


        every {
             instrutorService.atualizaInstrutor(any(),any())
        } answers {}

        val result  = instrutor.id?.let { instrutorController.edita(it.toString(),atualizado) }

        if (result != null) {
            result.status shouldBe HttpStatus.OK
        }
        if (result != null) {
            result.body() shouldBe atualizado
        }

    }










}

















//    fun InstrutorServiceTesteCadastro(instrutorService: InstrutorService){
//
//            val instrutor = Instrutor("Angelo","02316627260","muito top",1)
//            instrutorService.cadastraInstrutor(instrutor)
//            val list = instrutorService.listaTodos()
//            Assertions.assertEquals(1,list.size)
//    }
//
//    @Test
//    fun InstrutorServiceTesteBusca(instrutorService: InstrutorService){
//
//        val instrutor = Instrutor("Pedro","02316627261","muito gente fina",2)
//        instrutorService.cadastraInstrutor(instrutor)
//        val id = instrutor.id
//        val busca = id?.let { instrutorService.buscaInstrutor(it) }
//        Assertions.assertEquals(true,busca)
//    }
//
//    @Test
//    fun  InstrutorServiceTesteDeleta(instrutorService: InstrutorService){
//        val instrutor = Instrutor("Rafael","02316627263","muito brava",3)
//        instrutorService.cadastraInstrutor(instrutor)
//
//        instrutorService.deletaInstrutor(1)
//        val busca = instrutorService.listaTodos()
//
//        Assertions.assertEquals(0,busca.size)
//
//    }




//@TestInstance(TestInstance.Lifecycle.PE_CLASS)
//class InstrutorServiceTeste(
//    private val instrutorService: InstrutorService)
//
//
//
//
//
//
//
//trado deve ser igual") {
////            instrutorCadastrado shouldBe instrutorCadastrado
////        }
////
////) : BehaviorSpec({
////
////
////    given("cadastraTest") {
////        val instrutorCadastrado = instrutorService.cadastraInstrutor(
////            Instrutor(
////                nome = "Angelo",
////                cpf = "02315527261",
////                descricao = "top",
////                numArmas = 0
////            )
////        )
////        then("o instrutor cadas
////    }
//
//
//})