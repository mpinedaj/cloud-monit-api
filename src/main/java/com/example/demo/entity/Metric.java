package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "metrics")
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metricName; 
    private Double value;
    private String instanceId; 
    private Boolean isAlert = false;
    private LocalDateTime timestamp;

    private Boolean isAlert = false; 

    public Boolean getIsAlert() { return isAlert; }
    public void setIsAlert(Boolean isAlert) { this.isAlert = isAlert; }

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    public Metric() {}

    public Metric(String metricName, Double value, String instanceId) {
        this.metricName = metricName;
        this.value = value;
        this.instanceId = instanceId;
    }

    public Long getId() { return id; }
    public String getMetricName() { return metricName; }
    public void setMetricName(String metricName) { this.metricName = metricName; }
    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
    public String getInstanceId() { return instanceId; }
    public void setInstanceId(String instanceId) { this.instanceId = instanceId; }
    public Boolean getIsAlert() { return isAlert; }
    public void setIsAlert(Boolean isAlert) { this.isAlert = isAlert; }
    public LocalDateTime getTimestamp() { return timestamp; }
}