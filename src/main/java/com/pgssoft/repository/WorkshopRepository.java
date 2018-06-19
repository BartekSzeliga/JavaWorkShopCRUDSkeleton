package com.pgssoft.repository;

import com.pgssoft.domain.Workshop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkshopRepository extends MongoRepository<Workshop, String> {
}
