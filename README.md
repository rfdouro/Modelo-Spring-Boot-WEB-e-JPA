# Modelo-Spring-Boot-WEB-e-JPA
Template de projeto Netbeans - [Maven SpringBoot + WEB + MVC + JPA]

2018-10-26: Adicionado o filter para utilização de token Authorization na leitura de dados (fonte em: http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/)
          Obs. para 
           @SuppressWarnings("deprecation")
           @Bean
           public static NoOpPasswordEncoder passwordEncoder() {
            return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
           }
