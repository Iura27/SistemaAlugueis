package br.upf.Aluguel.repository

import br.upf.Aluguel.model.Aluguel
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface AluguelRepository: JpaRepository<Aluguel, Long> {

    fun findByDataInicio(dataInicio: LocalDate, paginacao: org.springframework.data.domain.Pageable): Page<Aluguel>
    fun findAllBydataInicioIsNull(paginacao: org.springframework.data.domain.Pageable): Page<Aluguel>
}