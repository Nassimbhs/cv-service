package workflow.example.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TacheDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date startDate;
    private Date endDate;
    private String statut;
    private String triggerType;
    private String action;
    private String approbation;

    private List<LienTacheDto> lienTacheDtos = new ArrayList<>();
    private List<TacheAtraiterDto> tacheAtraiterDtos = new ArrayList<>();

}
