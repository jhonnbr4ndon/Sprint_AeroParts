# AeroParts

## Integrantes do Grupo
- Leonardo Paganini RM96562
- Matheus Leite RM96893
- Jhonn Brandon RM97305
- Regina Pompeo RM97032

## Descrição
Este projeto visa o desenvolvimento de um sistema de automação destinado a simplificar o 
processo de cotação de compras de peças pequenas e médias para a indústria da aviação. No 
âmbito da aviação, a aquisição de peças de alta qualidade é essencial para garantir a segurança 
e eficiência das operações aéreas. O sistema proposto busca otimizar a interação entre 
compradores e fornecedores, oferecendo uma plataforma eficaz para o registro de cotações, 
gerenciamento de fornecedores, pedidos e produtos. A automação desse processo 
proporciona maior eficiência, reduzindo o tempo necessário para obter cotações competitivas 
e facilitando o controle e a análise dos dados de aquisição.

## Vídeo com a apresentação da aplicação funcionando



## Instruções para Rodar a Aplicação
Passo 1: Certifique-se de que você já possui o IntelliJ IDEA instalado e configurado no seu computador. Caso não tenha, você pode baixá-lo no site oficial da JetBrains.

Passo 2: Abra o IntelliJ IDEA e siga os seguintes passos:

Abra o IntelliJ IDEA.

Crie um novo projeto ou abra o projeto existente, dependendo da sua situação. Se você está criando um novo projeto, siga as instruções do assistente de criação de projeto.

Certifique-se de que as dependências do Maven sejam importadas corretamente. O IntelliJ IDEA deve fazer isso automaticamente para você. Se não, você pode clicar com o botão direito do mouse no arquivo "pom.xml" e selecionar a opção "Reimport" para atualizar as dependências.

Passo 3: Configure a fonte de dados e as configurações do Hibernate:

Abra o arquivo "persistence.xml" localizado na pasta "META-INF". Certifique-se de que as configurações de conexão com o banco de dados estejam corretas. Verifique se as informações de driver, URL, usuário e senha do banco de dados estão configuradas corretamente.
Passo 4: Agora, você pode executar sua aplicação. No IntelliJ IDEA, você pode fazer isso da seguinte maneira:

Abra o arquivo "Main.java" localizado na pasta "org.example".

Clique com o botão direito do mouse no código-fonte do "Main.java".

Selecione a opção "Run 'Main.main()'". Isso iniciará a execução do seu programa.

Passo 5: Verifique o console para ver a saída do seu programa. Qualquer mensagem de erro ou saída do sistema será exibida lá.

Isso deve permitir que você execute seu projeto no IntelliJ IDEA. Certifique-se de que todas as configurações e dependências estejam corretas, e você deve conseguir rodar seu projeto sem problemas. Lembre-se de que você precisa ter um banco de dados Oracle configurado e disponível para que o Hibernate possa se conectar corretamente. Certifique-se de que seu banco de dados Oracle esteja ativo e as informações de conexão no "persistence.xml" estejam corretas.

## Diagramas

