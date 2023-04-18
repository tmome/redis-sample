package sample.redis.domain.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("product")
public class Product {

  @Id
  private Long id;
  private String productName;
  private Long price;

  @Builder
  public Product(Long id, String productName, Long price) {
    this.id = id;
    this.productName = productName;
    this.price = price;
  }
}
