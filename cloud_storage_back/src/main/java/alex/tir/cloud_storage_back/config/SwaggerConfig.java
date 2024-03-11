package alex.tir.cloud_storage_back.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "api_key", in = SecuritySchemeIn.HEADER)
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "springdoc-openapi", version = "1.0.0"),
        security = {@SecurityRequirement(name = "api_key")})
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Cloud Storage Api")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("alextir2@mail.ru")
                                                .name("Alex Kosiuk")
                                )
                );
    }

}
