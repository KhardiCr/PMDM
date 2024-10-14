fun main(){
    /*
    6. Escribe un programa que calcule el factorial de un número ingresado por el usuario.
    */

    println("Ejercicio 1")

    fun calculoFactorial(n1: Int): Int {
        var factorial: Int = 1
        for (i in 1..n1){
            factorial=factorial*i
        }
        return factorial
    }

    println("dame un entero")
    var n1 = readln().toIntOrNull() ?: 1

    println(calculoFactorial(n1))
}