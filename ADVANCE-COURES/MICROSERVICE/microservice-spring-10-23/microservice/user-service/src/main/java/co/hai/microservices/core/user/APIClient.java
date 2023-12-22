package co.hai.microservices.core.user;

import co.hai.microservices.core.user.api.web.DepartmentDto;
import co.hai.microservices.core.user.api.web.DepartmentFallbackDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RateLimiter(name = "external",fallbackMethod = "fallback")
@FeignClient(value = "department-service", url = "http://localhost:9095/api/v1/departments")
public interface APIClient {
    @GetMapping("/{id}")
    DepartmentFallbackDto getDepartmentById(@PathVariable("id") Long departmentId);

    default void fallback(Exception e){
        throw new CustomException(
                "Department service is not available",
                "UNAVAILABLE",500);
    }
}
