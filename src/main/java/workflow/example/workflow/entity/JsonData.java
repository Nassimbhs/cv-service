package workflow.example.workflow.entity;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class JsonData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String data;
    private Long responsable;
    private String etat;

    @ManyToMany(mappedBy = "jsonDatas")
    private List<TacheAtraiter> tachesAtraiter = new ArrayList<>();

}
