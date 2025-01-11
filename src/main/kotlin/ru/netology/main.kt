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
)

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
    private var attachments = emptyArray<Attachment>()

    fun addAttachments(attachment: Attachment){
        attachments += attachment
    }

    fun conclusionAttachments() {
        for (attachment in attachments) {
            println(attachment)
            println()
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

    val photo = Photo()
    val video = Video()
    val audio = Audio()
    val file = File()
    val userGift = UserGift()

    println(WallService.add(post))
    println(WallService.update(post))
    println()

    WallService.addAttachments(photo)
    WallService.addAttachments(video)
    WallService.addAttachments(audio)
    WallService.addAttachments(file)
    WallService.addAttachments(userGift)

    WallService.conclusionAttachments()

    val newPhoto: NewAttachment = NewPhoto(PhotoNewAttachments())
    println(newPhoto.type)

    val newVideo: NewAttachment = NewVideo(VideoNewAttachments())
    println(newVideo.type)

    val newAudio: NewAttachment = NewAudio(AudioNewAttachments())
    println(newAudio.type)

    val newFile: NewAttachment = NewFile(FileNewAttachments())
    println(newFile.type)

    val newUserGift: NewAttachment = NewUserGift(UserGiftNewAttachments())
    println(newUserGift.type)
}