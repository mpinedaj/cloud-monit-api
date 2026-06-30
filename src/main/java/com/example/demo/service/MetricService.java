package com.example.demo.service;

import com.example.demo.entity.Metric;
import com.example.demo.repository.MetricRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MetricService {

    private final MetricRepository repository;

    public MetricService(MetricRepository repository) {
        this.repository = repository;
    }

    public Metric saveMetric(Metric metric) {
        if (metric.getMetricName() == null || metric.getValue() == null) {
            return repository.save(metric);
        }

        String server = metric.getInstanceId() != null ? metric.getInstanceId() : "UNKNOWN_HOST";

        switch (metric.getMetricName()) {
            case "cpu_usage" -> {
                if (metric.getValue() > 90.0) {
                    metric.setIsAlert(true);
                    System.out.println("[ALERTA] ¡Carga de CPU crítica en " + server + "!: " + metric.getValue() + "%");
                }
            }
            case "memory_utilization" -> {
                if (metric.getValue() > 85.0) {
                    metric.setIsAlert(true);
                    System.out.println("[ALERTA] ¡Consumo de RAM elevado en " + server + "!: " + metric.getValue() + "%");
                }
            }
            case "disk_use" -> {
                if (metric.getValue() > 95.0) {
                    metric.setIsAlert(true);
                    System.out.println("[CRÍTICO] ¡Almacenamiento casi lleno en " + server + "!: " + metric.getValue() + "%");
                }
            }
            default -> System.out.println("Métrica registrada para: " + metric.getMetricName() + " en " + server);
        }

        return repository.save(metric); 
    }

    public List<Metric> getAllMetrics() {
        return repository.findAll();
    }

    public List<Metric> getMetricsByInstance(String instanceId) {
        return repository.findByInstanceId(instanceId);
    }
}