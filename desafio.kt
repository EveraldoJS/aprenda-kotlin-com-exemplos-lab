// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuarios: List<Usuario>) {
        for(usuario in usuarios) {
            inscritos.add(usuario)
        }
  
    }

	fun duracaoTotal(): Int{
        var horas: Int = 0
        for(conteudo in conteudos) {
            horas += conteudo.duracao
        }
        return horas
    }  
    
    fun conteudos() {
        for(conteudo in conteudos){
            println("${conteudo.nome} - ${conteudo.duracao}h")
        }
    }
    
    fun exibirInscritos(){
        for(inscrito in inscritos) {
            println("${inscrito.nome}")
        }
    }
    }

fun main() {
   // TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
   // TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão."
        teste()
}

fun teste(){
    val julio = Usuario("Julio")
    val lidiane = Usuario("Lidiane")
    val rosana = Usuario("Rosana")
	val rodrigo = Usuario("Rodrigo")

    
    val listaConteudoPython: List<ConteudoEducacional> = listOf(
    	ConteudoEducacional("Introdução a Liguagem",12),
        ConteudoEducacional("Python entendendo a Orientação Objetos",12),
        ConteudoEducacional("Python datetime: Lidamdo com datas e horários",8))
           
    val cursoPython = Formacao("Curso Python",listaConteudoPython, Nivel.INTERMEDIARIO)

    val listaConteudoHTML: List<ConteudoEducacional> = listOf(
    	ConteudoEducacional("Introdução HTML",1),
        ConteudoEducacional("Preparando o Ambiente",1),
        ConteudoEducacional("A função do HTML e seus elementos",2),
        ConteudoEducacional("Elementos estruturais",3),
        ConteudoEducacional("Texto e formatação",2))
    
    val cursoHTML = Formacao("Curso HTML",listaConteudoHTML, Nivel.BASICO)
    
    	cursoHTML.let{
        cursoHTML.matricular(listOf(julio, lidiane, rosana, rodrigo))
    }
    	cursoPython.let{
        cursoPython.matricular(listOf(lidiane, rosana))
            }
    println("\nFormação: ${cursoHTML.nome} - ${cursoHTML.duracaoTotal()} horas duração")
    
    println("\nConteúdos:")
    cursoHTML.conteudos()
    
    println("\nInscritos:")
    cursoPython.exibirInscritos()
    
    
    println("\nFormação: ${cursoPython.nome} - ${cursoPython.duracaoTotal()} horas duração")
    
    println("\nConteúdos:")
    cursoPython.conteudos()
    
    println("\nInscritos:")
    cursoPython.exibirInscritos()
       
}
