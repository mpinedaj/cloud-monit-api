package com.example.demo.controller;

import com.example.demo.entity.Metric;
import com.example.demo.service.MetricService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricController {

    private final MetricService service;

    // Inyectamos el Servicio, no el Repositorio
    public MetricController(MetricService service) {
        this.service = service;
    }

    @PostMapping
    public Metric saveMetric(@RequestBody Metric metric) {
        return service.saveMetric(metric); // <--- Aquí ocurre la magia
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