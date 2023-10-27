package br.upf.Aluguel.repository

import br.upf.Aluguel.model.Cliente
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Long> {
    fun findByNome(nome: String, paginacao: Pageable): Page<Cliente>


}