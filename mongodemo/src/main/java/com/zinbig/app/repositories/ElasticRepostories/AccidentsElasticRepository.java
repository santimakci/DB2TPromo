package com.zinbig.app.repositories.ElasticRepostories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.zinbig.app.model.Accident;

@Repository
public interface AccidentsElasticRepository extends ElasticsearchRepository<Accident, String> {

}
