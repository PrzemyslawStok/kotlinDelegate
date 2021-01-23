abstract class Figure2D {
    abstract fun area(): Double
    abstract fun perimeter(): Double

    open fun info() {
        println("Area: ${area()}")
        println("Perimeter: ${perimeter()}")
    }
}

class Square(val a: Double) : Figure2D() {
    override fun area(): Double {
        return a * a
    }

    override fun perimeter(): Double {
        return 4 * a
    }

    override fun info(){
        println("---------Square---------")
        println("a: $a")
        super.info()
    }
}

class Rectangle(val a: Double, val b: Double):Figure2D() {
    override fun area(): Double {
        return a*b
    }

    override fun perimeter(): Double {
        return 2*a+2*b
    }
}

class Circle(val r: Double){

}

fun main() {
    val figureList = mutableListOf<Figure2D>()

    figureList.add(Square(10.0))
    figureList.add(Rectangle(10.0,10.0))

    figureList.forEach {
        it.info()
        println("------------------")
    }

}
