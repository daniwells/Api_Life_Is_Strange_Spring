# Api - Life is Strange

A api Life is Strange nada mais é do que um estudo sobre o desenvolvimento de APIs com Spring Boot e Java Hibernate. Esta contempla principalmente cruds e endpoints completos, juntamente com uma organização de projeto baseada no modelo DTO (Data Transfer Object).

## Importante :loudspeaker:
Antes de tudo, é importante observar que este projeto foi divídido em duas versões separadas por branches, na branch <b>"main"</b> você encontrará um sistema sem qualquer conexão com um banco de dados relacional, apenas com vetores e arrays usados para armazenar dados temporariamente, já a segunda versão é encontrada na branch <b>"fullApi"</b> a qual não só consta uma conxão com o postgres, como diversos outros mecânismos e tecnologias que estão descritos neste documento.

## Documentação API :book:
Toda a nossa documentação foi desenvolvida de forma automática e dinâmica, usando a biblioteca swagger, com ela você poderá verificar os nossos endpoints e modelos.

Link: https://app.swaggerhub.com/apis/DANIELLIMAFREITA/apilifeisstrange/1.0.0

## Tecnologias Utilizadas :hammer:
* [Java](https://www.java.com/pt-BR/) - Linguagem de Programação
* [Spring Boot](https://spring.io/) - Framework
* [Hibernate](https://hibernate.org/) - Ferramenta ORM
* [Liquibase](https://www.liquibase.com/) - Gerenciador de migrações
* [Swagger](https://swagger.io/) - Documentação
* [PostgreSQL](https://www.postgresql.org/) - Banco de dados
* [Docker](https://www.docker.com/) - Gerenciador de containers

## Dependências necessárias :arrow_up:
    Docker - Versão 27.3.1
    Docker Compose
    
## Como executar o projeto :mortar_board:

Para executar este projeto, certifique-se de possuir o "Docker" instalado na sua máquina, recomendamos o Docker CLI, pois é o que será apresentado nesse tutorial.

#### 🔴 1. Faça o pull da imagem
No terminal execute o seguinte comando abaixo para puxar a imagem do projeto no docker hub para a sua máquina:

    docker pull daniwellslemons/lifeisstrange
    
#### 🔴 2. Instanciar e executar o container
Para abrir a imagem do projeto, agora na sua máquina, primeiro será necessário inicializar um container:

    docker run -d daniewllslemons/lifeisstrange

Em seguida você pode executar o container em um terminal terminal para interagir diretamente com a aplicação. (Utilizamos o bash como exemplo)

    docker exec -it <id_container> bash

Caso você queira conferir a extrutura do nosso projeto, abra em algum editor de texto, aqui utilizamos o vscode:

    code --folder-uri "vscode-remote://attached-container+daniwellslemons/lifeisstrange/"

#### 🔴 3. Executar docker compose
Para iniciar todos os processo da aplicação, incluindo a api e o banco de dados, você pecisará realizar o start da composição, então confira que você está na raíz do projeto e execute o comando abaixo:

    docker compose up --build 

<b>Com essas configurações você já poderá aproveitar o nosso sistema!</b>

## Licença :page_with_curl:

O site Ritmo da Forma está sob a licença [GPL LICENSE](LICENCE).

## Autores :black_nib:

[@daniwells](https://github.com/daniwells) - Daniel Lima <br>
[@lewinott](https://github.com/lewinott) - Levi Pinott
