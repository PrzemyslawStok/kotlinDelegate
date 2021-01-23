abstract class Figure2D {
    abstract fun volume(): Double
    abstract fun field(): Double

    fun info() {
        println("Volume: ${volume()}")
        println("Field: ${field()}")
    }
}

class Square(val a: Double) : Figure2D() {
    override fun volume(): Double {
        return a * a
    }

    override fun field(): Double {
        return 4 * a
    }
}

class Rectangle(val a: Double, val b: Double) {

}

fun main() {
    val figureList = mutableListOf<Figure2D>()


    figureList.add(Square(10.0))
    //figureList.add(Rectangle(10.0,10.0))

    figureList.forEach {
        it.info()
        println("------------------")
    }

}
