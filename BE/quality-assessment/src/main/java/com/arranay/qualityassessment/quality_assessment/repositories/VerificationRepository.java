package com.arranay.qualityassessment.quality_assessment.repositories;

import com.arranay.qualityassessment.quality_assessment.db_models.VerificationItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationRepository extends MongoRepository<VerificationItem, String> {
}
