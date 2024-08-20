# Etapa 1: Construir o artefato com Gradle
FROM gradle:8-jdk21 AS build
WORKDIR /app

# Copia o código fonte e os arquivos de configuração do Gradle
COPY build.gradle settings.gradle /app/
COPY src /app/src

# Compila o projeto
RUN gradle build --no-daemon

# Etapa 2: Executar a aplicação
FROM eclipse-temurin:21-jdk AS runtime
WORKDIR /app

# Copia o jar construído na etapa anterior
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Expõe a porta
EXPOSE 5000

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
