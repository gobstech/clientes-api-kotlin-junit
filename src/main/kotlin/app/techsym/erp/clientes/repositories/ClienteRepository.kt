package app.techsym.erp.clientes.repositories

import app.techsym.erp.clientes.entities.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long> {

    fun existsByCpf(cpf: String): Boolean
    fun findByCodigo(Codigo: Long): Cliente?
}