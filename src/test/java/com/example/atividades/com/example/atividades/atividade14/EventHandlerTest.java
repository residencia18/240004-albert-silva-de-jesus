package com.example.atividades.atividade14;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EventHandlerTest {

  @Test
  void testHandleEvent() {
    // Arrange
    String event = "Test Event";

    EmailService emailService = mock(EmailService.class);

    EventHandler eventHandler = new EventHandler(emailService);

    // Act
    eventHandler.handleEvent(event);

    // Assert
    verify(emailService, times(1)).sendEmail("test@example.com", "Event Occurred", event);
  }
}
