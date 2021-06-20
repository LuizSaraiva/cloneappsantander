package com.example.appsantander.data

data class Conta(
    val cliente: Cliente,
    val cartao: Cartao,
    val agencia: String,
    val conta: String,
    val saldo: String,
    val limite: String
)