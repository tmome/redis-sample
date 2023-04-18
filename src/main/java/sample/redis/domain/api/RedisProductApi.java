package sample.redis.domain.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.redis.domain.application.RedisProductService;
import sample.redis.domain.domain.Product;
import sample.redis.domain.dto.ProductRequestDto;
import sample.redis.domain.dto.ProductResponseDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RedisProductApi {

  private final RedisProductService redisProductService;

  @PostMapping("/save/product")
  public Long saveProduct(@RequestBody final ProductRequestDto productRequestDto) {
    return redisProductService.save(productRequestDto);
  }

  @GetMapping("get/{id}")
  public ProductResponseDto findByProduct(@PathVariable final Long id) {
    return redisProductService.getProduct(id);
  }
}
