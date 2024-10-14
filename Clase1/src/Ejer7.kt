fun main(){
    /*
    7. Escribe un programa que simule una calculadora básica. El programa debe pedir al usuario dos números y una operación (suma, resta, multiplicación, división) y mostrar el resultado.
    */

    println("Ejercicio 7")


    fun calculadora(n1: Double, n2: Double, operacion: Int): Double {

        when(operacion){
            1 -> {return n1 + n2}
            2 -> {return n1 - n2}
            3 -> {return n1 * n2}
            4 -> {return n1 / n2}
            else -> {
                println("no me has puesto una opción valida, así que lo he interpretado como suma.")
                return n1+n2 }
        }
    }

    println("dame el primer número")
    var n1 = readln().toDoubleOrNull() ?: 0.0
    println("dame el segundo número")
    var n2 = readln().toDoubleOrNull() ?: 0.0
    println("que operacion quieres hacer?" +
            "1 -- Suma" +
            "2 -- Resta " +
            "3 -- multiplicacion" +
            "4 -- division")
    var operacion = readln().toIntOrNull() ?: 0
    println(calculadora(n1,n2,operacion))
}