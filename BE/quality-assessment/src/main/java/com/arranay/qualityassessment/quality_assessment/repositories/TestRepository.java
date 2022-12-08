package com.arranay.qualityassessment.quality_assessment.repositories;

import com.arranay.qualityassessment.quality_assessment.db_models.TestItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<TestItem, String> {
}
