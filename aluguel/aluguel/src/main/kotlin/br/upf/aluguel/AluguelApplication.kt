package br.upf.aluguel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AluguelApplication

fun main(args: Array<String>) {
	runApplication<AluguelApplication>(*args)
}
