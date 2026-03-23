# Checkpoint 

## Integrantes do Grupo

- Ana Flavia | RM 56149 | afcamelo
- Gustavo Terada | RM 562745 | gkenji110
- João Guilherme | RM 566234 | doublekill0909

---

## Sobre a aplicação

Esta aplicação realiza o gerenciamento de funcionários por meio da classe base `Funcionario` e dos perfis:

- `FuncionarioJunior`
- `FuncionarioPleno`
- `FuncionarioSenior`

Cada tipo de funcionário possui sua própria regra de bônus:

- **Funcionário Júnior:** recebe bônus a cada 45 horas trabalhadas;
- **Funcionário Pleno:** recebe bônus a cada 30 horas trabalhadas;
- **Funcionário Sênior:** recebe bônus a cada 15 horas trabalhadas.

Além disso, o sistema executa as operações de CRUD:

- **Create** - cadastro de funcionários;
- **Read** - busca de funcionários;
- **Update** - atualização de dados;
- **Delete** - remoção de registros.
---

# Evidências de execução dos testes

## 1. Testes do Funcionário Júnior
### 1.1 INSERT - Funcionário Júnior

<img width="1104" height="342" alt="image" src="https://github.com/user-attachments/assets/bcaa711d-650c-43b4-930e-7de461923e86" />

Neste teste, o sistema cadastra um funcionário júnior no banco de dados com nome, cargo, horas trabalhadas, valor por hora e valor de bônus. Também é exibido o SQL de inserção gerado automaticamente e o ID criado para o registro.

---

### 1.2 SELECT - Funcionário Júnior

<img width="879" height="271" alt="image" src="https://github.com/user-attachments/assets/262bf75d-b365-445e-b2f6-d7a7de9f71e2" />

Neste teste, o sistema busca no banco de dados o funcionário júnior anteriormente cadastrado. Após a busca, são exibidas as informações completas do funcionário e o SQL de consulta correspondente. As informações exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus aplicada estão utilizando o método imprimirInformacao(). A informação e cálculo do salário é feita com a calcularSalario().

---

### 1.3 UPDATE - Funcionário Júnior

<img width="1274" height="507" alt="image" src="https://github.com/user-attachments/assets/87ff6e26-ee15-46e4-a5c6-11c0dae6c1a5" />

Neste teste, o sistema altera a quantidade de horas trabalhadas do funcionário júnior e atualiza essas informações no banco de dados. Em seguida, mostra o SQL de atualização e os novos dados já modificados. As informações exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus aplicada estão utilizando o método imprimirInformacao(). A informação e cálculo do salário é feita com a calcularSalario().

---

### 1.4 DELETE - Funcionário Júnior

<img width="432" height="211" alt="image" src="https://github.com/user-attachments/assets/214a4ce8-1f05-4393-84ed-b90c9fb5da88" />

Neste teste, o sistema remove o funcionário júnior do banco de dados a partir do seu ID. O SQL de exclusão é exibido e o registro deixa de existir na tabela após a operação.

---

## 2. Testes do Funcionário Pleno

### 2.1 INSERT - Funcionário Pleno

<img width="1100" height="343" alt="image" src="https://github.com/user-attachments/assets/4c32149e-c3da-4622-9c87-fc7101a88e9a" />

Neste teste, o sistema cadastra um funcionário pleno no banco de dados com seus dados principais e com a regra de bônus correspondente ao perfil. O SQL de inserção também é exibido para demonstrar a operação realizada. calcularSalario().

---

### 2.2 SELECT - Funcionário Pleno

<img width="879" height="282" alt="image" src="https://github.com/user-attachments/assets/645cebb5-fc4a-4ac9-9ccc-cf6012a6f7c0" />

Neste teste, o sistema realiza a consulta do funcionário pleno no banco de dados a partir do ID gerado no cadastro. Depois da busca, as informações do funcionário são exibidas em tela junto com o SQL de seleção. As informações exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus aplicada estão utilizando o método imprimirInformacao(). A informação e cálculo do salário é feita com a calcularSalario().

---

### 2.3 UPDATE - Funcionário Pleno

<img width="1283" height="514" alt="image" src="https://github.com/user-attachments/assets/38537dcd-cc3f-4832-97da-0a026d0467cd" />

