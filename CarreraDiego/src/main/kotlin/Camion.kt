class Camion(
    nombre: String,
    marca: String = "",
    modelo: String = "",
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float,
    esHibrido: Boolean,
    private val peso: Float
) : Automovil(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, esHibrido) {



    init {
        require(peso in 1000f..10000f){"El peso debe estar entre 1000-10000"}

    }
    companion object{
        const val KM_LITRO = 6.25f // Consumo base
        const val REDUCCION_KM_PESO = 0.2f  // Se reduce 0.2 cada 1000kg
    }


    override fun calcularAutonomia(): Float {
        val reducccionARestar = (peso * REDUCCION_KM_PESO) / 1000
        // Si es hibrido le sumo el ahorro electrico
        return if (esHibrido) combustibleActual * ((KM_LITRO - reducccionARestar)+ AHORRO_ELECTRICO) else combustibleActual * (KM_LITRO - reducccionARestar)
    }








}