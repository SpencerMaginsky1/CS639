import kotlin.random.Random

//Google Codelab Lesson 2: Functions

//Section 3: learn more about functions
fun fishFood(day: String): String{
    var food : String
    return when (day){
        "Monday" ->  "flakes"
        //"Tuesday" -> food = "pellets"
        "Wednesday" ->  "mysis shrimp"
        "Thursday" ->  "mealworms"
        "Friday" ->  "phyto plankton"
        //"Saturday" -> food = "nightcrawlers"
        "Sunday" ->  "mosquitoes"
        else -> "nothing"
    }

}
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish will eat $food")
    //Section 4: Explore default values and compact functions
    println("Change water: ${shouldChangeWater(day)}")
}
fun randomDay(): String{
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random.nextInt(week.size)]
}

//Section 4: Explore default values and compact functions
fun swim (speed: String = "fast"){
    println("The swimming speed is $speed")
}
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty)-> true
        isSunday(day) -> true
        else -> false
    }
}
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

//Section 5: Get started with filters
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

//Section 6: Getting started with lambdas and higher-order functions
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int{
    return operation(dirty)
}
fun increaseDirty(start: Int) = start + 1


//Section 1: Explore the main() function
fun main(args: Array<String>){
    println("Hello, ${args[0]}")

    //Section 2: Learn why (almost) everything has a value
    val isUnit = println("This is an expression")
    println(isUnit)

    val temerature = 10
    val isHot = if (temerature > 50) true else false
    println(isHot)
    val message = "The water temp is ${if (temerature > 50) "too warm" else "perfect"}"
    println(message)

    //Section 3 & Section 4
    feedTheFish()

    //Section 4
    swim()
    swim("slow")
    swim(speed = "turtle-like")

    //Section 5
    println(decorations.filter { it[0] == 'p' })

    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("----------")
    println("first: ${lazyMap.first()}")
    println("----------")
    println("first: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("----------")
    println("filtered: ${lazyMap2.toList()}")

    val mysports = listOf("baseball", "fishing", "golf")
    val myplayers = listOf("David Wright", "Ernest Hemingway", "Scottie Scheffler")
    val mycities = listOf("Berlin", "Moscow", "Warsaw")
    val mylist = listOf(mysports, myplayers, mycities)
    println("----------")
    println("Flat: ${mylist.flatten()}")

    //Section 6
    var dirtyLevel = 20
    val waterFilter: (Int) -> Int = {dirty -> dirty / 2}
    println(waterFilter(dirtyLevel))
    println(updateDirty(30, waterFilter))
    println(updateDirty(15, ::increaseDirty))
    dirtyLevel = updateDirty(dirtyLevel){dirtyLevel -> dirtyLevel + 20}
    println(dirtyLevel)

}
main(args)







