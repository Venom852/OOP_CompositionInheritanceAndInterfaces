package ru.netology

import java.time.LocalDate

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val date: LocalDate = LocalDate.of(2000, 1, 1),
    val text: String? = null,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val comments: Comments = Comments(),
    val likes: Likes? = null,
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val canPin: Boolean? = null,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    var attachments: Array<Attachment> = emptyArray<Attachment>()
) {
    override fun equals(other: Any?): Boolean {
        other as Post
        return attachments.contentEquals(other.attachments)
    }
}

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Likes(val count: Int = 0, val userLikes: Boolean = false, val canPublish: Boolean = false)

data class Reposts(val count: Int = 0)

data class Views(val count: Int = 0)

object WallService {
    private var id: Int = 0
    private var posts = emptyArray<Post>()

    fun addAttachments(post: Post, attachment: Attachment) {
        post.attachments += attachment
    }

    fun conclusionAttachments(post: Post) {
        for (attachment in post.attachments) {
            println(attachment)
        }
    }

    fun clear() {
        posts = emptyArray()
        id = 0
    }

    fun add(post: Post): Post {
        id++
        posts += post.copy(id = id)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postArray) in posts.withIndex()) {
            if (post.id === postArray.id) {
                posts[index] = post.copy(
                    id = id + 1,
                    ownerId = 1,
                    fromId = 1,
                    date = LocalDate.of(2024, 12, 19),
                    text = "Пост о рыбалке",
                    replyOwnerId = 1,
                    replyPostId = 1,
                    comments = Comments(
                        count = 1,
                        canPost = true,
                        groupsCanPost = true,
                        canClose = true,
                        canOpen = true
                    ),
                    likes = Likes(count = 1, userLikes = true, canPublish = true),
                    reposts = Reposts(count = 1),
                    views = Views(count = 1),
                    canPin = true,
                    canDelete = true,
                    canEdit = true,
                    isPinned = true,
                    markedAsAds = true
                )
                return true
            }
        }
        return false
    }
}

fun main() {
    val post = Post()

    val photo = PhotoAttachment()
    val video = VideoAttachment()
    val audio = AudioAttachment()
    val file = FileAttachment()
    val userGift = UserGiftAttachment()

    println(WallService.add(post))
    println(WallService.update(post))
    println()

    WallService.addAttachments(post, photo)
    WallService.addAttachments(post, video)
    WallService.addAttachments(post, audio)
    WallService.addAttachments(post, file)
    WallService.addAttachments(post, userGift)

    WallService.conclusionAttachments(post)
    println()

    val newPhoto: NewAttachment = NewPhotoAttachment(NewPhoto())
    println(newPhoto.type)

    val newVideo: NewAttachment = NewVideoAttachment(NewVideo())
    println(newVideo.type)

    val newAudio: NewAttachment = NewAudioAttachment(NewAudio())
    println(newAudio.type)

    val newFile: NewAttachment = NewFileAttachment(NewFile())
    println(newFile.type)

    val newUserGift: NewAttachment = NewUserGiftAttachment(NewUserGift())
    println(newUserGift.type)
}