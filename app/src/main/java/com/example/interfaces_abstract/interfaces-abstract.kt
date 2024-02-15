package com.example.interfaces_abstract


// Main function
fun main () {
    // Exercise 1
    val mobileOne = Mobile("Iphone",3500, mapOf("Elgiganten" to 15.26) )
    mobileOne.printLocation()
    val raspberrypi = RaspberryPi("John's Phone",0, mapOf("Houston" to 29.749907))
    raspberrypi.printLocation()

    // Instagram exercise
    val cms = CMS()

    val textPost = TextPost(1, "Hello Kotlin", "user1", System.currentTimeMillis(), 100)
    val photoPost = PhotoPost(2, "Beautiful Sunset", "user2", System.currentTimeMillis(), "1920x1080")
    val videoPost = VideoPost(3, "Kotlin Tutorial", "user3", System.currentTimeMillis(), 15.0)

    cms.addPost(textPost)
    cms.addPost(photoPost)
    cms.addPost(videoPost)

    // Simulate likes
    textPost.like("userA")
    textPost.like("userB")
    photoPost.like("userA")
    videoPost.like("userC")
    videoPost.like("userD")
    videoPost.like("userE")

    // Display all posts
    cms.posts.forEach { it.displayPost() }

    // Get top N liked posts
    val topPosts = cms.getTopPostsLiked(2)
    println("\nTop Liked Posts:")
    topPosts.forEach { it.displayPost() }
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

abstract class Post (
        val id: Int,
        val caption: String,
        val uploader : String,
        val timeStamp : Long) {
    private var likesCount = 0
    private val likedByUser : MutableSet<String> = mutableSetOf()

    fun like (userId: String) {
        if (likedByUser.remove(userId)) {
            likesCount--
        }
    }

    fun getLikesCount () : Int = likesCount

    abstract fun displayPost()

}

class TextPost (id: Int, caption: String, uploader: String, timeStamp: Long, val wordCount : Int) : Post(id, caption, uploader, timeStamp) {

    override fun displayPost() {
        println("Text Post: " +
                " Caption: $caption" +
                " Uploaded by: $uploader" +
                " Word Count: $wordCount" +
                " Likes: ${getLikesCount()}")
    }
}

class PhotoPost (id: Int, caption: String, uploader: String, timeStamp: Long, val photoResolution : String) : Post(id, caption, uploader, timeStamp) {
    override fun displayPost() {
        println("Photo Post: " +
                " Caption: $caption" +
                " Uploaded by: $uploader" +
                " Resolution: $photoResolution" +
                " Likes: ${getLikesCount()}")
    }
}

class VideoPost (id: Int, caption: String, uploader: String, timeStamp: Long, val videoLengthInMinitues : Double) : Post(id, caption, uploader, timeStamp) {
    override fun displayPost() {
        println("Text Post: " +
                " Caption: $caption" +
                " Uploaded by: $uploader" +
                " Video Length In Minutes: $videoLengthInMinitues" +
                " Likes: ${getLikesCount()}")
    }
}

class CMS {
    val posts: MutableList<Post> = mutableListOf()

    fun addPost (post: Post) {
        posts.add(post)
    }

    fun searchPosts (criteria: (Post) -> Boolean): List<Post> {
        return posts.filter(criteria)
    }

    fun getTopPostsLiked (n: Int): List<Post> {
        return posts.sortedByDescending { it.getLikesCount() }.take(n)
    }
}


