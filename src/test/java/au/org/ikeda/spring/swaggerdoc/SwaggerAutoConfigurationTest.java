package au.org.ikeda.spring.swaggerdoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SwaggerAutoConfiguration.class})
public class SwaggerAutoConfigurationTest {

    @Test
    public void testNothing() {
        assertTrue(true);
    }
}
