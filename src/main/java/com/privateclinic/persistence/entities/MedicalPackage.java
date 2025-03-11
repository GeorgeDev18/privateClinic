package com.privateclinic.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"services"})
@EqualsAndHashCode(exclude = {"services"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "medical_package")
public class MedicalPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "package_id", nullable = false)
    private Long packageId;

    @NotNull
    @Column(name = "package_code", nullable = false)
    private String packageCode;

    @NotNull
    @Column(nullable = false)
    private  String name;

    @NotNull
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull
    @Column(nullable = false)
    private  Integer discount;



    @ManyToMany(targetEntity = MedicalService.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "package_service",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<MedicalService> services;




}
