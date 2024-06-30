# Creatify - Minecraft Mod

O Creatify é um mod de minecraft para a versão 1.20.1 JAVA do jogo.

Este repositório contém todo o código-fonte utilizado para desenvolver e rodar o build do arquivo .jar

**Conteúdo**

- [Instalar e rodar o projeto](#instalar-e-rodar-projeto)
  - [Dependências Globais](#dependencias-globais)
  - [Dependências locais](#dependências-locais)
  - [Instalando as dependências](#instalando-dependencias)
  - [Rodando o projeto](#rodar-projeto)
  - [Como jogar com outras pessoas da própria rede](#jogar-multiplayer-local)
- [Histórico de desenvolvimento](#historico)
  - [Início do projeto](#inicio-projeto)
  - [Milestones](#milestones)

## Instalar e rodar o projeto

Para instalar e rodar o projeto localmente é muito fácil.

### Clonando o projeto

Primeiro, clone o projeto na sua máquina seguindo o tutorial: [Github Docs - Clonar um repositório](https://docs.github.com/pt/repositories/creating-and-managing-repositories/cloning-a-repository)

### Dependências globais

Você precisa ter instalado na sua máquina:

- Node.js LTS v20.10 (ou superior)

### Dependências locais

Com o repositório clonado e as dependências globais instaladas, você pode instalar as dependências locais:

```bash
npm install
```

### Rodando o projeto

Para rodar o projeto localmente:

1. Primeiro crie uma cópia do arquivo `.env.example` na pasta raiz do projeto com o nome `.env`.

2. Depois basta executar o comando abaixo:

```bash
npm run dev
```

3. Isto irá automaticamente rodar o projeto no seguinte endereço:

```bash
http://localhost:3000/index.html
```

#### Caso queira jogar com outras pessoas da sua rede local:

1. **WINDOWS:** Descubra seu IP local da sua rede, rodando o comando abaixo no terminal do seu computador:
```bash
ipconfig
```

2. No HTML, localizado em `./public/index.html`, altere a linha que faz a conexão com o websocket para o seu ip. Por exemplo: `http://(SEU IP):(SUA PORTA - por padrão 3000)`:
```javascript
// Linha que faz conexão com o websocket
const socket = io("http://localhost:3000");
```

## Histórico de desenvolvimento

### Início do projeto

No início do projeto, foi feita toda a conexão basica com o WebSocket utilizando o SocketIO. Além disso, também foi feito o roteamento utilizando a biblioteca Express do Node.JS;

### Milestones

Os milestones são os marcos históricos do projeto para ajudar o desenvolvimento em uma direção específica.

Para visualizar basta acessar: [https://github.com/lucfernandes/Snake-Game-JS/milestones](https://github.com/lucfernandes/Snake-Game-JS/milestones)