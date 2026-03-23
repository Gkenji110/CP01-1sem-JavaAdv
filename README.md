# Checkpoint 

## Integrantes do Grupo

- Nome 1: ____________________________________________
- Nome 2: ____________________________________________
- Nome 3: ____________________________________________

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

### Print

Neste teste, o sistema cadastra um funcionário júnior no banco de dados com nome, cargo, horas trabalhadas, valor por hora e valor de bônus. Também é exibido o SQL de inserção gerado automaticamente e o ID criado para o registro.

---

### 1.2 SELECT - Funcionário Júnior

### Print

Neste teste, o sistema busca no banco de dados o funcionário júnior anteriormente cadastrado. Após a busca, são exibidas as informações completas do funcionário e o SQL de consulta correspondente.

---

### 1.3 UPDATE - Funcionário Júnior

### Print

Neste teste, o sistema altera a quantidade de horas trabalhadas do funcionário júnior e atualiza essas informações no banco de dados. Em seguida, mostra o SQL de atualização e os novos dados já modificados.

---

### 1.4 DELETE - Funcionário Júnior

### Print

Neste teste, o sistema remove o funcionário júnior do banco de dados a partir do seu ID. O SQL de exclusão é exibido e o registro deixa de existir na tabela após a operação.

---

### 1.5 imprimirInformacao() - Funcionário Júnior

### Print

Neste teste, é executado o método `imprimirInformacao()` da classe `FuncionarioJunior`, exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus aplicada.

---

### 1.6 calcularSalario() - Funcionário Júnior

### Print

Neste teste, é executado o método `calcularSalario()` da classe `FuncionarioJunior`. O salário final é calculado com base no valor por hora multiplicado pelas horas trabalhadas, somado ao bônus recebido a cada 45 horas completas.

---

## 2. Testes do Funcionário Pleno

### 2.1 INSERT - Funcionário Pleno

### Print

Neste teste, o sistema cadastra um funcionário pleno no banco de dados com seus dados principais e com a regra de bônus correspondente ao perfil. O SQL de inserção também é exibido para demonstrar a operação realizada.

---

### 2.2 SELECT - Funcionário Pleno

### Print

Neste teste, o sistema realiza a consulta do funcionário pleno no banco de dados a partir do ID gerado no cadastro. Depois da busca, as informações do funcionário são exibidas em tela junto com o SQL de seleção.

---

### 2.3 UPDATE - Funcionário Pleno

### Print

Neste teste, o sistema modifica as horas trabalhadas do funcionário pleno e grava essa alteração no banco de dados. Após o update, o sistema mostra os novos dados e o SQL correspondente à atualização.

---

### 2.4 DELETE - Funcionário Pleno

### Print

Neste teste, o sistema exclui do banco o registro do funcionário pleno utilizando seu ID. O SQL de exclusão é exibido e a remoção pode ser conferida na tabela do Oracle.

---

### 2.5 imprimirInformacao() - Funcionário Pleno

### Print

Neste teste, é chamado o método `imprimirInformacao()` da classe `FuncionarioPleno`, apresentando nome, cargo, horas trabalhadas, valor por hora, bônus por faixa e quantidade de bônus calculada para esse perfil.

---

### 2.6 calcularSalario() - Funcionário Pleno

### Print

Neste teste, é executado o método `calcularSalario()` da classe `FuncionarioPleno`. O cálculo considera o salário base e acrescenta o bônus recebido a cada 30 horas completas trabalhadas.

---

## 3. Testes do Funcionário Sênior

### 3.1 INSERT - Funcionário Sênior

### Print

Neste teste, o sistema cadastra um funcionário sênior no banco de dados com seus dados completos, incluindo a regra de bônus específica da categoria. O SQL de inserção gerado também é mostrado durante a execução.

---

### 3.2 SELECT - Funcionário Sênior

### Print

Neste teste, o sistema consulta no banco o funcionário sênior usando o ID gerado no momento do cadastro. Depois da busca, os dados são exibidos em tela juntamente com o SQL de seleção.

---

### 3.3 UPDATE - Funcionário Sênior

### Print

Neste teste, o sistema altera o total de horas trabalhadas do funcionário sênior e atualiza o registro no banco de dados. Em seguida, mostra o SQL de update e as informações atualizadas do funcionário.

---

### 3.4 DELETE - Funcionário Sênior

### Print

Neste teste, o sistema apaga do banco de dados o registro do funcionário sênior utilizando seu ID. A exclusão é feita via operação DELETE e pode ser comprovada na tabela do Oracle.

---

### 3.5 imprimirInformacao() - Funcionário Sênior

### Print

Neste teste, é utilizado o método `imprimirInformacao()` da classe `FuncionarioSenior`, exibindo nome, cargo, horas trabalhadas, valor por hora, valor do bônus por faixa e quantidade de bônus recebida.

---

### 3.6 calcularSalario() - Funcionário Sênior

### Print

Neste teste, é executado o método `calcularSalario()` da classe `FuncionarioSenior`. O salário final é formado pelo salário base acrescido do bônus aplicado a cada 15 horas completas trabalhadas.

---

## 4. Evidências do banco de dados

### 4.1 Tabela criada/atualizada no Oracle

### Print

Nesta evidência, deve ser mostrado que a tabela utilizada pelo sistema foi criada ou atualizada corretamente no Oracle a partir do mapeamento da entidade `Funcionario` e de suas subclasses.

---

### 4.2 Registros inseridos no banco

### Print

Nesta evidência, deve ser possível visualizar no banco de dados os registros inseridos pelos testes de cadastro, comprovando que as operações CREATE foram realizadas com sucesso.

---

### 4.3 Registros após atualização

### Print

Nesta evidência, devem aparecer no banco de dados os valores modificados após as operações de atualização, principalmente as horas trabalhadas e os dados relacionados ao cálculo salarial.

---

### 4.4 Registros após exclusão

### Print

Nesta evidência, deve ser mostrado que os registros removidos pelos testes de DELETE não aparecem mais na tabela, comprovando que a exclusão foi executada corretamente.