## Diagrama de Classes
![image](https://github.com/jhonnbr4ndon/AeroParts/assets/112666523/b345cb36-ad4f-46a9-a5b1-25ef7dc1e5e2)

### Modelo Conceitual
![image](https://github.com/jhonnbr4ndon/AeroParts/assets/112666523/06f1e226-f81c-44f3-9084-8d93d49afabc)

## Modelo Logical
![image](https://github.com/jhonnbr4ndon/AeroParts/assets/112666523/a7557adb-83ff-42a3-8f86-6e20344611f4)

## Modelo Relational
![image](https://github.com/jhonnbr4ndon/AeroParts/assets/112666523/654fede9-2c02-4780-9a65-5615fa6752b4)

# Documentação dos Endpoints da API

## Usuario Controller

| Método | Caminho             | Descrição                                | Exemplo de Uso                                            |
|--------|---------------------|------------------------------------------|-----------------------------------------------------------|
| GET    | /usuario/{id}       | Obter informações de um usuário por ID    | `GET /usuario/1`                                          |
| GET    | /usuario            | Obter a lista de todos os usuários         | `GET /usuario`                                            |
| POST   | /usuario            | Criar um novo usuário                     | `POST /usuario` com corpo JSON contendo os dados do usuário|
| PUT    | /usuario/{id}       | Atualizar informações de um usuário por ID| `PUT /usuario/1` com corpo JSON contendo os dados atualizados|
| DELETE | /usuario/{id}       | Deletar um usuário por ID                 | `DELETE /usuario/1`                                       |

## Cotacao Controller

| Método | Caminho             | Descrição                                | Exemplo de Uso                                           |
|--------|---------------------|------------------------------------------|----------------------------------------------------------|
| GET    | /cotacao/{id}       | Obter informações de uma cotação por ID   | `GET /cotacao/1`                                          |
| GET    | /cotacao            | Obter a lista de todas as cotações        | `GET /cotacao`                                           |
| POST   | /cotacao            | Criar uma nova cotação                    | `POST /cotacao` com corpo JSON contendo os dados da cotação|
| PUT    | /cotacao/{id}       | Atualizar informações de uma cotação por ID| `PUT /cotacao/1` com corpo JSON contendo os dados atualizados|
| DELETE | /cotacao/{id}       | Deletar uma cotação por ID                | `DELETE /cotacao/1`                                       |

## Fornecedor Controller

| Método | Caminho             | Descrição                                | Exemplo de Uso                                              |
|--------|---------------------|------------------------------------------|-------------------------------------------------------------|
| GET    | /fornecedor/{id}    | Obter informações de um fornecedor por ID| `GET /fornecedor/1`                                         |
| GET    | /fornecedor         | Obter a lista de todos os fornecedores   | `GET /fornecedor`                                           |
| POST   | /fornecedor         | Criar um novo fornecedor                 | `POST /fornecedor` com corpo JSON contendo os dados do fornecedor|
| PUT    | /fornecedor/{id}    | Atualizar informações de um fornecedor por ID| `PUT /fornecedor/1` com corpo JSON contendo os dados atualizados|
| DELETE | /fornecedor/{id}    | Deletar um fornecedor por ID             | `DELETE /fornecedor/1`                                      |

## ItemPedido Controller

| Método | Caminho             | Descrição                                | Exemplo de Uso                                              |
|--------|---------------------|------------------------------------------|-------------------------------------------------------------|
| GET    | /itempedido/{id}    | Obter informações de um item de pedido por ID| `GET /itempedido/1`                                        |
| GET    | /itempedido         | Obter a lista de todos os itens de pedido| `GET /itempedido`                                          |
| POST   | /itempedido         | Criar um novo item de pedido             | `POST /itempedido` com corpo JSON contendo os dados do item de pedido|
| PUT    | /itempedido/{id}    | Atualizar informações de um item de pedido por ID| `PUT /itempedido/1` com corpo JSON contendo os dados atualizados|
| DELETE | /itempedido/{id}    | Deletar um item de pedido por ID         | `DELETE /itempedido/1`                                     |

## Pedido Controller

| Método | Caminho             | Descrição                                | Exemplo de Uso                                              |
|--------|---------------------|------------------------------------------|-------------------------------------------------------------|
| GET    | /pedido/{id}        | Obter informações de um pedido por ID    | `GET /pedido/1`                                            |
| GET    | /pedido             | Obter a lista de todos os pedidos         | `GET /pedido`                                              |
| POST   | /pedido             | Criar um novo pedido                     | `POST /pedido` com corpo JSON contendo os dados do pedido   |
| PUT    | /pedido/{id}        | Atualizar informações de um pedido por ID| `PUT /pedido/1` com corpo JSON contendo os dados atualizados|
| DELETE | /pedido/{id}        | Deletar um pedido por ID                 | `DELETE /pedido/1`                                         |

## Produto Controller

| Método | Caminho             | Descrição                                | Exemplo de Uso                                              |
|--------|---------------------|------------------------------------------|-------------------------------------------------------------|
| GET    | /produto/{id}       | Obter informações de um produto por ID   | `GET /produto/1`                                           |
| GET    | /produto            | Obter a lista de todos os produtos        | `GET /produto`                                             |
| POST   | /produto            | Criar um novo produto                    | `POST /produto` com corpo JSON contendo os dados do produto |
| PUT    | /produto/{id}       | Atualizar informações de um produto por ID| `PUT /produto/1` com corpo JSON contendo os dados atualizados|
| DELETE | /produto/{id}       | Deletar um produto por ID                | `DELETE /produto/1`                                        |

## Requisição dos Endpoints do **Postman**

[Requisicao Endpoints.zip](https://github.com/jhonnbr4ndon/AeroParts/files/13553633/Requisicao.Endpoints.zip)

## Vídeo de Apresentação

https://github.com/jhonnbr4ndon/GitHub/assets/112666523/1db21d36-4358-4f68-b44f-c39479232c83


## Documentação

[AeroParts.pdf](https://github.com/jhonnbr4ndon/Sprint_AeroParts/files/13553658/AeroParts.pdf)




