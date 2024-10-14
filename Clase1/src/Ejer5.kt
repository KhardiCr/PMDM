fun main(){
    /*
    5. Escribe un programa que lea dos números enteros y determine cuál es mayor.
    */

    println("Ejercicio 5")


    fun returnMayor(n1: Int, n2: Int): Int {
        if (n1 > n2 ){
            return n1
        }else{
            return n2
        }
    }

    println("dame el primer número")
    var n1 = readln().toIntOrNull() ?: 0
    println("dame el segundo número")
    var n2 = readln().toIntOrNull() ?: 0

    println(returnMayor(n1,n2))
}