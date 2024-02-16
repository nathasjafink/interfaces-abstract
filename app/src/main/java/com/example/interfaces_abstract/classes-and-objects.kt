package com.example.interfaces_abstract

// Main Function
fun main () {
    // Exercise 1
    val catNamedGeorge = Cat("George", "American Wirehair", "Red", 2)
    val catNamedLuna = Cat("Luna", "Siamese", "White", 3)
    catNamedGeorge.getTheCatRace()
    catNamedLuna.getTheCatRace()

    // Exercise 2
    val georgestinderProfile = TinderProfile("George","Here to go on some crazy adventures",
        listOf("Hey There","Ready do something crazy")
    )
    georgestinderProfile.addedAnCaption()

    if (georgestinderProfile.isCaptionAdded()) {
        println("Caption successfully added")
    } else {
        println("Caption was not added")
    }

    // Print the caption list
    georgestinderProfile.getListOfCaption()

    // Exercise 3


}
/*
Exercise 1 - level 1
Create a Cat class. The class should have
4 attributes that you choose
1 method that you choose
Create 2 instances of cats using the constructor!
Now call the method on the two cat objects.
*/
open class Cat (
    val name : String,
    val race : String,
    val color : String,
    val age : Int) {
    open fun getTheCatRace () {
        println("The cat called $name is a $race")
    }
}
/*
Exercise 2 - level 1
Create the classes modelling the following objects. Add both some relevant attributes and some relevant methods
Think about what should go into the constructor and what should be set as attributes
Think about what is data and what is behavior
Recipe
A Tinder profile
A musical instrument
Instantiate at least one object per class
*/
class TinderProfile (
    val name : String,
    private val caption : String,
    val messages : List<String>) {
    var photoCaption : MutableList<String> = mutableListOf<String>()
    fun addedAnCaption(): Boolean {
        return photoCaption.add(caption)
    }

    fun isCaptionAdded () : Boolean {
        return photoCaption.contains(caption)
    }

    fun getListOfCaption () {
        println(photoCaption)
    }

}
/*
Exercise 3 - level 2
Skriv en klasse der hedder Lamp
Lamp har en boolean attribut der angiver om den er tændt eller slukket.
Når man laver et nyt lamp-objekt skal der være en constructor hvor man kan vælge om lampen som udgangspunkt er tændt eller slukket
Skriv en metode der hedder toggleLight, som tænder lampen hvis den er slukket, og slukker lampen hvis den er tændt.
Lav en klasse Room med en main-metode hvor du instantierer forskellige lampeobjekter (skrivebordslampe, sengelampe el. lign.) og tester om de virker som de skal
Lav en metode der returnerer antal gange lampen er togglet.
*/

/*
Exercise 4 - level 3
Create a class Pokemon that has the attributes mood, energy, and hunger, with a range of values between 10 (maximum) and 0 (minimum)
Create methods that can change the attributes. If a method attempts to raise an attribute above 10 or lower it below 0, the attribute should remain unchanged, and a message should be printed indicating that the pokemon is at maximum/minimum [mood/energy/hunger].
Now create a class Pokeball that includes a method to catch pokemon objects
In the main method, create an instance of Pokeball and generate several Pokemon objects.
*/
/*
Exercise 5 - level 3
Create classes for a todolist app.
Todoitem
Has a name, can be checked out, and can be favorited
Todolist is a list that holds Todoitems
Todoitems can be removed and added from the list
The Todolist should also be able to display the Todoitems
Create a menu where a user can
Create a Todoitem
Check out a Todoitem
Remove a Todoitem
 */