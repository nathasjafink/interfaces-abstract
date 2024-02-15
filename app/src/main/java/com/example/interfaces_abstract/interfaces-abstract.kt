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
Create two Mobile and two RaspberriPi objects
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

/*
Instagram like service
We need to create functionality for an Instagram-like Service.

Social Media Content
Design a system to manage social media content for a platform that supports different types of posts,
such as text posts, photo posts, and video posts. Each type of post shares common properties like a caption,
uploader (the user who posted it), and the timestamp of when it was posted. Additionally, each post type can have unique properties and behaviors:
- Common Post Features: Every post, irrespective of its type, should allow operations to get the number of likes it has received and support like/dislike actions.
- Text Post: A simple post containing text content.
- Photo Post: A post that includes a photo along with the common features. It may have additional properties like photo resolution, filters applied, etc.
- Video Post: Similar to a photo post but contains a video. It could have properties like video length, resolution, etc.

Content Management System (CMS)

A Content Management System (CMS) should be designed to manage the different types of posts. The CMS should allow:
- Adding new posts to the collection.
- Searching for posts using criteria such as caption, uploader, or post type.
- Retrieving the top N most liked posts across all types.

Implementation Requirements:

Define an interface or abstract class to represent the common structure and behavior of all post types.
This should include methods for liking/disliking a post and retrieving the like count.
Implement concrete classes for each specific type of post (Text Post, Photo Post, Video Post)
that extend the abstract class or implement the interface, adding any specific properties or methods needed.
Design the CMS to work with the abstract post types, ensuring it can manage any post type that conforms to the interface or abstract class contract.
In a main method, demonstrate the creation of various types of posts, adding them to the CMS, performing searches, and retrieving the top N most liked posts.
 */
