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

class Base(val figure2D: Figure2D, val material:String) {
    fun area(): Double {
        return figure2D.area()
    }

    fun perimeter(): Double {
        return figure2D.perimeter()
    }

    fun material():String{
        return material
    }
}

class newBase(val figure2D: Figure2D, val material: String) : Figure2D by figure2D{
    fun material():String{
        return material
    }

    override fun info(){
        println("area ${area()}")
        println("perimeter ${perimeter()}")
    }
}

class Figure3D(val base: Base, val h: Double) {
    fun volume(): Double {
        return base.area() * h
    }

    fun area(): Double {
        return h * base.perimeter() + 2 * base.area()
    }
}

//To może być troszkę trudniejsze...
class newFigure3D(val base: Figure2D, val h: Double) : Figure2D by base {
    fun volume(): Double {
        return area() * h
    }

    fun figure3DArea(): Double {
        return h * perimeter() + 2 * area()
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

    val base = Base(Square(10.0),"wood")
    println(base.area())
    println(base.perimeter())

    val newBase = newBase(Square(10.0),"wood")
    println(newBase.area())
    println(newBase.perimeter())

    val roller = Figure3D(Base(Circle(10.0),"plastic"),5.0)
    roller.volume()

    val newRoller = newFigure3D(Circle(10.0),5.0)

}
