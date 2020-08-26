
# persistenceMongoDB
> Sistema de cadastro de produtos e pedidos em um portal de e-commerce, utilizando banco de dados MongoDB

## Para começar

### Passo 1
- **Clone**
  - Clonar esse repositório em sua máquina local utilizando a URL `https://github.com/andreAlbuquerqueHub/persistenceMongoDB.git`

### Passo 2
- **Configuração**
  - Incluir todas as dependências que estão em `lib/*` no Build Path do projeto.
  - Executar o `lib/lombok.jar` para a instalação/atualização.
  - Atualizar o arquivo application.properties que está na pasta src/main/resources, com os dados de conexão do MongoDB 

### Passo 3
  - **Execução**
    - Para testar via REST API executar a classe LojaMongoApplication.java
    - Para testar apenas execução dos métodos executados no banco executar LojaMongoApplicationTestMain.java ( para essa execução comentar/remover a annotation @EnableMongoRepositories da classe anterior)


## Documentação
- Para acessar a documentação da API, é necessario acessar http://localhost:8080/api/swagger-ui.html#/
