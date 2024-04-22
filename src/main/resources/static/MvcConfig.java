

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("././com.fiap.gerenciadorescolar.controller/")
          .addResourceLocations("/com.fiap.gerenciadorescolar.controller/");
    }
}
