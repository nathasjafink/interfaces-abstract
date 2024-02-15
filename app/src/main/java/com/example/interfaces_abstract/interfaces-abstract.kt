package com.example.interfaces_abstract


// Main function
fun main () {
    // Exercise 1
    val mobileOne = Mobile("Iphone",3500, mapOf("Elgiganten" to 15.26) )
    mobileOne.printLocation()
    val raspberrypi = RaspberryPi("John's Phone",0, mapOf("Houston" to 29.749907))
    raspberrypi.printLocation()
}
/*
Create two classes Mobile and RaspberriPi that implements this interface:
 */
public interface Computer {
    val name: String;
    val price: Int;
    val location: Map<String, Double>;
    fun printLocation();
}

class Mobile (
              override val name: String,
              override val price: Int,
              override val location: Map<String, Double>
) : Computer {
    override fun printLocation() {
        for ((key,value) in location) {
            println("${key}: $value")
        }
    }

}

class RaspberryPi(
    override val name: String,
    override val price: Int,
    override val location: Map<String, Double>
) : Computer {
    override fun printLocation() {
        for ((key,value) in location) {
            println("${key}: $value")
        }
    }

}