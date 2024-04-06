package br.com.aeroparts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI Documentacao() {
        Server apiServer = new Server();
        apiServer.setUrl("http://localhost:8080");
        apiServer.description("Challenge - Level Group");

        Contact dados = new Contact();
        dados.setName("Jhonn");
        dados.setName("Regina");
        dados.setName("Leonardo");

        Info info = new Info().title("Level Group")
                        .version("3")
                                .description("Desenvolvimento do sprint 3");
        return new OpenAPI().info(info).servers(List.of(apiServer));
    }

}
