import kotlin.random.Random

class Quad(
    nombre: String,
    tipo: TipoQuad,
    cilindrada: Int
) : Motocicleta(nombre, "", "", 0f, 0f, 0f, cilindrada)  {

    init {
        require(tipo in TipoQuad.values()){"El tipo de quad debe ser: ${TipoQuad.values().joinToString()}"}
        require(cilindrada in listaCilindrada) { "Una motocicleta debe tener una de estas cilindradas: 125, 250, 400, 500, 750, 900, 1000" }

    }

    companion object{
        const val KM_LITRO = 2
    }

    override fun calcularAutonomia(): Float {
        return (super.calcularAutonomia() / 2)
    }



}