package com.marsvisit.mars_visit_application.repository;

import com.marsvisit.mars_visit_application.model.MarsApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarsApplicationRepository extends CrudRepository<MarsApplication, Long> {
}
