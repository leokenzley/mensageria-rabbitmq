# microservico-mensageria

![Build Status](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Build Status](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white) ![Build Status](https://img.shields.io/badge/rabbitmq-%23FF6600.svg?&style=for-the-badge&logo=rabbitmq&logoColor=white) ![Build Status](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

### Features
- Conecta com RabbitMQ [(producer-j)](https://github.com/leokenzley/mensageria-rabbitmq/tree/main/producer-j/README.md)
- Cria a fila preço [(producer-j)](https://github.com/leokenzley/mensageria-rabbitmq/tree/main/producer-j/README.md)
- Endpoint para enviar as mensagens para o RabbitMQ [(producer-j)](https://github.com/leokenzley/mensageria-rabbitmq/tree/main/producer-j/README.md)
- Consumidor da fila preço [(consumer-kt)](https://github.com/leokenzley/mensageria-rabbitmq/blob/main/consumer-kt/README.md)

### Configuração do ambiente
##### Acesse o repositório ./.dev/docker/ na raiz do projeto e execute o comando
```sh
$ docker-compose up -d
```
#### Exemplos 
##### A collection com o environment está disponível no repositório /.dev/collection/
