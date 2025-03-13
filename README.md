# Avanade 2025 - Games Api
Project created for the avanade "Decola Tech" bootcamp on DIO as a requirement to finish one of its modules.

## Class Diagram
``` mermaid
classDiagram
    class Game {
        -Long id
        -String name
        -String description
        -LocalDate releaseDate
        -String publisher
        -Double rating
        -Integer reviewsCount
        -List~Genre~ genres
        -List~String~ images
        -List~String~ platforms
    }

    class Genre {
        -Long id
        -String name
    }

    Game "1" -- "*" Genre : has
```
