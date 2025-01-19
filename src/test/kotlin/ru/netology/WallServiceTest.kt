package ru.netology

import junit.framework.TestCase.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Test
    fun add_post() {
        val post = Post()
        val result = WallService.add(post)

        assertEquals(Post(id = 1), result)
    }

    @Test
    fun addAttachments_photo() {
        val post = Post()
        val photo = PhotoAttachment()
        val result = WallService.addAttachments(post, photo)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_video() {
        val post = Post()
        val video = VideoAttachment()
        val result = WallService.addAttachments(post, video)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_audio() {
        val post = Post()
        val audio = AudioAttachment()
        val result = WallService.addAttachments(post, audio)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_file() {
        val post = Post()
        val file = FileAttachment()
        val result = WallService.addAttachments(post, file)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_userGift() {
        val post = Post()
        val userGift = UserGiftAttachment()
        val result = WallService.addAttachments(post, userGift)

        assertEquals(Unit, result)
    }

    @Test
    fun conclusionAttachments_attachments() {
        val post = Post()
        val photo = PhotoAttachment()
        val video = VideoAttachment()
        val audio = AudioAttachment()
        val file = FileAttachment()
        val userGift = UserGiftAttachment()

        WallService.addAttachments(post, photo)
        WallService.addAttachments(post, video)
        WallService.addAttachments(post, audio)
        WallService.addAttachments(post, file)
        WallService.addAttachments(post, userGift)

        val result = WallService.conclusionAttachments(post)

        assertEquals(Unit, result)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun update_existingId() {
        val post = Post(id = 1)
        WallService.add(Post())

        val result = WallService.update(post)

        assertTrue(result)
    }

    @Test
    fun update_notExistingId() {
        val post = Post()
        WallService.add(Post())

        val result = WallService.update(post)

        assertFalse(result)
    }
}
