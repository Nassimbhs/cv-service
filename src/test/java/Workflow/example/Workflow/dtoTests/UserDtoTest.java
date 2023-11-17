package Workflow.example.Workflow.dtoTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.dto.UserDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserDtoTest {

    @Test
    void testUserDto() {
        Long id = 1L;
        String username = "sampleUser";
        String email = "sample@example.com";
        String password = "samplePassword";

        UserDto userDto = new UserDto(id, username, email, password);

        assertEquals(id, userDto.getId());
        assertEquals(username, userDto.getUsername());
        assertEquals(email, userDto.getEmail());
        assertEquals(password, userDto.getPassword());
    }

    @Test
    void testDataAnnotation() {
        UserDto userDto1 = new UserDto(1L, "Nassim", "nassim@example.com", "password123");
        UserDto userDto2 = new UserDto(1L, "Nassim", "nassim@example.com", "password123");

        Assertions.assertNotNull(userDto1.toString());
        assertEquals(userDto1, userDto2);
        assertEquals(userDto1.hashCode(), userDto2.hashCode());
        Assertions.assertNotNull(userDto1.getId());
        Assertions.assertNotNull(userDto1.getUsername());
        Assertions.assertNotNull(userDto1.getEmail());
        Assertions.assertNotNull(userDto1.getPassword());
    }
}
