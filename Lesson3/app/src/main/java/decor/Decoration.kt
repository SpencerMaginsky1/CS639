package decor

//Section 8: Create a data class
data class Decoration(val rocks: String) {

}
data class Decoration2(val rock: String, val wood: String, val diver: String) {

}

//Section 9: Learn about singletons and enums
enum class Color(val rgb: Int){
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}
enum class Direction(val degrees: Int){
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

//CodeLab Part 2: Pairs/Triples, collections, constants, and writing extension functions
//Section 1: Create a Companion Object
class Choice{
    companion object{
        var name: String = "lyric"
        fun showDescription(name:String) = println("My Favorite $name")
    }
}


fun makeDecorations(){

    val deco1 = Decoration("granite")
    println(deco1)

    val deco2 = Decoration("slate")
    println(deco2)

    val deco3 = Decoration("slate")
    println(deco3)

    println(deco1.equals(deco2))
    println(deco3.equals(deco2))

    val deco4 = Decoration2("Marble", "Oak", "Diver")
    println(deco4)

    val (rock, wood, diver) = deco4
    println(rock)
    println(wood)
    println(diver)
}

fun main(){
    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")
}