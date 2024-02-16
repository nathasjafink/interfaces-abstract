package com.example.interfaces_abstract

// Main function
fun main () {
    // Exercise A
    val listOfStrings = arrayListOf<String>("Hello", "World", "Hey everybody", "RollerCoaster")
    println(returnIndices(listOfStrings))

    //Exercise B
    dictionary()
}
/*
A)

Write a function that takes an array of strings and returns the indices NOT the number of the top 2 longest strings of the array.

You can assume the array has at least 2 elements.

Hint: Could the return type be a data structure?

//Printing every index number in an array
  for (i in ints.indices){
      println(i);
  }

*/
fun returnIndices (strings: ArrayList<String>): List<Int> {
    val sortedIndicesByLength = strings.mapIndexed { index, string -> index to string.length  }
        .sortedByDescending { it.second }
        .take(2)
        .map { it.first }
    return sortedIndicesByLength
}

/*
To solve the following exercises you need to understand how to read text files
B)

Write a basic dictionary using a HashMap.

The keys will represent words and the values will be descriptions of the words
*/
fun dictionary () {
    val hashMap = hashMapOf<String,String>("cloudbaseret" to "som foregår eller fungerer ved hjælp af en samling af servere hvor store mængder data kan lagres og tilgås via internettet",
        "bandegruppering" to "gruppe mennesker med tilknytning til en bestemt kriminel bande",
        "copy-paste" to "funktion i et computerprogram til at kopiere eller flytte data fra ét sted til et andet, idet data afmærkes og kopieres eller flyttes til et midlertidigt lager inden de indsættes det nye sted")
    println(hashMap)
}
/*
C)

- Write a function that reads the file https://kea-fronter.itslearning.com/LearningToolElement/ViewLearningToolElement.aspx?LearningToolElementId=1239835

Create an object for each of the lines in the file such that each line generates an object with the properties: id, countryName, capital, population, continent
Write a hashmap such that:



key 1 → Denmark object


key2 → United states object

*/

/*
D)

We have users from 3 different platforms (users-1, users-2, users-3

We want to know:

What users are identical across all platforms

What users are only specific to each platform.



Advanced (Optional)

We want to analyse The republic by Plato.

How many times does each word occur?

Plato, PlAtO and plato should all count as the same word

What are the top 10 words that are not in the top 10 of conjuctions
 */