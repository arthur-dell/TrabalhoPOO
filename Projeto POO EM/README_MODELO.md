# 🖨️ Sistema de Controle de Impressora Elgin

## 📘 Sobre o Projeto

Este projeto foi desenvolvido em Java para realizar a comunicação e o controle de uma impressora térmica Elgin por meio da biblioteca DLL. O sistema possui autenticação de usuário, configuração e gerenciamento da conexão com a impressora, além de funcionalidades de impressão de texto, QR Code, código de barras e arquivos XML SAT. O projeto faz parte da disciplina de Programação Orientada a Objetos (POO).

---

## 🧰 Tecnologias Utilizadas

- **Java (OpenJDK 27.0.1)**
- **IntelliJ IDEA**
- **JNA 5.15.0** (comunicação com a DLL)
- **DLL E1_Impressora** (SDK da Elgin)
- **Impressora térmica Elgin i9**

---

## 📁 Estrutura do Projeto

```text
Projeto POO EM/
├── Projeto POO EM/
│   ├── Bibliotecas E1 Impressora/
│   ├── libs Java/
│   ├── CANC_SAT.xml
│   ├── XMLSAT.xml
│   ├── Impressora.java
│   ├── ImpressoraDLL.java
│   ├── Login.java
│   └── Main.java
```

- **Main.java:** inicia o programa, realiza o login e chama o menu principal.
- **Login.java:** responsável pela autenticação do usuário e pelo limite de tentativas.
- **Impressora.java:** contém o menu e as funcionalidades de configuração, conexão e impressão.
- **ImpressoraDLL.java:** realiza a comunicação com as funções da DLL da Elgin.
- **XMLSAT.xml:** arquivo XML utilizado na impressão SAT.
- **CANC_SAT.xml:** arquivo XML utilizado na impressão de cancelamento SAT.
- **Bibliotecas E1 Impressora:** contém as bibliotecas DLL necessárias para a comunicação.
- **libs Java:** contém as bibliotecas Java utilizadas no projeto.

---

## ⚙️ Instalação e Execução

### 1. Baixar o projeto

1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo baixado.

### 2. Abrir no IntelliJ IDEA

1. Acesse **File → Open** e selecione a pasta do projeto.
2. Em **File → Project Structure → Libraries**, confirme que a biblioteca `jna-5.15.0.jar` está adicionada.
3. Conecte e ligue a impressora.
4. Abra `Main.java` e clique em **Run**.

---

## 🔐 Login

O sistema possui autenticação com os seguintes dados:

- **Usuário:** admin
- **Senha:** 1234
- **Tentativas permitidas:** 3

Caso o usuário ou a senha estejam incorretos, o sistema informa o acesso negado e apresenta a quantidade de tentativas restantes. Após três tentativas, o acesso é encerrado.

---

## 📋 Funcionalidades do Menu

| Opção | O que faz |
|---|---|
| 1 | Configurar conexão da impressora |
| 2 | Abrir conexão |
| 3 | Fechar conexão |
| 4 | Imprimir texto |
| 5 | Imprimir QR Code |
| 6 | Imprimir código de barras |
| 7 | Imprimir XML SAT |
| 8 | Imprimir XML de cancelamento SAT |
| 9 | Abrir gaveta |
| 10 | Emitir beep |
| 11 | Sair do programa |

---

## 🧪 Testes Realizados

- Teste de login com usuário e senha corretos.
- Teste de login com dados incorretos.
- Teste do limite de três tentativas de login.
- Teste de configuração da impressora.
- Teste de abertura e fechamento da conexão.
- Teste de impressão de texto.
- Teste de impressão de QR Code.
- Teste de impressão de código de barras.
- Teste de impressão XML SAT.
- Teste de impressão XML de cancelamento SAT.
- Teste de abertura da gaveta.
- Teste de emissão de sinal sonoro.
- Teste de opções inválidas no menu.

---

## 📚 Documentação Adicional

- Manual da impressora Elgin.
- Documentação do SDK E1_Impressora.
- Documentação da biblioteca JNA.

---

## 👥 Autores

- Arthur Del Santo Moura
- Arthur Henrique Oliveira de Melo
- Cezar Guilherme Avelino dos Santos
- Henrique Almeida
- Michel Novak Teixeira
