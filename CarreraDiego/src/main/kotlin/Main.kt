
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
 */
fun String.capitalizar(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

/**
 * Elimina espacios iniciales y finales, capitaliza las palabras y las separa por un unico espacio
 */
fun String.espaciosCapit(): String{
    val palabras = this.trim().split(" ")
    return palabras.filter { it.isNotBlank() }.joinToString(" ") { it.trim().capitalizar() }
}

/**
 * Punto de entrada del programa. Crea una lista de vehículos y una carrera, e inicia la carrera mostrando
 * los resultados al finalizar.
 */
fun main() {




    val vehiculos = listOf(
        Automovil("aurora", "Seat", "Panda", 50f, 50f * 0.1f, 0f, true),
        Automovil("Boreal m8", "BMW", "M8", 80f, 80f * 0.1f, 0f, false),
        Motocicleta("Céfiro", "Derbi", "Motoreta", 15f, 15f * 0.1f, 0f, 500),
        Automovil("Dinamo", "Cintroen", "Sor", 70f, 70f * 0.1f, 0f, true),
        Automovil("eclipse negro", "Renault", "Espacio", 60f, 60f * 0.1f, 0f, false),
        Motocicleta("Fénix", "Honda", "Vital", 20f, 20f * 0.1f, 0f, 250)
    )

    /*
    val carrera = Carrera("Gran Carrera de Filigranas", 1000f, vehiculos)

    println("\n*** ${carrera.nombreCarrera} ***\n")
    carrera.iniciarCarrera()

    val resultados = carrera.obtenerResultados()

    println("* Clasificación:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre} (${it.vehiculo.kilometrosActuales} kms)") }

    println("\n" + resultados.joinToString("\n") { it.toString() })

    println("\n* Historial Detallado:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre}\n${it.historialAcciones.joinToString("\n")}\n") }

    */



    val listaMarcas = listOf("Toyota", "Ford", "Chevrolet", "Honda", "Volkswagen", "BMW", "Mercedes-Benz", "Audi")
    val listaModelos = listOf("Volador", "Galopante", "Nadador", "Pisahuevos", "Estropeao")
    var listaNombres = mutableListOf("") // Se podria haber hecho con mutableSet y cambiando la funcion para comprobar y añadir




    fun pedirParticipante(): Int{
        var numPart: Int
        print("Introduce numero de participantes -> ")
        do {
            numPart = readln().toIntOrNull() ?:0
            if (numPart <= 0) print("Introduce entero positivo -> ")
        } while (numPart <= 0)
        return numPart
    }


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
     * Genera un vehiculo random
     */
    fun generarVehiculoRandom(numVehiculos: Int){

        for (i in 1..numVehiculos){

            val nombreVeh = pedirNombreVeh()
            val numRandom = (1..4).random()
            val vehiculoRandom = when (numRandom) {
                1 -> generarAutomovil(nombreVeh)
                2 -> generarMotocicleta(nombreVeh)
                3 -> generarCamion(nombreVeh)
                else -> generarQuad(nombreVeh)
            }
        }
    }


}

