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


fun printed(x: Int, f: (Int) -> String): String {
    return "${f(x)} <- result";
}

fun main() {
    val map = emptyMap<String, Int>().toMutableMap()
    map["hello"] = 1
    map["hello"] = 2

}