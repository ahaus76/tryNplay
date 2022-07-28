package com.example.demo.elastic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/service/commercedata")
@Service
public class CommerceDataService {

    private CommerceDataRepository repository;

    @Autowired
    public void setRepository(CommerceDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CommerceData> findAll() {
        Iterable<CommerceData> dataIterator = repository.findAll();
        LinkedList<CommerceData> data = new LinkedList<>();

        dataIterator.forEach(data::add);

        return data;
    }

    public void save(CommerceData commerceData) {
        repository.save(commerceData);
    }
}
