package com.example.demo.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommerceDataRepository extends ElasticsearchRepository<CommerceData, String> {
}
