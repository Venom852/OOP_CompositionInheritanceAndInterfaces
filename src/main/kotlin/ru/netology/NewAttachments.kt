package ru.netology

sealed class NewAttachment(val type: String)

data class NewPhoto(val newPhoto: PhotoNewAttachments = PhotoNewAttachments()): NewAttachment("Photo")

data class PhotoNewAttachments(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val text: String = "",
)

data class NewVideo(val newVideo: VideoNewAttachments = VideoNewAttachments()): NewAttachment("Video")

data class VideoNewAttachments(
    val id: Int = 0,
    val title: String = "",
    val ownerId: Int = 0,
    val description: String = "",
    val duration: Int = 0,
)

data class NewAudio(val newAudio: AudioNewAttachments = AudioNewAttachments()): NewAttachment("Audio")

data class AudioNewAttachments(
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
)

data class NewFile(val newFile: FileNewAttachments = FileNewAttachments()): NewAttachment("File")

data class FileNewAttachments(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
)

data class NewUserGift(val newUserGift: UserGiftNewAttachments = UserGiftNewAttachments()): NewAttachment("UserGift")

data class UserGiftNewAttachments(
    val id: Int = 0,
    val fromId: Int = 0,
    val message: String = "",
)