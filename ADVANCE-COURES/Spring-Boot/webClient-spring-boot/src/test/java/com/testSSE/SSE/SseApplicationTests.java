package com.testSSE.SSE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testSSE.SSE.api.employee.Employee;
import com.testSSE.SSE.api.employee.EmployeeReactiveRepository;
import com.testSSE.SSE.api.employee.EmployeeService;
import com.testSSE.SSE.api.user.User;
import com.testSSE.SSE.api.user.UserService;
import com.testSSE.SSE.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.when;

@SpringBootTest
class SseApplicationTests {
	@Autowired
	private EmployeeService employeeReactiveRepositor;
	@Test
	void testFindAll() {
		// Retrieve the Flux of employees from the repository
		Flux<Employee> employeeFlux = employeeReactiveRepositor.findAll();
		// Subscribe to the Flux and perform assertions or other actions
		employeeFlux
				.doOnNext(employee -> {
					// Perform assertions on each employee, e.g., check properties
					System.out.println(employee);
					// Add your assertions here
				})
				.blockLast(); // Block until all elements are processed (for testing purposes)
		// You can also use StepVerifier for more advanced testing with Reactor
	}


}
