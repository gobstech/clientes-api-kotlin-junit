package app.techsym.erp.clientes

import app.techsym.erp.clientes.validation.isCpf
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CpfTest {

    @ParameterizedTest(name = "\"{0}\" deve ser válido")
    @ValueSource(strings = ["52998224725", "529.982.247-25"])
    fun `aceita CPF valido com e sem mascara`(cpf: String) {
        assertTrue(isCpf(cpf))
    }

    @Test
    fun `recusa texto vazio`() {
        assertFalse(isCpf(""))
    }

    @Test
    fun `recusa digito verificador errado`() {
        assertFalse(isCpf("52998224724"))
    }

    @Test
    fun `recusa digitos repetidos`() {
        assertFalse(isCpf("11111111111"))
    }

    @Test
    fun `recusa tamanho menor`() {
        assertFalse(isCpf("5299822472"))
    }

    @Test
    fun `recusa tamanho maior`() {
        assertFalse(isCpf("529982247250"))
    }

    @Test
    fun `recusa mascara fora do lugar`() {
        assertFalse(isCpf("529-982-247.25"))
    }

    @Test
    fun `recusa cpf com letras`() {
        assertFalse(isCpf("52998224725abc"))
    }

    @Test
    fun `recusa separador diferente de ponto`() {
        assertFalse(isCpf("529x982y247-25"))
    }
}