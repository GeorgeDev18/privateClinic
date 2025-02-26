package com.privateclinic.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"packages"})
@EqualsAndHashCode(exclude = {"packages"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "medical_service")
public class MedicalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    @Column(name = "service_id", nullable = false)
    private Long serviceId;

    @NotNull
    @Column(name = "service_code",nullable = false)
    private String serviceCode;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull
    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private List<MedicalPackage> packages;

}
