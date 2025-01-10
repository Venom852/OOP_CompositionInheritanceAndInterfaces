package ru.netology

interface Attachment {
    val type: String
}

data class Photo(override val type: String = "Photo"): Attachment {
    val photo: PhotoAttachments = PhotoAttachments()
}

data class PhotoAttachments(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val text: String = "",
)

data class Video(override val type: String = "Video"): Attachment {
    val video: VideoAttachments = VideoAttachments()
}

data class VideoAttachments(
    val id: Int = 0,
    val title: String = "",
    val ownerId: Int = 0,
    val description: String = "",
    val duration: Int = 0,
)

data class Audio(override val type: String = "Audio"): Attachment {
    val audio: AudioAttachments = AudioAttachments()
}

data class AudioAttachments(
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
)

data class File(override val type: String = "File"): Attachment {
    val file: FileAttachments = FileAttachments()
}

data class FileAttachments(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
)

data class UserGift(override val type: String = "UserGift"): Attachment {
    val userGift: UserGiftAttachments = UserGiftAttachments()
}

data class UserGiftAttachments(
    val id: Int = 0,
    val fromId: Int = 0,
    val message: String = "",
)
