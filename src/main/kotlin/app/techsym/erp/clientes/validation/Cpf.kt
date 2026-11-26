package app.techsym.erp.clientes.validation
// este arquivo é uma variante que é equivalente ao cálculo tradicional dos dígitos verificadores
fun isCpf(document: String): Boolean {
    val formato = Regex("""[0-9]{3}\.[0-9]{3}\.[0-9]{3}-[0-9]{2}|[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}""")
    if (!formato.matches(document)) return false

    val numbers = document.filter { it.isDigit() }.map {
        it.digitToInt()
    }

    fun digito(resto: Int): Int {
        if (resto >= 10) return 0
        else return resto
    }

    if (numbers.all { it == numbers[0] }) return false

    val dv1 = (0..8).sumOf {
            posicao -> (posicao + 1) * numbers[posicao]
    }.rem(11).let {
            resto -> digito(resto)
    }

    val dv2 = (0..8).sumOf {
            posicao -> posicao * numbers[posicao]
    }.let {
            soma -> soma + dv1 * 9
    }.rem(11).let {
            resto -> digito(resto)
    }

    return numbers[9] == dv1 && numbers[10] == dv2
}