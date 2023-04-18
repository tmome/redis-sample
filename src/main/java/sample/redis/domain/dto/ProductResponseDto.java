package sample.redis.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.redis.domain.domain.Product;

@Getter
@NoArgsConstructor
public class ProductResponseDto {
  private Long id;
  private String productName;
  private Long price;


  public ProductResponseDto(final Product product) {
    this.id = product.getId();
    this.productName = product.getProductName();
    this.price = product.getPrice();
  }

}
