fun main(){
    /*
    4. Escribe un programa que lea un número entero y determine si es par o impar (el if es igual que en Java)
    */

    println("Ejercicio 4")

    fun oddOrNot(n1: Int): Boolean {
        if (n1%2 == 0){
            return true
        } else{
            return false
        }
    }

    println("dame el primer número")
    var n1 = readln().toIntOrNull() ?: 0

    println(oddOrNot(n1))
}