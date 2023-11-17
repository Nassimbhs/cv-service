package workflow.example.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LienTacheDto implements Serializable {

    private Long id;
    private String source;
    private String target;
    private String workflowId;
    private String tacheSourceName;
    private String tacheTargetName;
    private String type;

}