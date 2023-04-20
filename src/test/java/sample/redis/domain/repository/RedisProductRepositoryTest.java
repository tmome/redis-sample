package sample.redis.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sample.redis.domain.domain.Product;


@RunWith(SpringRunner.class)
@SpringBootTest
class RedisProductRepositoryTest {

  @Autowired
  private RedisProductRepository redisProductRepository;

  @Test
  @DisplayName("기본 저장 확인 테스트")
  void basic_search() {

    //given
    final var id = 0L;
    final var productName = "testName";
    final var price = 100L;

    final var build = Product.builder()
        .id(id)
        .productName(productName)
        .price(price)
        .build();

    //when
    final var save = redisProductRepository.save(build);


    //then
    Assertions.assertThat(save).isNotNull()
        .isInstanceOf(Product.class)
        .extracting("productName")
        .isEqualTo(build.getProductName());
  }

}