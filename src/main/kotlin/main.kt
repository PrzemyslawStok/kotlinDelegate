interface Figure2D {
    fun area(): Double
    fun perimeter(): Double

    fun info() {
        println("Area: ${area()}")
        println("Perimeter: ${perimeter()}")
    }
}

open class Square(val a: Double) : Figure2D {
    override fun area(): Double {
        return a * a
    }

    override fun perimeter(): Double {
        return 4 * a
    }

    override fun info() {
        println("---------Square---------")
        println("a: $a")
        super.info()
    }
}

class Triangle(val a: Double) : Figure2D {
    override fun area(): Double {
        return Math.sqrt(3.0) / 4.0 * a * a
    }

    override fun perimeter(): Double {
        return 3 * a
    }

}

class RectangularTriangle(val a: Double, val b: Double) : Figure2D {
    val c: Double

    init {
        c = Math.sqrt(a * a + b * b)
    }

    override fun area(): Double {
        return a * b
    }

    override fun perimeter(): Double {
        return a + b + c
    }
}

class Rectangle(val a: Double, val b: Double) : Figure2D {
    override fun area(): Double {
        return a * b
    }

    override fun perimeter(): Double {
        return 2 * a + 2 * b
    }

    override fun info() {
        println("---------Rectangle---------")
        println("a: $a b: $b")
        super.info()
    }
}

class Circle(val r: Double) : Figure2D {
    override fun area(): Double {
        return Math.PI * r * r
    }

    override fun perimeter(): Double {
        return 2 * Math.PI * r
    }

    override fun info() {
        println("---------Circle---------")
        println("r: $r")
        super.info()
    }

}

class Base(val figure2D: Figure2D, val material: String) {
    fun area(): Double {
        return figure2D.area()
    }

    fun perimeter(): Double {
        return figure2D.perimeter()
    }

    fun material(): String {
        return material
    }
}

class newBase(val figure2D: Figure2D, val material: String) : Figure2D by figure2D {
    fun material(): String {
        return material
    }

    override fun info() {
        println("area ${area()}")
        println("perimeter ${perimeter()}")
    }
}

open class Figure3D(open val base: Base, open val h: Double) {
    open fun volume(): Double {
        return base.area() * h
    }

    open fun area(): Double {
        return h * base.perimeter() + 2 * base.area()
    }
}

class Figure3D1(val baseCircle: Circle, override val h: Double) : Figure3D(Base(baseCircle, "metal"), h) {
    override fun volume(): Double {
        return 1.0 / 3.0 * super.volume()
    }

    override fun area(): Double {
        val r = baseCircle.r
        val l = Math.sqrt(r * r + h * h)
        return Math.PI * r * l
    }
}

class Figure3D2(val baseCircle: Circle) : Figure3D(Base(baseCircle, "wood"), 0.0) {
    override fun volume(): Double {
        val r = baseCircle.r
        return 4.0 / 3.0 * Math.PI * r * r * r
    }

    override fun area(): Double {
        val r = baseCircle.r
        return 4.0 * Math.PI * r * r
    }
}

fun main() {
    val figureList = mutableListOf<Figure2D>()

    figureList.add(Square(10.0))
    figureList.add(Rectangle(10.0, 10.0))
    figureList.add(Circle(2.0))

    figureList.forEach {
        it.info()
    }

    val base = Base(Square(10.0), "wood")
    println(base.area())
    println(base.perimeter())

    val newBase = newBase(Square(10.0), "wood")
    println(newBase.area())
    println(newBase.perimeter())

    val roller = Figure3D(Base(Circle(10.0), "plastic"), 5.0)
    roller.volume()

    val trianglePrism = Figure3D(Base(Triangle(12.0), "metal"), 2.0)
    println("Triangle prism volume: ${trianglePrism.volume()}")
    val rectangularPrism = Figure3D(Base(RectangularTriangle(12.0, 5.0), "metal"), 2.0)
    println("Rectangular prism volume: ${rectangularPrism.volume()}")
}
