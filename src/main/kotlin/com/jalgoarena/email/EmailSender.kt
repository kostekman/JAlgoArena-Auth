package com.jalgoarena.email

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.stereotype.Component
import java.util.*

@Component
class EmailSender(@Autowired private val mailSender: JavaMailSenderImpl){

/*    @Bean
    fun getJavaMailSender() : JavaMailSender{
        val mailSender = JavaMailSenderImpl();
        mailSender.host = "smtp.gmail.com";
        mailSender.port = 587;

        mailSender.username = "my.gmail@gmail.com";
        mailSender.password = "password"

    val props = mailSender.javaMailProperties
    props.put("mail.transport.protocol", "smtp")
    props.put("mail.smtp.auth", "true")
    props.put("mail.smtp.starttls.enable", "true")
    props.put("mail.debug", "true")

    return mailSender
    }*/

    fun sendMessage(to : String, problem : String){
        val message = SimpleMailMessage()
        message.to(to)
        message.subject = "Your daily JAlgoArena problem"
        message.text = "Hi,\n\tHave you checked JAlgoArena yet today?\nWe've got a problem" +
                "for you to check out: " + problem + "\n\tYour AJalgoArena crew"

        mailSender.send(message)
    }

}