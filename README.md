
# MS User 👤

O MS User é responsável por armazenar e gerenciar dados de usuários. Este serviço oferece endpoints para realizar operações como login, cadastro, busca e atualização de usuários.

### Endpoints 🛣️ 
Responda as perguntas corretas e some pontos!

#### 1. Cadastro de Usuário ✨
**Método:** POST

**Endpoint:** /v1/users

**Payload de Exemplo:**  
{   
  "firstName": "Maria",  
  "lastName": "Oliveira",  
  "cpf": "000.000.000-00",  
  "birthdate": "0000-00-00",  
  "email": "maria@email.com",  
  "cep": "69999-999",  
  "password": "12345678",  
  "active": true  
}

#### 2. Login de Usuário 🔐
**Método:** POST

**Endpoint:** /v1/login

**Payload de Exemplo:**  
{  
  "email": "maria@email.com",  
  "password": "12345678"  
}

#### 3. Busca de Usuário por ID 🔍
**Método:** POST

**Endpoint:** /v1/users/:id

#### 4. Atualização de Dados do Usuário 🔄
**Método:** PUT

**Endpoint:** /v1/users/:id

**Payload de Exemplo:**  
{  
  "firstName": "Maria",  
  "lastName": "Silva",  
  "email": "maria@email.com",  
  "cep": "69999-999",  
  "active": true  
}

#### 5. Alteração de Senha do Usuário 🔑
**Método:** PUT

**Endpoint:** /v1/users/:id/password

**Payload de Exemplo:**  
{  
  "password": "12345678"  
}


### Ferramentas Utilizadas 🛠️
* IntelliJ IDEA  
* Postman  
* MySQL Workbench  
* Docker  
* Git  

### Dicas  💡
Certifique-se de ter essas ferramentas instaladas para contribuir e trabalhar no projeto de forma eficiente. Utilize o MySQL Workbench para gerenciar o banco de dados e o Docker para containerização, facilitando a configuração do ambiente de desenvolvimento. O Git é utilizado para controle de versão, e o IntelliJ IDEA é a IDE recomendada para o desenvolvimento. O Postman é útil para testar os endpoints. 🚀

### Duvidas e Dificuldades 📦
Durante o desenvolvimento da aplicação, enfrentei desafios que contribuíram para o aprimoramento contínuo. Questões como validações de usuário, criptografia de senhas e controle de acesso demandaram atenção especial. A formatação adequada de datas na resposta e a configuração do ambiente Docker também foram pontos-chave. Essas dificuldades foram superadas por meio de pesquisa, colaboração com a equipe e aprendizado prático, resultando em uma compreensão mais profunda e refinada da aplicação.
