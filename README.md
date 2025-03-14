# Avanade 2025 - Games Api
Project created for the avanade "Decola Tech" bootcamp on DIO as a requirement to finish one of its modules.

## Class Diagram
``` mermaid
classDiagram
    class Game {
        -String name
        -String description
        -LocalDate releaseDate
        -String publisher
        -Double rating
        -Integer reviewsCount
        -List~Genre~ genres
        -List~String~ images
        -List~Platform~ platforms
    }

    class Genre {
    }

    class Platform {
    }

    class GameAttribute {
        -String name
    }

    Game "*" -- "*" Genre : categorized as
    Game "*" -- "*" Platform : available on

    Genre --|> GameAttribute
    Platform --|> GameAttribute
```
