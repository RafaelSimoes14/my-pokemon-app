# MyPokemonApp

## Descrição do projeto

O MyPokemonApp é um aplicativo Android desenvolvido em Kotlin que consome a API pública da PokéAPI para exibir informações sobre Pokémons.

A aplicação permite listar Pokémons, visualizar detalhes como nome, imagem e atributos, proporcionando uma experiência simples e intuitiva de navegação.

O projeto foi desenvolvido com o objetivo de demonstrar a construção de um aplicativo Android consumindo uma API REST, aplicando boas práticas de arquitetura, organização de código e separação de responsabilidades.

---

## Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/6feb5d6e-ba5b-4c38-ac27-064b43830604" width="160"/>
  <img src="https://github.com/user-attachments/assets/0d794bf8-8a3f-48f9-a482-45c428d1a48d" width="160"/>
  <img src="https://github.com/user-attachments/assets/091e1e69-ef2f-4f34-81d1-f0a01ac4eb03" width="160"/>
  <img src="https://github.com/user-attachments/assets/f1d9026c-36b6-48a7-b0dd-82a4ca7efc9e" width="160"/>
</p>

<p align="center">
  Inicialização • Tela inicial • Detalhes Pokemon • Retorno tela inicial
</p>

---

## Passos para rodar o app

Clone o repositório:

```bash
git clone https://github.com/RafaelSimoes14/my-pokemon-app.git
```
2. Abra o projeto no **Android Studio**

3. Aguarde a sincronização do **Gradle**

4. Execute o aplicativo em um **emulador** ou **dispositivo físico**

---

## API utilizada

O aplicativo utiliza a API pública:

https://pokeapi.co/

Endpoint utilizado no projeto:

https://pokeapi.co/api/v2/pokemon

Exemplo de chamada:

https://pokeapi.co/api/v2/pokemon?limit=20

A API retorna um JSON contendo a lista de Pokémons e seus detalhes, como nome, imagem e informações adicionais.

---

## Decisões técnicas

Algumas decisões técnicas foram tomadas para manter o projeto organizado e facilitar sua evolução:
- Utilização da arquitetura MVVM para separar a lógica de interface da lógica de negócio
- Organização do projeto em camadas inspirada em Clean Architecture
- Uso do Retrofit para consumo da API
- Uso de Coroutines para chamadas assíncronas
- Implementação de Repository Pattern para abstração dos dados
- Utilização de ViewBinding para simplificar o acesso à UI
- Estrutura preparada para fácil manutenção e escalabilidade
- Persistência local utilizando Room para armazenamento dos dados dos Pokémons

---

## Estratégia de cache (Room)

Foi implementado um mecanismo de cache local utilizando Room para otimizar o consumo da API e melhorar a performance da aplicação.

Quando o usuário acessa a tela de detalhes de um Pokémon:
- Os dados são buscados na API apenas se ainda não existirem localmente
- Após a primeira requisição, os dados são persistidos no banco local
- Em acessos posteriores ao mesmo Pokémon, os dados são carregados diretamente do Room
- Isso evita chamadas desnecessárias à API, reduz o tempo de carregamento e melhora a experiência do usuário

---

## Possíveis melhorias do projeto

- Com mais tempo, algumas melhorias poderiam ser implementadas:
- Adição de testes unitários
- Implementação de testes de interface (UI tests)
- Paginação da lista de Pokémons
- Implementação de busca por nome de Pokémon
- Melhor tratamento de erros de rede e estados da aplicação
- Cache local com Room para melhorar performance
- Migração da interface para Jetpack Compose
- Implementação de animações e melhorias na experiência do usuário

## Autor
Rafael Rosa
