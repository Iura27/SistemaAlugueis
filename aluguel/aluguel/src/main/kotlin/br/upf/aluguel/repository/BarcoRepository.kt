package br.upf.Aluguel.repository

import br.upf.Aluguel.model.Barcos
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BarcoRepository: JpaRepository<Barcos, Long> {

    fun findByMarca(marca: String, paginacao: Pageable): Page<Barcos>
}
