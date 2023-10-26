package workflow.example.workflow.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workflow.example.workflow.converter.CvConverter;
import workflow.example.workflow.dto.CvDto;
import workflow.example.workflow.entity.Cv;
import workflow.example.workflow.service.CvService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Cv")
@Tag(name = "Cv", description = "CRUD Cv")
@CrossOrigin(origins = "http://localhost:4200")
public class CvController {
    @Autowired
    private CvService cvService;
    @Autowired
    private CvConverter cvConverter;

    @PostMapping("/{tacheAtraiterId}")
    public ResponseEntity<CvDto> createCv(@RequestBody Cv cv, @PathVariable Long tacheAtraiterId) {
        Cv createdCv = cvService.createCV(cv, tacheAtraiterId);
        CvDto cvDto = cvConverter.entityToDto(createdCv);
        return ResponseEntity.ok(cvDto);
    }

    @GetMapping("/getCv/{id}")
    public ResponseEntity<CvDto> getCvById(@PathVariable Long id) {
        Cv cv = cvService.getCvById(id)
                .orElse(null);
        if (cv != null) {
            CvDto cvDto = cvConverter.entityToDto(cv);
            return ResponseEntity.ok(cvDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{cvId}/assign/{tacheAtraiterId}")
    public ResponseEntity<CvDto> assignCvToTacheAtraiter(
            @PathVariable Long cvId,
            @PathVariable Long tacheAtraiterId
    ) {
        Cv cv = cvService.assignCvToTacheAtraiter(cvId, tacheAtraiterId);
        CvDto cvDto = cvConverter.entityToDto(cv);
        if (cvDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cvDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAllCvs")
    public List<CvDto> getAllCvs() {
        return cvConverter.entityToDto(cvService.getAllCvs());
    }
    @GetMapping("/tacheAtraiter/{id}")
    public ResponseEntity<List<CvDto>> getCvByTacheAtraiterId(@PathVariable("id") Long tacheAtraiterId) {
        List<CvDto> cvList = cvConverter.entityToDto(cvService.getCvByTacheAtraiterId(tacheAtraiterId));
        if (!cvList.isEmpty()) {
            return ResponseEntity.ok(cvList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{tacheAtraiterId}")
    public ResponseEntity<CvDto> getCvWithCompetencesAndFormations(
            @PathVariable Long tacheAtraiterId) {

        CvDto cvDto = cvConverter.entityToDto(cvService.getCvWithCompetencesAndFormations(tacheAtraiterId));
        if (cvDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cvDto);
    }

    @GetMapping("findCvByWorkflow/{workflowId}")
    public CvDto findCvByWorkflow(@PathVariable Long workflowId){
        return cvConverter.entityToDto(cvService.findCvByWorkflow(workflowId));
    }

}