
# Vai Na Web Módulo 2 - Turma Backend - Desafio Final 

O projeto consiste na construção de uma API que realiza as 4 operações CRUD para as entidades propostas, cujo as entidades do projeto são Colaborador e Aluno. Para testar a aplicação, antes de inicializar o projeto crie a base dados no MySql (comando logo abaixo). A construção das tabelas serão feitas por meio de migrations e pelo Spring automaticamente.

* Crie a base de dados
```sql
create database bd_vainaweb;
```
## UML
![Diagrama UML do projeto](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/uml/Projeto%20Final%20-%20Diagrama%20de%20Classes.jpeg)

# Funcionalidades

## método Post

- Consiste em inserir as entidades no banco de dados

![Cadastro de aluno feito com sucesso!](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Post-Aluno.png)

![Cadastro de colaborador feito com sucesso!](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Post-Colaborador.png)

- Não é possível cadastrar um registro, seja de colaborador ou aluno, caso o cpf ou e-mail já constar na base de dados.

![Tentativa de cadastro de aluno, mas cpf já está cadastrado](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Post-Aluno-CpfCadastrado.png)

![Tentativa de cadastro de aluno, mas e-mail já está cadastrado](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Post-Aluno-emailCadastrado.png)

## método Get

- Quando não é passado um id na url, retorna todos os registros da entidade.

![Busca de todos os alunos cadastrados](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Get-todosAlunos.png)

- Quando é passado o id na url, caso exista o registro, será retornado o registro referente aquele id.

![Busca pelo aluno de um id específico](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Get-Aluno-id.png)

- A tentativa de encontrar um registro pelo id que não existe no banco de dados retorná o status de 404 (Not Found)

![Tentativa busca por um aluno que não existe o id específicado na tabela de aluno](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Get-Colaborador-n%C3%A3oEncontrado.png)

## método Put
- Permite atualizar alguns dados, sendo nome, endereço, e cargo para a entidade colaborador e nome, endereco, telefone e curso para a entidade aluno. Não precisa ser necessáriamente todos esses campos, pode ser atualizado somente um deles, por exemplo.

![Alteração de dados de um registro de aluno](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Put-Aluno.png)

 - Não é aceito a tentativa de atualizar e-mail em nenhuma das duas entidades.

![Restrição quanto a alteração](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Put-Aluno-E-mailCadastrado.png)

 - Do mesmo modo do método get, tentar acessar um registro por um id que não existe, retornará o erro 404.

![Não encontrado o registro para alteração](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Put-Aluno-n%C3%A3o-encontrado.png)

## método Delete
 - Basta passar o id na url. Retornará um status 204 (No Content) se existir um registro para o id.

![Deletado com sucesso](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/Delete-Colaborador-Ok.png)

 - Também retorná um Not Found caso tentar deletar um registro de um id que não existe. Nesse caso haverá uma mensagem no corpo da resposta da requisição.

![Não existe o registro para ser apagado](https://github.com/Bruno-Pimenta/school-system/blob/main/assets/funcionalidades/DeleteColaborador-N%C3%A3oEnconstrado.png) 


## Processo do desenvolvimento da API

https://trello.com/b/aQgokbEY/school-system





