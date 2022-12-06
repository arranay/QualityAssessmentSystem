package com.arranay.qualityassessment.quality_assessment.repositories;

import com.arranay.qualityassessment.quality_assessment.db_models.DocumentItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<DocumentItem, String> {
}
