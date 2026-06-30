package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Metric;
import com.example.demo.repository.MetricRepository;

@RestController
@RequestMapping("/api/metrics")
public class MetricController {

    private final MetricRepository repository;

    public MetricController(MetricRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Metric saveMetric(@RequestBody Metric metric) {
        return repository.save(metric);
    }

    @GetMapping
    public List<Metric> getAllMetrics() {
        return repository.findAll();
    }
}