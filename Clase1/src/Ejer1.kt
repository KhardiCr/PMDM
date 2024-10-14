fun main(){
    /*
    1. Escribe un programa que pida al usuario dos números enteros y calcule su suma.
    */

    println("Ejercicio 1")

    //Se debe indicar EXPLICITAMENTE el tipo del retorno, si no siempre devuelve type "unit"
    //https://youtrack.jetbrains.com/issue/KT-59748/K2-Return-type-mismatch-expected-Unit-actual-Any-for-when-with-an-assignment-in-branch
    fun sumaEnteros(n1: Int, n2: Int): Int {
        var resultado: Int = n1 + n2
        return resultado
    }

    println("dame el primer número")
    var n1 = readln().toIntOrNull() ?: 0
    println("dame el segundo número")
    var n2 = readln().toIntOrNull() ?: 0

    println(sumaEnteros(n1,n2))
}