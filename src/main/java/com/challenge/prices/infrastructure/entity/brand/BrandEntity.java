package com.challenge.prices.infrastructure.entity.brand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "brands")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class BrandEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native")
	private long id;

	@Column(name = "name", nullable = false)
	private final String name;

}
