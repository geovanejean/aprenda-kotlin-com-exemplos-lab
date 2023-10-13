enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 120, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        for (u in usuarios) {
            inscritos.add(u)
            println("Usuário ${u.nome} adicionado")
        }
    }
}

fun main() {
    val joao = Usuario("Geovane")
    val maria = Usuario("Thiago")
    val marcos = Usuario("Jessica")

    val kotlin = ConteudoEducacional(nome = "Kotlin", nivel = Nivel.BASICO)
    val java = ConteudoEducacional("Java", 240, Nivel.INTERMEDIARIO)
    val android = ConteudoEducacional("Android", 300, Nivel.AVANCADO)

    val conteudos = listOf<ConteudoEducacional>(kotlin, java, android)

    val formacaoKotlin = Formacao("Formação Kotlin", conteudos, Nivel.INTERMEDIARIO)
    formacaoKotlin.matricular(joao, maria, marcos)

    println()
    println("Título: ${formacaoKotlin.nome} (Nível: ${formacaoKotlin.nivel})")
    println("Matriculados: ")
    for (u in formacaoKotlin.inscritos) println("${u.nome} ")
    println("Conteudos: ")
    for (c in formacaoKotlin.conteudos) println("${c.nome} (${c.duracao} minutos, Nível: ${c.nivel})")

}