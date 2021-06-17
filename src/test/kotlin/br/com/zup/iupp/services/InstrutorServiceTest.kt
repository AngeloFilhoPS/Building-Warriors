package br.com.zup.iupp.services

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.repository.InstrutorRepository
import br.com.zup.iupp.service.instrutor.InstrutorService
import br.com.zup.iupp.service.instrutor.InstrutorServiceImp
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class InstrutorServiceTest:AnnotationSpec() {

val instrutorRepository= mockk<InstrutorRepository>(relaxed = true)
val instrutorService = InstrutorServiceImp(instrutorRepository)



    lateinit var instrutor: Instrutor
    lateinit var instrutorAtualizado:NovoInstrutorRequest

    @BeforeEach
    fun setup(){
        instrutor= Instrutor("Angelo","02313329240","top",1,1)
        instrutorAtualizado= NovoInstrutorRequest("Angelo 2","02313329233","top",1)
    }


    @Test
    fun `deve testar cadastro`(){

        every { instrutorRepository.save(any()) } answers {instrutor}

       val result = instrutorService.cadastraInstrutor(instrutor)
       result shouldBe Unit
    }


    @Test
    fun `deve testar listagem`(){

        every { instrutorRepository.findAll() } answers { listOf(instrutor)}

        val result = instrutorService.listaTodos()

        result.size shouldBe 1
        result[0] shouldBe instrutor

    }


    @Test
    fun `deve testar busca`(){
        every { instrutorRepository.existsById(any()) } answers {true}

        var result = instrutor.id?.let { instrutorService.buscaInstrutor(it) }

        result shouldBe true

    }


    @Test
    fun `deve testar delecao`(){
        every { instrutorRepository.deleteById(any()) } answers {}

        var result = instrutor.id?.let { instrutorService.deletaInstrutor(it) }

        result shouldBe Unit
    }


    @Test
    fun `deve testar atualizacao`(){

        every { instrutorRepository.update(any()) } answers {instrutor}
        every { instrutorRepository.findById(any()).get() } answers {instrutor}

        var result= instrutor.id?.let { instrutorService.atualizaInstrutor(it,instrutorAtualizado) }

        result shouldBe Unit
    }



}