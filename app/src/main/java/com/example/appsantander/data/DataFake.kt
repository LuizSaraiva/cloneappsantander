package com.example.appsantander.data

class DataFake {

    fun getData(): Conta {
        val cliente: Cliente = Cliente("Luiz")
        val cartao: Cartao = Cartao("5648616540044")
        return Conta(
            cliente,
            cartao, "2420-4",
            "456423",
            "R$ 4.056,00",
            "5.000,45"
        )
    }
}