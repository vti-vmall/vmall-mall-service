package vn.edu.vti.vmall.service.mall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(nullable = false)
  private Integer price;

  @Column(name = "sale_price", nullable = false)
  private Integer salePrice;

  @Column(name = "category_id")
  private Long categoryId;
}
