package br.upf.sistemaeventos.exceptions

class NotFoundException(override val message: String)
    : RuntimeException()