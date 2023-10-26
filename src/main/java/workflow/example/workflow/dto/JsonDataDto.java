package workflow.example.workflow.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class JsonDataDto {

    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String data;
    private Long responsable;
    private String etat;

}
