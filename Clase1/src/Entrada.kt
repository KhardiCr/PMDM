fun main() {
    println("Console.log")
    //var lector: String? = readln().toString()

    var nombre = "texto"
    var edad = 4.0
    val experiencia = false; //constante
    var apellido: String //null
    var apellido2: String? = "null" //permite que sea null
    // println(apellido2.lenght) peta por que puede ser nulo.
    // con "apellido2!!.lenght" te lo puedes petar y si salta null te lo comes.
    //println(apellido2?.lenght ?: "no se encuentra el apellido")

    lateinit var correo: String
    correo = "1234@hola.com"// se declara la variable diciendo que se inicializará en algun momento
    println(correo)


    println("mi nombre es $nombre, mi apellido es ${apellido2 ?: "sin definir"}, y mi edad es $edad")

    sumar(5,10)
    //dividir(4,2)
}

fun sumar(operando1: Int, operando2: Int){
    println("el resultado es ${operando1+operando2}")
}

fun doblar(operando: Int): Int{
    return operando*2
}

fun incrementar(operando: Int?): Int{
    return operando?.inc() ?:0
}

//funciones lambda
// val variable = { arg: Tipo, arg: Tipo -> cuerpo}

//val dividir = {operando1: Int , operando2: Int ->
//  println("El resultado de la division es ${operando1/operando2}")
//}