package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.UserConverter;
import workflow.example.workflow.dto.UserDto;
import workflow.example.workflow.entity.User;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserConverterTest {

    @InjectMocks
    private UserConverter userConverter;

    @Test
    void testEntityToDto() {
        User user = createSampleUser();

        UserDto dto = userConverter.entityToDto(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getEmail(), dto.getEmail());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getPassword(), dto.getPassword());
    }

    @Test
    void testEntityToDtoList() {
        List<User> users = Collections.singletonList(createSampleUser());

        List<UserDto> dtoList = userConverter.entityToDto(users);

        assertEquals(users.size(), dtoList.size());
    }

    private User createSampleUser() {
        return new User();
    }
}