Neste teste, o sistema modifica as horas trabalhadas do funcionário pleno e grava essa alteração no banco de dados. Após o update, o sistema mostra os novos dados e o SQL correspondente à atualização. As informações exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus aplicada estão utilizando o método imprimirInformacao(). A informação e cálculo do salário é feita com a calcularSalario().

---

### 2.4 DELETE - Funcionário Pleno

<img width="435" height="200" alt="image" src="https://github.com/user-attachments/assets/42f7f4f7-0b74-4647-9352-e5df61cd14f2" />

Neste teste, o sistema exclui do banco o registro do funcionário pleno utilizando seu ID. O SQL de exclusão é exibido e a remoção pode ser conferida na tabela do Oracle.

---
## 3. Testes do Funcionário Sênior

### 3.1 INSERT - Funcionário Sênior

<img width="1107" height="335" alt="image" src="https://github.com/user-attachments/assets/cb44afd3-04ec-4c09-ad6a-bdbe632e18ff" />

Neste teste, o sistema cadastra um funcionário sênior no banco de dados com seus dados completos, incluindo a regra de bônus específica da categoria. O SQL de inserção gerado também é mostrado durante a execução. 

---

### 3.2 SELECT - Funcionário Sênior

<img width="880" height="275" alt="image" src="https://github.com/user-attachments/assets/54bc0558-44c7-4cf4-afa1-d6e5d03f6fa8" />

Neste teste, o sistema consulta no banco o funcionário sênior usando o ID gerado no momento do cadastro. Depois da busca, os dados são exibidos em tela juntamente com o SQL de seleção. As informações exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus aplicada estão utilizando o método imprimirInformacao(). A informação e cálculo do salário é feita com a calcularSalario().

---

### 3.3 UPDATE - Funcionário Sênior

<img width="1270" height="518" alt="image" src="https://github.com/user-attachments/assets/42e50f54-7785-4d61-9e6b-5084bfd51a8c" />

Neste teste, o sistema altera o total de horas trabalhadas do funcionário sênior e atualiza o registro no banco de dados. Em seguida, mostra o SQL de update e as informações atualizadas do funcionário. As informações exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus aplicada estão utilizando o método imprimirInformacao(). A informação e cálculo do salário é feita com a calcularSalario().

---

### 3.4 DELETE - Funcionário Sênior

<img width="436" height="209" alt="image" src="https://github.com/user-attachments/assets/7b9d9e29-a6bd-4680-976e-fc4f8207fcf0" />

Neste teste, o sistema apaga do banco de dados o registro do funcionário sênior utilizando seu ID. A exclusão é feita via operação DELETE e pode ser comprovada na tabela do Oracle.

---

## 4. Evidências do banco de dados

### 4.1 Tabela criada/atualizada no Oracle

<img width="1020" height="400" alt="image" src="https://github.com/user-attachments/assets/7e741b0c-5138-41f5-862c-bad952e0306a" />


Nesta evidência, é possível visualizar que a tabela utilizada pelo sistema foi criada/atualizada corretamente no Oracle a partir do mapeamento da entidade `Funcionario` e de suas subclasses.

---

### 4.2 Registros inseridos no banco

<img width="1167" height="632" alt="image" src="https://github.com/user-attachments/assets/5263430d-d3d8-4b75-a33a-06d846605772" />


Nesta evidência, é possível visualizar no banco de dados os registros inseridos pelos testes de cadastro, comprovando que as operações CREATE foram realizadas com sucesso.

---

### 4.3 Registros após atualização

<img width="645" height="200" alt="image" src="https://github.com/user-attachments/assets/80fcd909-6926-4cec-bfb7-788fddfcaad5" />
<img width="883" height="537" alt="image" src="https://github.com/user-attachments/assets/1769f1cc-bf93-4c57-993a-134db8130691" />


Neste exemplo, podemos ver o método "AtualizarPleno()" setando o número de horas trabalhados de um funcionário passado como parâmetro para 999. O mesmo foi feito, parqa fins de testes, no método equivalente para júnio e para sênior, como pode ser visto refletido no banco de dados.
---

### 4.4 Registros após exclusão

<img width="684" height="312" alt="image" src="https://github.com/user-attachments/assets/9f7d0067-fc4b-45ca-a931-65c7e0577bba" />

<img width="1003" height="379" alt="image" src="https://github.com/user-attachments/assets/94e28518-6578-4ff8-be4e-6db7d897afd5" />


Para esta evidência, criamos um método (temporário) para exemplificar a exclusão de todos os funcionários seniores.


