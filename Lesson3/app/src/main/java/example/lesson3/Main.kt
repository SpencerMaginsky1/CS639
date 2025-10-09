package example.lesson3

//Section 1: Create a class
fun buildAquarium(){
    val myAquarium = Aquarium()
    println("\nSection 2: Create a class\n")
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()

    //Section: 3 Add class constructors
    println("\nSection 3: Add class constructors\n")
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium5 = Aquarium(numberOfFish = 29)
    aquarium5.printSize()
    //println("Volume: ${aquarium5.width * aquarium5.length * aquarium5.height / 1000} liters")
    aquarium5.volume = 70
    aquarium5.printSize()
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()


    println("\nSection 5: Add class constructors\n")
    //Section 5: Learn about subclasses and inheritance
    val aquarium7 = Aquarium(width = 25, length = 25, height = 40)
    aquarium7.printSize()
    val tower1 = TowerTank(diameter = 25, height = 40)
    tower1.printSize()


}

//Section 6: Compare abstract classes and interfaces
fun makeFish(){
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
    //pleco.FishAction()
}

fun main(){
    //buildAquarium()
    makeFish()
}

