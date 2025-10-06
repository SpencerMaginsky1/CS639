//Getting Started
fun printHello(){
    println("Hello World")
}

printHello()

//Kotlin Basics

// Section 2: Learn about operators and types
val i: Int = 5

val b1 = 1.toByte()
println(b1)

val b2: Byte = 2
println(b2)

//val i1: Int = b2 //Initializer type mismatch: expected 'Int', actual 'Byte'
//val i2: String = b2 //Initializer type mismatch: expected 'String', actual 'Byte'.
//val i3: Double = b2 //Initializer type mismatch: expected 'Double', actual 'Byte'.

val i4: Int = b2.toInt()
val i5: String = b2.toString()
val i6: Double = b2.toDouble()

println("i4: " + i4 + " i5: " + i5 + " i6: " + i6)

val oneMillion = 1_000_00
println(oneMillion)

var fish = 1
fish=2
println(fish)

val aquarium = 1
//aquarium = 2 //'val' cannot be reassigned.


// Section 3 Compare conditions and booleans
val numberOfFish = 5
val numberOfPlants = 15
println("There are $numberOfFish fish" + " and $numberOfPlants plants")
println("There are ${numberOfPlants + numberOfFish} combined fish and plants")

if (numberOfFish > numberOfPlants){
    println("The fish to plants ratio is proper")
} else {
    println("there are too many plants compared to fish in the aquarium")
}


if (numberOfFish == 0){
    println("The tank is empty")
}else if (numberOfFish in 1..10){
    println("The tank is properly stocked")
}else {
    println("The tank is overstocked!")
}

when (numberOfFish){
    0 -> println("The tank is empty")
    in 1..10 -> println("The tank is properly stocked")
    else -> println("The tank is overstocked!")
}


//Section 4: Learn about nullability

//var rocks: Int = null //Null cannot be a value of a non-null type 'Int'.

var marbles: Int? = null

var fishFood = 5

if (fishFood != null){
    fishFood = fishFood.dec()
    println(fishFood)
}

fishFood = fishFood?.dec() ?: 0
println(fishFood)


// Section 5: Explore arrays, lists, and loops
val reef = listOf("yellow tang", "emerald crab", "midnight trigger")
println(reef)

val freshwaterList = mutableListOf("carp", "catfish", "pleco")
println(freshwaterList)
freshwaterList.remove("pleco")
println(freshwaterList)

val saltwaterArray = arrayOf("tuna", "sardine", "dolphin")
println(java.util.Arrays.toString(saltwaterArray))

val mixArray = arrayOf("tuna", 2)
println(mixArray[0])

val numbers = intArrayOf(1,2,3,4,5)
val numbers2 = intArrayOf(6,7,8,9)
val foo = numbers + numbers2
println(foo[8])

val oddList = listOf(numbers, freshwaterList, "grapes")
println(oddList)

val array = Array (5) {it}
println(java.util.Arrays.toString(array))

for (element in reef){
    print(element + ", ")
}

for ((index, element) in reef.withIndex()){
    println("\nitem at $index is at $element")
}

for (i in 1..5) print(i)
println("")
for (i in 5 downTo 1) print(i)
println("")
for (i in 2..5 step 2) print(i)
println("")
for (i in 'a'..'f') print(i)
println("")

var bubbles = 0
while (bubbles < 50){
    bubbles++
}
println("there are $bubbles bubbles in the water\n")

do {
    bubbles--
}while (bubbles > 50)
    println("There are now $bubbles bubbles in the water\n")

repeat(2){
    println("There is a fish swimming in the water!!")
}
