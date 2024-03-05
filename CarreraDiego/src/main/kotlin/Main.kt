
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Extiende la clase [Float] para permitir el redondeo del número a un número específico de posiciones decimales.
 *
 * @param posiciones El número de posiciones decimales a las que se redondeará el valor.
 * @return Un [Float] redondeado al número de posiciones decimales especificadas.
 */
fun Float.redondear(posiciones: Int): Float {
    val factor = 10.0.pow(posiciones.toDouble()).toFloat()
    return (this * factor).roundToInt() / factor
}



/**
 * Crear metodo capitalizar para los strings
 * Capitaliza la primera letra de cada palabra en el string.
 */
fun String.capitalizar(): String {
    return this.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

/**
 * Elimina espacios iniciales y finales, capitaliza las palabras y las separa por un unico espacio
 */
fun String.espaciosCapit(): String{
    val palabras = this.trim().split(" ")
    return palabras.filter { it.isNotBlank() }.joinToString(" ") { it.trim().capitalizar() }
}

/**
 * Punto de entrada del programa.
 */
fun main() {

    val vehiculos: MutableList<Vehiculo> = mutableListOf()

    val listaMarcas = listOf("Toyota", "Ford", "Chevrolet", "Honda", "Volkswagen", "BMW", "Mercedes-Benz", "Audi")
    val listaModelos = listOf("Volador", "Galopante", "Nadador", "Pisahuevos", "Estropeao")
    val listaNombres = mutableListOf("") // Se podria haber hecho con mutableSet y cambiando la funcion para comprobar y añadir


    /**
     * Pide al usuario ingresar el número de participantes, hasta que sea uno valido.
     * @return El número de participantes ingresado por el usuario.
     */
    fun pedirParticipantes(): Int{
        var numPart: Int
        print("Introduce numero de participantes -> ")
        do {
            numPart = readln().toIntOrNull() ?:0
            if (numPart <= 0) print("Error - Introduce entero positivo -> ")
        } while (numPart <= 0)
        return numPart
    }


    /**
     * Pide al usuario ingresar el nombre del vehículo, hasta que introduzca uno valido
     * @return El nombre del vehículo ingresado por el usuario.
     */
    fun pedirNombreVeh(): String{
        var nombre:String
        print("Introduce nombre vehiculo -> ")
        do {
            nombre = readln().espaciosCapit()
            if (nombre.isBlank()){
                print("Debe introducir algo -> ")
            }
            else if (nombre in listaNombres){
                print("Este nombre ya existe! Introduce otro -> ")
            }
        }while (nombre.isBlank() || nombre in listaNombres)
        println("Nombre correcto")
        listaNombres.add(nombre)
        return nombre
    }


    /**
    * Genera un vehículo aleatorio y lo agrega a la lista de vehículos.
    */
    fun generarVehiculoRandom(){

        val nombreVeh = pedirNombreVeh()
        val numRandom = (1..4).random()
        val vehiculoRandom = when (numRandom) {
            1 -> {
                // Automovil
                val capacidad = (30..60).random().toFloat()
                val numRand = (20..100).random()
                val combustible = capacidad * (numRand.toFloat() / 100)

                Automovil(nombreVeh, listaMarcas.random(), listaModelos.random(), capacidad, combustible, 0.0f, false)

            }
            2 -> {
                // Motocicleta
                val capacidad = (15..30).random().toFloat()
                val numRand = (20..100).random()
                val combustible = capacidad * (numRand.toFloat() / 100)

                Motocicleta(nombreVeh, listaMarcas.random(), listaModelos.random(), capacidad, combustible, 0.0f, Motocicleta.listaCilindrada.random())
            }
            3 -> {
                // Camion
                val capacidad = (90..150).random().toFloat()
                val numRand = (20..100).random()
                val combustible = capacidad * (numRand.toFloat() / 100)

                Camion(nombreVeh, capacidad, combustible, 0.0f, false, (1000..10000).random().toFloat())
            }
            else -> {
                // Quad
                val capacidad = (20..40).random().toFloat()
                val numRand = (20..100).random()
                val combustible = capacidad * (numRand.toFloat() / 100)

                Quad(nombreVeh, TipoQuad.entries.random(),capacidad, combustible, Quad.listaCilindrada.random())
            }
        }

        vehiculos.add(vehiculoRandom)

        println("Te ha tocado: $vehiculoRandom")
    }


    // Se pide el numero de participantes
    val numeroParticipantes = pedirParticipantes()

    // Iterar tantas veces como numero de particiapntes se introduzcan
    for (i in 1..numeroParticipantes){
        generarVehiculoRandom()
    }


    /////////////
    // PARTE 2 //
    /////////////

    val carrera = Carrera("Gran Carrera de Filigranas", 1000f, vehiculos)

    println("\n*** ${carrera.nombreCarrera} ***\n")
    carrera.iniciarCarrera()

    val resultados = carrera.obtenerResultados()

    println("\n" + resultados.joinToString("\n") { it.toString() })

    println("\n* Historial Detallado:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre}\n${it.historialAcciones.joinToString("\n")}\n") }




}

