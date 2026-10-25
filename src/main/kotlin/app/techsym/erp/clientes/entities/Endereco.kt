package app.techsym.erp.clientes.entities

import app.techsym.erp.clientes.enums.Uf
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Embeddable
class Endereco (
    var cep: String,
    var numero: String,
    var rua: String,
    var bairro: String,
    @Enumerated(EnumType.STRING)
    var uf: Uf,
    var municipio: String,
    var complemento: String? = null
)