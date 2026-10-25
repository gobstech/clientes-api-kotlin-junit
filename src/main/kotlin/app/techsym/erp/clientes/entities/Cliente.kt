package app.techsym.erp.clientes.entities

import app.techsym.erp.clientes.enums.EstadoCivil
import app.techsym.erp.clientes.enums.Sexo
import app.techsym.erp.clientes.enums.TipoPessoa
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.Generated
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.OffsetDateTime

@Entity
@Table(name = "clientes")
class Cliente(
    var cpf: String,
    var nome: String,
    var dataNascimento: LocalDate,
    var rg: String? = null,
    var nacionalidade: String? = null,
    var orgaoEmissor: String? = null,
    var profissao: String? = null,
    var dataEmissaoRg: LocalDate? = null,
    @Enumerated(EnumType.STRING)
    var estadoCivil: EstadoCivil? = null,
    @Enumerated(EnumType.STRING)
    var tipoPessoa: TipoPessoa,
    @Enumerated(EnumType.STRING)
    var sexo: Sexo,
    @Embedded
    var endereco: Endereco
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Generated
    @Column(insertable = false, updatable = false)
    var codigo: Long? = null

    @CreationTimestamp
    var criadoEm: OffsetDateTime? = null

    @UpdateTimestamp
    var atualizadoEm: OffsetDateTime? = null
}