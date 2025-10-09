package example.lesson3

//Section 6: Compare abstract classes and interfaces
abstract class AquariumFish: FishAction{
    abstract val color: String
    override fun eat() = println("yum")
}

// Replaced inheriting AquariumFish to FishColor (Section 7)
class Shark:FishAction, FishColor{
    override val color = "grey"
    override fun eat() {
        println("Hunts and eats a variety of prey ranging from fish to mammals ")
    }
}

// Updated Plecostomus()'s FishAction and FishColor to use the added helper functions (Section 7)
class Plecostomus(fishColor: FishColor = GoldColor): FishAction by
        PrintingFishAction("Searches rocks and other hard surfaces for algae"),
        FishColor by fishColor {
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

interface FishAction {
    fun eat()
}

//Section 7: User interface delegation
interface FishColor{
    val color: String
}
object GoldColor : FishColor {
    override val color = "gold"
}


