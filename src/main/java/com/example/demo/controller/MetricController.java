package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Metric;
import com.example.demo.service.MetricService;

@RestController
@RequestMapping("/api/metrics")
public class MetricController {

    private final MetricService service;

    public MetricController(MetricService service) {
        this.service = service;
    }

    @PostMapping
    public Metric saveMetric(@RequestBody Metric metric) {
        return service.saveMetric(metric); 
    }

    @GetMapping
    public List<Metric> getAllMetrics() {
        return service.getAllMetrics();
    }

    @GetMapping("/instance/{instanceId}")
    public List<Metric> getMetricsByInstance(@PathVariable String instanceId) {
        return service.getMetricsByInstance(instanceId);
    }
}