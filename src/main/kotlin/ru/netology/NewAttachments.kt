package ru.netology

sealed class NewAttachment(val type: String)

data class NewPhotoAttachment(val newPhoto: NewPhoto = NewPhoto()): NewAttachment("Photo")

data class NewPhoto(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val text: String = "",
)

data class NewVideoAttachment(val newVideo: NewVideo = NewVideo()): NewAttachment("Video")

data class NewVideo(
    val id: Int = 0,
    val title: String = "",
    val ownerId: Int = 0,
    val description: String = "",
    val duration: Int = 0,
)

data class NewAudioAttachment(val newAudio: NewAudio = NewAudio()): NewAttachment("Audio")

data class NewAudio(
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
)

data class NewFileAttachment(val newFile: NewFile = NewFile()): NewAttachment("File")

data class NewFile(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
)

data class NewUserGiftAttachment(val newUserGift: NewUserGift = NewUserGift()): NewAttachment("UserGift")

data class NewUserGift(
    val id: Int = 0,
    val fromId: Int = 0,
    val message: String = "",
)