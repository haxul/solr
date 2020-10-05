
interface Animal {
    val legs: Int

}

class Person(val gender: Boolean?, color: String, override val legs: Int) : Human(color), Animal  {
    var simple: Int? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }

    lateinit var lastName: String

    init {
        lastName = "hello world"
    }
    override fun say() {
        if (::lastName.isInitialized) {
            println("init")
        }
        print("not fuck")
    }

    fun sayParent() {
        super.say()
    }
}

open class Human(val color: String) {

    open fun say() {
        print("fuck")
    }

}

fun main() {
    val person = Person(gender = false, color = "red", legs = 2)
    person.say()

}