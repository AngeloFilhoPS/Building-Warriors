package br.com.zup.iupp.services

import br.com.zup.iupp.dto.NovoInstrutorRequest
import br.com.zup.iupp.model.Instrutor
import br.com.zup.iupp.repository.InstrutorRepository
import br.com.zup.iupp.service.instrutor.InstrutorServiceImp
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class InstrutorServiceTest:AnnotationSpec() {

val instrutorRepository= mockk<InstrutorRepository>(relaxed = true)
val instrutorService = InstrutorServiceImp(instrutorRepository)



    lateinit var instrutor: Instrutor
    lateinit var instrutorAtualizado:NovoInstrutorRequest

    @BeforeEach
    fun setup(){
        instrutor= Instrutor("Angelo","02313329240","top",1, UUID.randomUUID())
        instrutorAtualizado= NovoInstrutorRequest("Angelo 2","02313329233","top",1)
    }


    @Test
    fun `deve testar cadastro`(){

        every { instrutorRepository.salva(any()) } answers {instrutor}

       val result = instrutorService.cadastraInstrutor(instrutor)
       result shouldBe Unit
    }


    @Test
    fun `deve testar listagem`(){

        every { instrutorRepository.listaTodos() } answers { listOf(instrutor)}

        val result = instrutorService.listaTodos()

        result.size shouldBe 1
        result[0] shouldBe instrutor

    }


    @Test
    fun `deve testar busca`(){
        every { instrutorRepository.encontraPorId(any()) } answers { Optional.of(Instrutor())}

        var result = instrutor.id?.let { instrutorService.buscaInstrutor(it.toString()) }

        result shouldBe true

    }


    @Test
    fun `deve testar delecao`(){
        every { instrutorRepository.deleteById(any()) } answers {}

        var result = instrutor.id?.let { instrutorService.deletaInstrutor(it.toString()) }

        result shouldBe Unit
    }


    @Test
    fun `deve testar atualizacao`(){

        every { instrutorRepository.atualiza(any(),any()) } answers {}
        every { instrutorRepository.encontraPorId(any()).get() } answers {instrutor}

        var result= instrutor.id?.let { instrutorService.atualizaInstrutor(it.toString(),instrutorAtualizado) }

        result shouldBe Unit
    }



}