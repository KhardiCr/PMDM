fun main(){
    /*
    9. Escribe un programa que maneje información de usuarios, donde algunos campos pueden ser opcionales (es decir, pueden ser null).
    En el programa, ni el apellido ni la edad pueden ser null. Si no se proporciona la edad,
    debes manejar un valor por defecto. Crear una función que reciba el nombre, apellido y edad y devuelva un mensaje con la información completa del usuario.
    Maneja de forma segura los posibles nulos
    */

    println("Ejercicio 9")

    fun toString(nombre: String?, apellido: String, edad: Int): String {
        var resultado = "te llamas $nombre $apellido y tienes $edad años"
        return resultado
    }

    //var nombre: String = "Pepe"
    //println("Por los designios del enunciado, te llamarás ¡$nombre!, pero....")

    var nombre: String? = "null"
    println("dime tu apellido")
    var apellido: String = readln().toString()

    println("dime tu edad, o no.. quien sabe.")
    var edad = readln().toIntOrNull() ?: 18

    println(toString(nombre,apellido,edad))
}