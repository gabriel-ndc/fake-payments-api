# Fake Payments Api

Aplicação em Spring Boot que serve como uma api fake de pagamentos 
para ser chamado por outro serviço.

Consiste em apenas um endpoint.

## Docker

### Build

Primeiro, rodar o comando `package` do maven, para gerar o arquivo
`.jar` na pasta `target`.

Depois, garantir que se tem o agent Java do AppDynamics na pasta raiz
do projeto, em uma pasta com o nome `AppServerAgent`.

Por fim, rodar a partir da pasta raiz do projeto:

```shell
docker build -t fake-payments-api .
```

### Run

Para subir a aplicação, primeiro criar um arquivo `.env` na raiz do 
projeto.
Colocar nesse arquivo o AccessKey da conta do AppDynamics, conforme o
arquivo `.env.example`.

Por fim, rodar:

```shell
docker run -d -p 8081:8081 --env-file=.env --name fake-payments-api -it fake-payments-api
```