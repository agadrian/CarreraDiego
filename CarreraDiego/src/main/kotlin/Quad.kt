class Quad(
    nombre: String,
    marca: String = "",
    modelo: String = "",
    capacidadCombustible: Float,
    combustibleActual: Float,
    kilometrosActuales: Float,
    cilindrada: Int,
    tipo: TipoQuad
) : Motocicleta(nombre, marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales, cilindrada)  {

    init {
        require(tipo in TipoQuad.values()){"El tipo de quad debe ser: ${TipoQuad.values().joinToString()}"}
    }

    companion object{
        const val KM_LITRO = 2
    }

    override fun calcularAutonomia(): Float {
        return (super.calcularAutonomia() / 2)
    }







}