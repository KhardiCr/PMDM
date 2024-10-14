fun main(){
    /*
    3. Escribe un programa que convierta grados Celsius a Fahrenheit. Usa la fórmula: F = C * 9/5 + 32.
    */

    println("Ejercicio 3")


    fun convertirCenF(c: Double): Double {
        var resultado: Double = (c * (9/5)) + 32
        return resultado
    }

    println("A cuantos grados Centigrados estamos?")
    var n1 = readln().toDoubleOrNull() ?: 0.0

    println(convertirCenF(n1))
}