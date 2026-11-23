package app.techsym.erp.clientes.validation
fun isCpf(document: String): Boolean {
    val formato = Regex("""[0-9]{3}\.[0-9]{3}\.[0-9]{3}-[0-9]{2}|[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}""")
    if (!formato.matches(document)) return false

    val numbers = document.filter { it.isDigit() }.map {
        it.digitToInt()
    }

    if (numbers.size != 11) return false

    //repeticao
    if (numbers.all { it == numbers[0] }) return false

    //digito 1
    val dv1 = ((0..8).sumOf { (it + 1) * numbers[it] }).rem(11).let {
        if (it >= 10) 0 else it
    }

    val dv2 = ((0..8).sumOf { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
        if (it >= 10) 0 else it
    }

    return numbers[9] == dv1 && numbers[10] == dv2
}