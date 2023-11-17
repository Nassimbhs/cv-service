package Workflow.example.Workflow.entitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import workflow.example.workflow.entity.JsonData;
import workflow.example.workflow.entity.TacheAtraiter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class JsonDataEntityTest {

    @Test
    void testJsonDataEqualsAndHashCode() {
        JsonData jsonData1 = new JsonData(1L, "{\"key\":\"value\"}", 123L, "Pending", new ArrayList<>());
        JsonData jsonData2 = new JsonData(1L, "{\"key\":\"value\"}", 123L, "Approved", new ArrayList<>());

        Assertions.assertEquals(jsonData1, jsonData2);
        Assertions.assertEquals(jsonData1.hashCode(), jsonData2.hashCode());
    }

    @Test
    void testJsonDataNotEquals() {
        JsonData jsonData1 = new JsonData(1L, "{\"key\":\"value\"}", 123L, "Pending", new ArrayList<>());
        JsonData jsonData2 = new JsonData(2L, "{\"key\":\"value2\"}", 456L, "Approved", new ArrayList<>());

        Assertions.assertNotEquals(jsonData1, jsonData2);
    }

    @Test
    void testJsonDataTachesAtraiterRelationship() {
        JsonData jsonData = new JsonData();
        TacheAtraiter tacheAtraiter = mock(TacheAtraiter.class);

        List<TacheAtraiter> tachesAtraiterList = new ArrayList<>();
        tachesAtraiterList.add(tacheAtraiter);

        jsonData.setTachesAtraiter(tachesAtraiterList);

        Assertions.assertEquals(tachesAtraiterList, jsonData.getTachesAtraiter());
    }

    @Test
    void testToString() {
        JsonData jsonData = new JsonData();
        jsonData.setId(1L);
        jsonData.setData("{\"key\": \"value\"}");
        jsonData.setResponsable(123L);
        jsonData.setEtat("InProgress");

        Assertions.assertNotNull(jsonData.toString());
    }

    @Test
    void testEquals() {
        JsonData data1 = new JsonData();
        data1.setId(1L);

        JsonData data2 = new JsonData();
        data2.setId(1L);

        JsonData data3 = new JsonData();
        data3.setId(2L);

        Assertions.assertEquals(data1, data2);
        Assertions.assertNotEquals(data1, data3);
    }

    @Test
    void testHashCode() {
        JsonData jsonData = new JsonData();
        jsonData.setId(1L);

        Assertions.assertEquals(jsonData.hashCode(), jsonData.getClass().hashCode());
    }

}
