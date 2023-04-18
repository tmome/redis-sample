package sample.redis.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.redis.domain.dto.ProductRequestDto;
import sample.redis.domain.dto.ProductResponseDto;
import sample.redis.domain.repository.RedisProductRepository;

@RequiredArgsConstructor
@Service
public class RedisProductService {

  private final RedisProductRepository redisProductRepository;


  @Transactional
  public Long save(final ProductRequestDto productRequestDto) {
    return redisProductRepository.save(productRequestDto.buildOfProduct()).getId();
  }

  public ProductResponseDto getProduct(final Long id) {
    return redisProductRepository.findById(id)
        .map(ProductResponseDto::new)
        .orElseThrow(() -> new IllegalArgumentException("해당 아이디를 찾을 수 없습니다."));
  }
}
