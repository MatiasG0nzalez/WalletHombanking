# Establecer la imagen base con Java 11
FROM openjdk:11

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

COPY . .

RUN ./gradlew build

CMD ["./gradlew", "bootRun"]
