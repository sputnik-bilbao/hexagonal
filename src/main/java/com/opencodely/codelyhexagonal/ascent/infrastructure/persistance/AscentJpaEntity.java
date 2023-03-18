package com.opencodely.codelyhexagonal.ascent.infrastructure.persistance;

import com.opencodely.codelyhexagonal.climber.infrastructure.persistance.ClimberJpaEntity;
import com.opencodely.codelyhexagonal.route.infrastructure.persistance.RouteJpaEntity;
import com.opencodely.codelyhexagonal.shared.domain.Grade;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ascent")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AscentJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ClimberJpaEntity climber;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private RouteJpaEntity route;
    @Enumerated(EnumType.STRING)
    private Grade proposedGrade;
    private LocalDate ascensionDate = LocalDate.now();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        AscentJpaEntity that = (AscentJpaEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
