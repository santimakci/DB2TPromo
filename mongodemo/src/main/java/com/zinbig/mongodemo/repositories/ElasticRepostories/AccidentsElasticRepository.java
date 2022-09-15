package com.zinbig.mongodemo.repositories.ElasticRepostories;

import com.zinbig.mongodemo.model.Accident;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentsElasticRepository extends ElasticsearchRepository<Accident, String> {

}
