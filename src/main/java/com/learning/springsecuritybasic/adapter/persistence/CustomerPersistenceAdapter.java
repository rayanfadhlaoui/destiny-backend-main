package com.learning.springsecuritybasic.adapter.persistence;


import com.learning.springsecuritybasic.model.persistence.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerPersistenceAdapter extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByEmail(String email);
}
