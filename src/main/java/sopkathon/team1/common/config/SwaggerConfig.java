package sopkathon.team1.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "🚀[솝커톤 API 명세서]",
                description = "안드1팀 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {
}

