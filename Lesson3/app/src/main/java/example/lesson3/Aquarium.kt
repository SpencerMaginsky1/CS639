package example.lesson3

import kotlin.math.PI

//Section 2: Create a class and Section 3: Add class constructors
open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {

    //Section 3: Add class constructors
    init{
        println("Aquarium Initializing")
    }
    constructor(numberOfFish: Int): this(){
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

    //Section 5: Learn about subclasses and inheritance
    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    //Section 2: Create a class
    fun printSize(){
        println(shape)
        println("Width: $width cm " +
                "Height: $height cm " +
                 "Length: $length cm ")

        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

//Section5: Learn about subclasses and inheritance
class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter){
    override var volume: Int
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }
    override var water = volume * 0.8
    override val shape = "cylinder"
}

