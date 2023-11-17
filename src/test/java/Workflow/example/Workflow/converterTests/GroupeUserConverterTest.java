package Workflow.example.Workflow.converterTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.converter.GroupeUserConverter;
import workflow.example.workflow.dto.GroupeUserDto;
import workflow.example.workflow.entity.GroupeUser;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class GroupeUserConverterTest {

    @InjectMocks
    private GroupeUserConverter groupeUserConverter;

    @Test
    void testEntityToDto() {
        GroupeUser groupeUser = createSampleGroupeUser();

        GroupeUserDto dto = groupeUserConverter.entityToDto(groupeUser);

        assertEquals(groupeUser.getId(), dto.getId());
        assertEquals(groupeUser.getNom(), dto.getNom());
        assertEquals(groupeUser.getDescription(), dto.getDescription());
    }

    @Test
    void testEntityToDtoList() {
        List<GroupeUser> groupeUserList = Collections.singletonList(createSampleGroupeUser());

        List<GroupeUserDto> dtoList = groupeUserConverter.entityToDto(groupeUserList);

        assertEquals(groupeUserList.size(), dtoList.size());
    }

    private GroupeUser createSampleGroupeUser() {
        return new GroupeUser();
    }

}
