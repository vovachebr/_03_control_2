import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test
    fun calculateTaxUnknownCartType() {
        val cardType = "unknown"
        val paid = 0
        val paymentValue = 10
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(0, tax)
    }

    @Test
    fun calculateTaxVKCartType() {
        val cardType = "VK Pay"
        val paid = 0
        val paymentValue = 10
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(0, tax)
    }

    @Test
    fun calculateTaxMastercardCartTypeWithoutLimit() {
        val cardType = "Mastercard"
        val paid = 0
        val paymentValue = 100
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(0, tax)
    }

    @Test
    fun calculateTaxMaestroCartTypeWithLimit() {
        val cardType = "Maestro"
        val paid = 75_000
        val paymentValue = 1000
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(20 + 6, tax)
    }

    @Test
    fun calculateTaxMaestroCartTypeWithoutLimit() {
        val cardType = "Maestro"
        val paid = 0
        val paymentValue = 100
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(0, tax)
    }

    @Test
    fun calculateTaxMastercardCartTypeWithLimit() {
        val cardType = "Mastercard"
        val paid = 75_000
        val paymentValue = 1000
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(20 + 6, tax)
    }

    @Test
    fun calculateTaxVisaCartTypeSmallExchange() {
        val cardType = "Visa"
        val paid = 200
        val paymentValue = 100
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(35, tax)
    }

    @Test
    fun calculateTaxVisaCartTypeBigExchange() {
        val cardType = "Visa"
        val paid = 200
        val paymentValue = 10_000
        val tax = calculateTax(cardType, paid, paymentValue)
        assertEquals(75, tax)
    }
}