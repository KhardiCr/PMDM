fun main(){
    /*
    8. Escribe un programa que determine si un número ingresado por el usuario es primo
    */

    println("Ejercicio 8")

    //Este for debe usar until en lugar de .. por que así no se incluye n1 en el recorrido.
    fun nPrimos(n1: Int): Boolean {
        for (i in 2 until n1) {
            if (n1%i == 0) {
                return false
            }
        }
        return true
    }

    println("dame el número")
    var n1 = readln().toIntOrNull() ?: 1

    println(nPrimos(n1))
}