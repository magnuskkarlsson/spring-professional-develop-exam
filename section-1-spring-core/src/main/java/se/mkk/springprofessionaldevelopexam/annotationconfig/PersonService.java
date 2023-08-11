package se.mkk.springprofessionaldevelopexam.annotationconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class PersonService {
    private final Optional<PersonRepository> personRepository;
    private final CarService carService;

    @Autowired(required = false)
    public PersonService(Optional<PersonRepository> personRepository, @Qualifier("lazy") CarService carService) {
        this.personRepository = personRepository;
        this.carService = carService;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("***** @PostConstruct *****");
    }

    // called if shutdown normally, NOT if process dies or is killed
    @PreDestroy
    public void preDestroy() {
        System.out.println("***** @PreDestroy *****");
    }

    public void exec() throws IllegalStateException {
        // personRepository.orElseThrow(() -> new IllegalStateException("NOT SET")).exec();
        personRepository.ifPresent(repo -> repo.exec());
    }

    public int getStatus() {
        return carService.getStatus();
    }
}
