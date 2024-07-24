# ZipZapShorter API

ZipZapShorter é uma API de encurtamento de URL construída com Spring Boot. Esta API permite aos usuários encurtar URLs longas e gerenciar seus URLs encurtados.

## Funcionalidades

- Encurtar URLs
- Listar URLs encurtadas por usuário
- Documentação da API com Swagger

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- Swagger (Springdoc OpenAPI)

## Configuração do Projeto

### Dependências

Certifique-se de que você tem as seguintes dependências no seu `build.gradle`:

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'com.h2database:h2'
    implementation 'org.springdoc:springdoc-openapi-ui:1.7.0' // Atualize para a versão mais recente
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testCompileOnly 'org.projectlombok:lombok'
    testAnnotationProcessor 'org.projectlombok:lombok'
}
