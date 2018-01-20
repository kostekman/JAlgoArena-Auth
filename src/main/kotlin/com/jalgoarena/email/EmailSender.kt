package com.jalgoarena.email

import com.google.common.collect.ImmutableList
import com.jalgoarena.data.ProblemsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.stereotype.Component
import java.util.*
import javax.inject.Inject

@Component
class EmailSender(@Autowired private val mailSender: JavaMailSenderImpl,
                  @Inject private val problemsRepository: ProblemsRepository){

    fun sendMessage(to : String) : String{
        val problems = problemsRepository.findAll()
        val random = Random().nextInt(problems.size)

        val problem = problems[random].title


        val message = SimpleMailMessage()
        message.to = ImmutableList.of(to).toTypedArray()
        message.from ="jalgoarena@gmail.com"
        message.subject = "Your daily JAlgoArena problem"
        message.text = "Hi,\n\tHave you checked JAlgoArena yet today?\n\tWe've got a problem" +
                " for you to check out:\n\t" + problem + "\n\n\tRegards,\n\tYour AJalgoArena crew"

        mailSender.send(message)

        return to
    }

}