# 🛡️ Documentação do Projeto: Validação de Senhas

## 1. 🔍 Visão Geral

Este projeto implementa um serviço **RESTful** em **Java + Spring Boot** para validar senhas com regras específicas de segurança.  
A aplicação segue a **Arquitetura Hexagonal (Ports & Adapters)**, separando domínio, casos de uso, interfaces e adapters para garantir **manutenção e testabilidade**.

## 2. 🛠️ Tecnologias

- ☕ Java 22  
- 🌱 Spring Boot 3.5  
- 🧪 JUnit 5 + Mockito (testes unitários e de integração)  
- 🏗️ Arquitetura Hexagonal  
- 📦 Maven (gerenciamento de dependências)  
- 🔌 Postman / Insomnia (testes de endpoint)

## 3. 📂 Estrutura do Projeto
```plaintext
src/main/java/com/example/estudo
│
├── adapters
│ └── input
│ └── SenhaController.java # 📥 Recebe requisições HTTP
│
├── domain
│ └── SenhaModel.java # 🔑 Regras de negócio da senha
│
├── ports
│ └── input
│ └── ValidarSenhaUseCase.java # 📝 Interface do caso de uso
│
├── usecases
│ └── ValidarSenhaUseCaseImpl.java # ⚙️ Implementação do caso de uso
│
└── EstudoApplication.java # 🚀 Classe principal Spring Boot
```
## 4. 🏛️ Camadas e Responsabilidades

### 4.1 Domain

Contém o modelo de domínio e **regras de negócio puras**.

### 🔐 Regras de Negócio da Senha

| Regra | Mensagem de Erro |
|-------|-----------------|
| Mínimo 9 caracteres | A senha deve ter pelo menos 9 caracteres. |
| Pelo menos 1 dígito | A senha deve conter pelo menos 1 dígito. |
| Pelo menos 1 minúscula | A senha deve conter ao menos 1 letra minúscula. |
| Pelo menos 1 maiúscula | A senha deve ter no mínimo 1 letra maiúscula. |
| Pelo menos 1 caractere especial | A senha deve conter ao menos um caractere especial. |
| Sem caracteres especiais repetidos | Não pode haver caracteres especiais repetidos. |
| Sem espaços | Não pode conter espaços em brancos. |

## 5. ⚡ Como Rodar o Projeto

### Build Maven:
```bash
mvn clean install
```
Rodar aplicação:
```bash
mvn spring-boot:run
```
Testar endpoint via Postman / Insomnia:

POST http://localhost:8080/senha/validar

Body: "Abcdef1@2"

