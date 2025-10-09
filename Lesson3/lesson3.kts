//CodeLab Lesson3-Part 2: Pairs/Triples, collections, constants, and writing extension functions
//Section 2: Create a Companion Object

val equipment = "fish net" to "catching fish"
val (tool, use) = equipment
println("${equipment.first} used for ${equipment.second}")
println("$tool is used for $use")


val numbers = Triple(6, 9, 42)
val(n1, n2, n3) = numbers
println(numbers.toString())
println(numbers.toList())
println("$n1, $n2, $n3")

val equipment2 = ("fish net" to "catching fish") to "equipment"
println("${equipment2.first} is ${equipment2.second}\n")
println("${equipment2.first.second}")

//Section 3: Learn more about collections

val list = listOf(1, 6, 3, 9)
println(list.sum())

val list2 = listOf("a", "bbb", "cc")
println(list2.sumBy { it.length })
for (s in list2.listIterator()){
    println("$s")
}

val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras",
                            "zebra fish" to "daino rerio")

println(scientific.get("guppy"))
println(scientific.get("zebra fish"))

println(scientific.get("swordtail"))

println(scientific.getOrDefault("Swordtail", "Sorry, I don't know"))

println(scientific.getOrElse("Swordtail", {"Sorry, I don't know"}))

//Section 4: Organize and define constants

//const val rocks = 3 //Const 'val' is only allowed on top level, in named objects, or in companion objects.

class MyClass {
    object Constants {
        const val CONSTANT2 = "object constant"
    }
}

val foo = MyClass.Constants.CONSTANT2
println(foo)


// Section 5 Understand extension functions

fun String.hasSpaces() = indexOf(' ') != -1

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val plant = GreenLeafyPlant(size = 10)
plant.print()
val aquariumPlant: AquariumPlant = plant
aquariumPlant.print()

fun AquariumPlant.isRed() = color == "red"
//fun AquariumPlant.isRed() = size > 50 //Cannot access 'val size: Int': it is private in '/AquariumPlant'.


val AquariumPlant.isGreen: Boolean
    get() = color == "green"

println(aquariumPlant.isGreen)

fun AquariumPlant?.pull(){
    this?.apply{
        println("removing $this")
    }
}

