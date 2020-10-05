interface Interfaces {
    fun bar()
    fun foo() {
        println("foo")
    }
}

class Test : Interfaces {
    companion object {
        fun say() = "hello world"
    }

    override fun bar() {}
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

fun MutableList<Int>.swap(i1: Int, i2: Int) {
    val tmp = this[i1]
    this[i1] = this[i2]
    this[i2] = tmp
}


data class Leo(val name: String)

sealed class Expr
data class Const(val number: Double) : Expr()
data class Value(val text: String) : Expr()
object NotANumber : Expr()


fun main() {
    val predicate = IntPredicate { i -> i == 10 }

    val list = MutableList(10) { it + 1 }
    list.swap(0, 1)

    val x: Expr = Const(10.1)
    when (x) {
        is Const -> print(x.number)
        is Value -> print(x.text.toUpperCase())
        NotANumber -> Double.NaN
    }
}