package sample.redis.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.redis.domain.domain.Product;

@Getter
@NoArgsConstructor
public class ProductRequestDto {

  private Long id;
  private String productName;
  private Long price;

  @Builder
  public ProductRequestDto(Long id, String productName, Long price) {
    this.id = id;
    this.productName = productName;
    this.price = price;
  }

  public Product buildOfProduct() {
    return Product.builder()
        .id(id)
        .productName(productName)
        .price(price)
        .build();
  }
}
