package pl.maprzybysz.springboot2.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MailSenderAspect {

    private EmailService emailService;

    @Autowired
    public MailSenderAspect(EmailService emailService) {
        this.emailService = emailService;
    }
    @Before("@annotation(pl.maprzybysz.springboot2.annotation.SendMailAnnotation)")
    public void sendMail(){
        emailService.sendMessage("notentego678@gmail.com",
                "homework","homework text");
    }

}
