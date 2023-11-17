package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.EmailRequest;

@ExtendWith(MockitoExtension.class)
class EmailRequestEntityTest {

    @Test
    void testEmailRequestGettersAndSetters() {
        EmailRequest emailRequest = new EmailRequest();

        emailRequest.setTo("nassim.benhassine@esprit.tn");
        emailRequest.setSubject("Test Subject");
        emailRequest.setText("Hello, this is a test email!");

        Assertions.assertEquals("nassim.benhassine@esprit.tn", emailRequest.getTo());
        Assertions.assertEquals("Test Subject", emailRequest.getSubject());
        Assertions.assertEquals("Hello, this is a test email!", emailRequest.getText());
    }
    @Test
    void testDataAnnotation() {
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setTo("recipient@example.com");
        emailRequest.setSubject("Test Subject");
        emailRequest.setText("Hello, this is a test email.");

        EmailRequest emailRequest2 = new EmailRequest();
        emailRequest2.setTo("recipient@example.com");
        emailRequest2.setSubject("Test Subject");
        emailRequest2.setText("Hello, this is a test email.");

        Assertions.assertNotNull(emailRequest.toString());
        Assertions.assertEquals(emailRequest2, emailRequest);
        Assertions.assertEquals(emailRequest.hashCode(), emailRequest.hashCode());
        Assertions.assertNotNull(emailRequest.getTo());
        Assertions.assertNotNull(emailRequest.getSubject());
        Assertions.assertNotNull(emailRequest.getText());
    }

}
