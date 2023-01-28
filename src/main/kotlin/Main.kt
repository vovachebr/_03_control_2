import kotlin.random.Random.Default.nextInt

fun main() {
    val cardsTypes = arrayOf("Mastercard", "Maestro", "Visa", "Мир", "VK Pay")

    for (i in 1..10) {
    val userCardType = cardsTypes[nextInt(5)]
    val alreadyPaid = nextInt(100_000)
    val paymentValue = nextInt(20_000)

    println("""Вычисляем комиссию для $userCardType при переводе ${paymentValue} (если за месяц было переведно ${alreadyPaid})...""")
    val taxValue = calculateTax(userCardType, alreadyPaid, paymentValue)
    println("""Размер комиссии составит $taxValue""")
    }
}

fun calculateTax(cartType: String, paid: Int, paymentValue: Int): Int {
    return when (cartType) {
        "Mastercard", "Maestro" -> if (paid < 75_000) 0 else (paymentValue * 0.006).toInt() + 20
        "Visa", "Мир" -> Math.max((paymentValue * 0.0075).toInt(), 35)
        "VK Pay" -> 0
        else -> 0
    }
}