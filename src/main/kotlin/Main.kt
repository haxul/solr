fun main() {
    val a: Int? = 1
    val b: Long? = a?.toLong()
    val c: Long? = a?.toLong()


    val arr = arrayOfNulls<Int>(10)
    val arr2 = Array(5) { _ -> 0 }

    val text = """
    |Tell me and I forget.
    |Teach ${a?.plus(1)} me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    val xs = listOf(1,2,3)

    for ((index, value) in xs.withIndex()) {
        println("value: $value , index: $index")
    }
//    when(xs) {
//        listOf(1,2,3) -> print("1,2,3")
//        listOf(1) -> print("1")
//        emptyList<Int>() -> print("emty")
//    }
}

