package workflow.example.workflow.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private List<LienTacheDto> lienTacheDtos = new ArrayList<LienTacheDto>();
    //private List<UserDto> userDtoList = new ArrayList<UserDto>();
    private List<TacheAtraiterDto> tacheAtraiterDtos = new ArrayList<TacheAtraiterDto>();

}
