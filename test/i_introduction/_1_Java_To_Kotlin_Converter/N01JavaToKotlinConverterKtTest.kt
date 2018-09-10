package i_introduction._1_Java_To_Kotlin_Converter

import org.junit.Assert.assertEquals
import org.junit.Test
import util.JavaCode

class N01JavaToKotlinConverterKtTest {
    @Test fun collection() {
        assertEquals("{1, 2, 3, 42, 555}", task1(listOf(1, 2, 3, 42, 555)))
    }
}
fun task1(collection: Collection<Int>): String {
    val sb = StringBuilder()
    sb.append("{")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(", ")
        }
    }
    sb.append("}")
    return sb.toString()
}