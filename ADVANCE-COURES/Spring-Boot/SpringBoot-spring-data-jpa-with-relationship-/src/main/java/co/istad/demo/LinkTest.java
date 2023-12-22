package co.istad.demo;

import org.junit.Test;
import org.springframework.hateoas.Link;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkTest {
    @Test
    public void testLinkExpansion() {
        // Create a link template with placeholders
        Link link = Link.of("/{segment}/something{?parameter}");

        // Assert that the link is templated
        assertThat(link.isTemplated()).isTrue();

        // Assert that the variable names are as expected
        assertThat(link.getVariableNames()).contains("segment", "parameter");

        // Prepare values for expansion
        Map<String, Object> values = new HashMap<>();
        values.put("segment", "path");
        values.put("parameter", 42);

        // Expand the link using the provided values
        String expandedHref = link.expand(values).getHref();

        // Assert that the expanded URL matches the expected URL
        assertThat(expandedHref).isEqualTo("/path/something?parameter=42");
    }
}
