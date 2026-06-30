package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Metric;
import com.example.demo.repository.MetricRepository;

@Service
public class MetricService {

    private final MetricRepository repository;

    public MetricService(MetricRepository repository) {
        this.repository = repository;
    }

    public Metric saveMetric(Metric metric) {
        if (metric.getSensorName() == null || metric.getValue() == null) {
            return repository.save(metric);
        }

        switch (metric.getSensorName()) {
            case "CPU-Usage" -> {
                if (metric.getValue() > 90.0) {
                    metric.setIsAlert(true);
                    System.out.println("[ALERTA DEVOPS] ¡Carga de CPU crítica!: " + metric.getValue() + "%");
                }
            }
            case "RAM-Usage" -> {
                if (metric.getValue() > 85.0) {
                    metric.setIsAlert(true);
                    System.out.println("[ALERTA DEVOPS] ¡Consumo de memoria RAM elevado!: " + metric.getValue() + "%");
                }
            }
            case "Disk-Space" -> {
                if (metric.getValue() > 95.0) {
                    metric.setIsAlert(true);
                    System.out.println("[ALERTA CRÍTICA] ¡Servidor casi sin espacio en disco!: " + metric.getValue() + "%");
                }
            }
            default -> System.out.println("[INFORME] Métrica recibida para componente desconocido: " + metric.getSensorName());
        }

        return repository.save(metric);
    }

    public List<Metric> getAllMetrics() {
        return repository.findAll();
    }
}