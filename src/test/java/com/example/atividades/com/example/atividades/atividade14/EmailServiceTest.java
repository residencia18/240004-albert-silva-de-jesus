package com.example.atividades.atividade14;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EmailServiceTest {

  @Test
  void testSendEmail() {
    // Arrange
    String recipient = "java@example.com";
    String subject = "Java Subject";
    String body = "Java Body";

    EmailService emailService = mock(EmailService.class);

    // Act
    emailService.sendEmail(recipient, subject, body);

    // Assert
    verify(emailService, times(1)).sendEmail(recipient, subject, body);
  }
}
