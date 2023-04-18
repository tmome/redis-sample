package sample.redis.domain.repository;

import org.springframework.data.repository.CrudRepository;
import sample.redis.domain.domain.Product;

public interface RedisProductRepository extends CrudRepository<Product, Long> {
}
