package workflow.example.workflow.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import workflow.example.workflow.entity.Cv;
import workflow.example.workflow.entity.TacheAtraiter;
import workflow.example.workflow.repository.CvRepository;
import workflow.example.workflow.repository.TacheAtraiterRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CvService {
    private final CvRepository cvRepository;
    private final TacheAtraiterRepository tacheAtraiterRepository;

    private final WebClient webClient;

    public CvService(WebClient.Builder webClientBuilder, CvRepository cvRepository, TacheAtraiterRepository tacheAtraiterRepository) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8091").build();
        this.cvRepository = cvRepository;
        this.tacheAtraiterRepository = tacheAtraiterRepository;
    }

    public Cv createCV(Cv cv, Long tacheAtraiterId) {
        TacheAtraiter tacheAtraiter = webClient
                .get()
                .uri("/api/v1/TacheAtraiter/getTacheAtraiter/"+tacheAtraiterId)
                .retrieve().bodyToMono(TacheAtraiter.class)
                .block();

        assert tacheAtraiter != null;
        log.info("TacheAtraiter : {}",tacheAtraiter);

        cv.getCompetences().forEach(competence -> competence.setCv(cv));
        cv.getFormations().forEach(formation -> formation.setCv(cv));
        cv.getInterets().forEach(interet -> interet.setCv(cv));
        cv.getLangues().forEach(langue -> langue.setCv(cv));
        cv.getExperiences().forEach(experience -> experience.setCv(cv));
        tacheAtraiter = tacheAtraiterRepository.save(tacheAtraiter);
        cv.getTachesAtraiter().add(tacheAtraiter);

        return cvRepository.save(cv);
    }

    public Optional<Cv> getCvById(Long id) {
        return cvRepository.findById(id);
    }

    @Transactional
    public Cv assignCvToTacheAtraiter(Long cvId, Long tacheAtraiterId) {
        Cv cv = cvRepository.findById(cvId).orElse(null);
        TacheAtraiter tacheAtraiter = webClient
                .get()
                .uri("/api/v1/TacheAtraiter/getTacheAtraiter/{tacheAtraiterId}", tacheAtraiterId)
                .retrieve()
                .bodyToMono(TacheAtraiter.class)
                .block();

        if (tacheAtraiter == null) {
            throw new RuntimeException("TacheAtraiter non trouvé");
        }

        if (cv != null) {
            cv.getTachesAtraiter().add(tacheAtraiter);
            webClient
                    .post()
                    .uri("/api/v1/TacheAtraiter/updateTacheAtraiter")
                    .bodyValue(tacheAtraiter)
                    .retrieve()
                    .toBodilessEntity()
                    .block();
            cvRepository.save(cv);
        }
        return cv;
    }
    public List<Cv> getAllCvs() {
        return cvRepository.findAll();
    }
    public List<Cv> getCvByTacheAtraiterId(Long tacheAtraiterId) {
        return cvRepository.findByTachesAtraiterId(tacheAtraiterId);
    }
    public Cv getCvWithCompetencesAndFormations(Long tacheAtraiterId) {
        return cvRepository.findByIdWithCompetencesAndFormations(tacheAtraiterId);
    }

    public Cv findCvByWorkflow(Long workflowId){
        return cvRepository.findCvByWorkflow(workflowId);
    }

}