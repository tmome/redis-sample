package sample.redis.domain.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sample.redis.domain.application.RedisProductService;
import sample.redis.domain.domain.Product;
import sample.redis.domain.dto.ProductResponseDto;


@RunWith(SpringRunner.class)
@SpringBootTest
class RedisProductRepositoryTest {

  @Autowired
  private RedisProductRepository redisProductRepository;

  private RedisProductService redisProductService;

  @BeforeEach
  public void init() {
    redisProductService = new RedisProductService(redisProductRepository);
  }

  @Test
  @DisplayName("기본 저장 확인 테스트")
  void basic_save() {

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


  @Test
  @DisplayName("기본 조회 테스트")
  void basic_search() {
    //given
    final var id = 0L;
    final var productName = "testName";
    final var price = 10000L;

    final var build = Product.builder()
        .id(id)
        .productName(productName)
        .price(price)
        .build();

    //when
    final var save = redisProductRepository.save(build);

    final var searchRedis = redisProductService.getProduct(save.getId());
    //then
    Assertions.assertThat(searchRedis).isNotNull()
        .isInstanceOf(ProductResponseDto.class)
        .extracting("productName")
        .isEqualTo(build.getProductName());
  }
}