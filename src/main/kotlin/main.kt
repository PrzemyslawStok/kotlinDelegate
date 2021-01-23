abstract class Figure2D{
    abstract fun volume():Double
    abstract fun field():Double

    fun info(){
        print("Info")
    }
}

class Square(val a: Double):Figure2D(){
    override fun volume(): Double {
        return a*a
    }
    override fun field(): Double {
        return 4*a
    }
}

class Rectangle(val a: Double, val b: Double){

}

fun main() {
}
