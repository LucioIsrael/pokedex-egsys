# pokedex-egsys
## Android Challenge EGsys

Ao abrir o aplicativo abrirá uma splashActivity que contêm um gif e logo em seguida abrirá a pagina principal do aplicativo onde se encontra a recyclerView com a imagem dos pokemons e seus respectivos nomes.

- este aplicativo contêm todos os pokemons da primeira até a quarta geração (493 Pokemons).
- Utilizei PokeApi para fazer as requisições.
- No canto inferior direito tem uma masterball, clicando nela você será direcionado para uma tela onde mostrará os detalhes de um pokemon aleatório.
- ![image](https://user-images.githubusercontent.com/97804377/156821900-c9e264f5-efbe-4683-b92a-777acf7aeb3f.png)
- Existem 2 menus no canto superior direito onde você pode filtrar o tipo pelo MenuItem e o nome pela SearchView.
- ![image](https://user-images.githubusercontent.com/97804377/156821959-fe6b3565-c642-49d7-b861-897912fea12f.png)
- Ao clicar em um pokemon da lista você será direcionado para uma tela onde mostrará os detalhes do pokemon escolhido
- ![image](https://user-images.githubusercontent.com/97804377/156822340-c56dd578-2d46-46c5-8b6f-4056e4e7e0e7.png)

## Frameworks / Bibliotecas

- Coroutine 
- Dagger Hilt
- Retrofit
- Glide

## Estrutura de packages

- api
- common
- di
- domain
- util
- view
- viewmodel
