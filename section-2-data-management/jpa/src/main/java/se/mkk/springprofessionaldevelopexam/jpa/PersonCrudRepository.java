package se.mkk.springprofessionaldevelopexam.jpa;

import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

    // Appendix C: Repository query keywords
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
}
