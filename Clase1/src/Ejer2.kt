fun main() {
    /*
    2. Escribe un programa que pida el radio de un círculo y calcule su área. Utiliza la fórmula Área = π * radio^2.
    */

    println("Ejercicio 2")

    //Se debe indicar EXPLICITAMENTE el tipo del retorno, si no siempre devuelve type "unit"
    //https://youtrack.jetbrains.com/issue/KT-59748/K2-Return-type-mismatch-expected-Unit-actual-Any-for-when-with-an-assignment-in-branch

    fun calculoArea(radio: Double): Double {
        //su valor no cambia, se puede usar val en lugar de var.
        val resultado: Double = 3.14 * (radio * radio)
        return resultado
    }
    println("dame el radio del círculo")
    val radio = readln().toDoubleOrNull() ?: 0.0


    println(calculoArea(radio))
}