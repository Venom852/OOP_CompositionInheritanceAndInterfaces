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
        val photo = Photo()
        val result = WallService.addAttachments(photo)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_video() {
        val video = Video()
        val result = WallService.addAttachments(video)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_audio() {
        val audio = Audio()
        val result = WallService.addAttachments(audio)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_file() {
        val file = File()
        val result = WallService.addAttachments(file)

        assertEquals(Unit, result)
    }

    @Test
    fun addAttachments_userGift() {
        val userGift = UserGift()
        val result = WallService.addAttachments(userGift)

        assertEquals(Unit, result)
    }
    @Test
    fun conclusionAttachments_attachments() {
        val photo = Photo()
        val video = Video()
        val audio = Audio()
        val file = File()
        val userGift = UserGift()

        WallService.addAttachments(photo)
        WallService.addAttachments(video)
        WallService.addAttachments(audio)
        WallService.addAttachments(file)
        WallService.addAttachments(userGift)

        val result = WallService.conclusionAttachments()

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
