package com.jalgoarena.email

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component
import javax.inject.Inject

@Component
class EmailSender(@Inject private val emailSender: JavaMailSender){

    fun sendMessage(to : String, problem : String){
        val message = SimpleMailMessage()
        message.to(to)
        message.subject = "Your daily JAlgoArena problem"
        message.text = "Hi,\n\tHave you checked JAlgoArena yet today?\nWe've got a problem" +
                "for you to check out: " + problem + "\n\tYour AJalgoArena crew"

        emailSender.send(message)
    }

}