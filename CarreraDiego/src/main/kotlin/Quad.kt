import kotlin.random.Random

class Quad(
    nombre: String,
    tipo: TipoQuad,
    capacidadCombustible: Float,
    combustibleActual: Float,
    cilindrada: Int
) : Motocicleta(nombre, "", "",capacidadCombustible, combustibleActual,0.0f,  cilindrada)  {

    init {
        require(tipo in TipoQuad.values()){"El tipo de quad debe ser: ${TipoQuad.values().joinToString()}"}
        require(cilindrada in listaCilindrada) { "Una motocicleta debe tener una de estas cilindradas: 125, 250, 400, 500, 750, 900, 1000" }

        require(capacidadCombustible in 20f..40f){"La capacidad de combustible debe estar entre 20-40"}
        require(combustibleActual in (capacidadCombustible * 0.2f.. capacidadCombustible)){"El combustible debe ser entre un 20% - 100% de la capacidad total"}


    }

    companion object{
        val listaCilindrada = listOf(125, 250, 400, 500, 750, 900, 1000)
    }

    override fun calcularAutonomia(): Float {
        return (super.calcularAutonomia() / 2)
    }


    override fun toString(): String {
        return "Quad(nombre=$nombre, marca=$marca, modelo=$modelo, capacidadCombustible=$capacidadCombustible, combustibleActual=$combustibleActual, kilometrosActuales=$kilometrosActuales, cilindrada=$cilindrada)"
    }


}