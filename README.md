## 📱 Sobre o Projeto
Projeto de automação de testes mobile para o aplicativo Cuidar, desenvolvido com Appium e Java. O projeto visa garantir a qualidade e o funcionamento correto das principais funcionalidades do aplicativo.

## 🚀 Funcionalidades Testadas
- Login
- Fale Conosco
- Esqueci Minha Senha
- Meus Dados
- Permissões do App

## 🛠️ Tecnologias Utilizadas
- Java 8
- Maven
- Appium
- JUnit
- Selenium WebDriver

## ⚙️ Pré-requisitos
- JDK 8 ou superior
- Maven
- Appium Server
- Android SDK
- Node.js

## 📥 Instalação
1. Clone o repositório
```bash
git clone https://github.com/SavioHolanda/cuidar.git
```

2. Instale as dependências
```bash
mvn clean install
```

## 🎯 Executando os Testes
Para executar todos os testes:
```bash
mvn test
```

## 📁 Estrutura do Projeto
src/
├── test/
│ ├── java/
│ │ ├── pages/ # Page Objects
│ │ ├── tests/ # Casos de Teste
│ │ ├── runners/ # execução
│ │ └── utils/ # Classes Utilitárias
│ └── resources/ # Arquivos de Configuração

## 📝 Classes Principais
- `TestBase`: Classe base com configurações comuns para todos os testes
- `CapabilitiesManager`: Gerenciamento das capabilities do Appium
- `LoginTest`: Testes da funcionalidade de login
- `FaleTest`: Testes do módulo Fale Conosco

## 🔍 Padrões Utilizados
- Page Object Pattern
- Fluent Page Pattern
- Base Test Pattern

## ✨ Autor
Sávio Holanda

## 📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
