package com.challenge.prices.infrastructure.entity.price;

import com.challenge.prices.infrastructure.entity.brand.BrandEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "prices")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class PriceEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native")
	private long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "prices_brand_id_fk"))
	private final BrandEntity brandEntity;

	@Column(name = "start_date", nullable = false)
	private final LocalDateTime startDate;

	@Column(name = "end_date", nullable = false)
	private final LocalDateTime endDate;

	@Column(name = "price_list", nullable = false)
	private final long priceList;

	@Column(name = "product_id", nullable = false)
	private final String productId;

	@Column(name = "priority", nullable = false)
	private final int priority;

	@Column(name = "price", nullable = false)
	private final double price;

	@Column(name = "curr", nullable = false)
	private final String curr;

}
