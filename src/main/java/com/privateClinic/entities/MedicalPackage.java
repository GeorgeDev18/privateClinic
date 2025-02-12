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
@Table(name = "medical_package")
public class MedicalPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "package_id")
    private long packageId;

    @Column(name = "package_code")
    private String packageCode;

    private  String name;
    private BigDecimal price;
    private  Integer discount;


    @ManyToMany(targetEntity = MedicalService.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "package_service",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<MedicalService> services;
}
