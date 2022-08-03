package com.hugoitu.backend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HugoituBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HugoituBackendApplication.class, args);
                
	}
        
        @Configuration
        public class FirebaseConfig {

            @Bean
            public FirebaseAuth firebaseAuth(){
                return FirebaseAuth.getInstance();
            }

            @PostConstruct
            public void initializeFirebaseApp() throws IOException {
                if (FirebaseApp.getApps().isEmpty()){
                    FileInputStream refreshToken = new FileInputStream("./src/main/resources/static/gkey.json");

                    FirebaseOptions options;
                    options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(refreshToken))
                            .setDatabaseUrl("https://hugoiturrieta-fffd1-default-rtdb.firebaseio.com")
                            .build();
                    FirebaseApp.initializeApp(options);
                }
                    
            }
        }
        
        @Configuration
        public class CorsConfig implements WebMvcConfigurer {
            @Bean
            public WebMvcConfigurer corsConfigurer() {
                    return new WebMvcConfigurer() {
                            @Override
                            public void addCorsMappings(CorsRegistry registry) {
                                    registry.addMapping("/**")
                                    .allowedOrigins("*")
                                    .allowedHeaders("*");
                            }
                    };
            }
        }
        
        
}
