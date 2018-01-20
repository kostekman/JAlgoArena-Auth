package com.jalgoarena.web

import com.jalgoarena.data.UsersRepository
import com.jalgoarena.email.EmailSender
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject

@RestController
class EmailRemindersController(@Inject private val repository: UsersRepository,
                               @Inject private val emailSender: EmailSender) {

    @GetMapping("/sendEmails", produces = arrayOf("application/json"))
    fun sendEmails() = repository.findAll().map {
        user -> emailSender.sendMessage(user.email, "test")
    }
}