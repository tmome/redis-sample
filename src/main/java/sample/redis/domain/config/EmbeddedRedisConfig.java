package sample.redis.domain.config;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

@Slf4j
@Configuration
@Profile("local")
@RequiredArgsConstructor
public class EmbeddedRedisConfig {

  private final RedisProperties redisProperties;

  private RedisServer redisServer;

  @PostConstruct
  public void redisServer() {
    redisServer = new RedisServer(redisProperties.getPort());
    redisServer.start();
  }

  @PreDestroy
  public void stopRedis() {
    if (redisServer != null) {
      redisServer.start();
    }
  }
}
