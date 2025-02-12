package com.privateClinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medical_service")
public class MedicalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "service_id")
    private long serviceId;

    @Column(name = "service_code")
    private String serviceCode;

    private String name;
    private String description;
    private BigDecimal price;

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private List<MedicalPackage> packages;

}
