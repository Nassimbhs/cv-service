package workflow.example.workflow.dto;

import lombok.Data;

import java.io.Serializable;

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