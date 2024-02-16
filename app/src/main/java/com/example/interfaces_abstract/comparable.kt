package com.example.interfaces_abstract

fun main () {
    // Exercise A
    val students = listOf(
        Student("Alice", "alice@example.com", 20, listOf("Math", "Science")),
        Student("Bob", "bob@example.com", 20, listOf("Math")),
        Student("Charlie", "charlie@example.com", 22, listOf("History", "Science")),
        Student("David", "david@example.com", 19, listOf("Math", "Science", "Art")),
        Student("Eve", "eve@example.com", 20, listOf("Math", "Science", "History", "Geography"))
    )

    val sortedStudent = students.sorted()
    println("Sorted students: ")
    sortedStudent.forEach { student -> println("Name: ${student.name}, Age: ${student.age}, Email: ${student.Email}, Subject: ${student.subjects.size}")  }
}

/*
A)

Write a class student

A student has the following fields:

Name

Email

Age

Subjects : list

Implement the comparable interface such that students can be sorted by age

Improve the solution such that if students are the same age, they are sorted by amount of subjects

I.E A student with the same age as another student is rated "higher" if the have more subjects
*/
class Student (val name : String,
               val Email : String,
               val age : Int,
               val subjects : List<String>) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        if (this.age == other.age) {
            return this.subjects.size.compareTo(other.subjects.size)
        }
        return this.age.compareTo(other.age)
    }

}

/*
B)

Create a data class named Book with the following properties:

title: The title of the book.

author: The author of the book.

isbn: The ISBN (International Standard Book Number) of the book.

price: The price of the book.

Implement a class called Bookstore with the following methods:

addBook(book: Book): Adds a book to the inventory.

removeBook(isbn: String): Removes a book from the inventory based on its ISBN.

searchBookByTitle(title: String): Book?: Searches for a book in the inventory by its title and returns the book if found, otherwise returns null.

displayInventory(): Displays all books in the inventory.

Create a main function to test the functionality of the Bookstore class:

Instantiate a Bookstore object.

Add a few sample books to the inventory.

Test adding, removing, searching for, and displaying books in the inventory.
*/

/*
D)

Write a method called smallWordFilter that, given a non-null String (not list!) containing words separated by single spaces (" "), returns all the words in the original String that are 3 characters or shorter in the same order in which they appeared in the original String, as a List<String>.

For example, given the input "Xyz is the very best cat" you would return the List<String> containing {"Xyz", "is", "the", "cat"}. We have skipped both "very" and "best" because they are longer than 3 characters.

From: https://www.learncs.online/practice/kotlin/small-word-filter-with-list/challen@illinois.edu?returnTo=lists

Hint: https://kotlinandroid.org/kotlin/kotlin-split-string/

Advanced (Optional)

(This question was asked by microsoft for a coding interview)

Given a string and a pattern, find the starting indices of all occurrences of the pattern in the string. For example, given the string "abracadabra" and the pattern "abr", you should return [0, 7].
 */