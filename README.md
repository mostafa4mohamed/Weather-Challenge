# Daily Forecast App

The **Daily Forecast App** provides users with real-time weather updates, including daily and weekly forecasts. The app leverages a modern architecture to ensure a smooth user experience with offline capabilities, using OpenWeatherMap APIs. For API documentation, visit: [OpenWeatherMap API Docs](https://openweathermap.org/forecast5).
## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Architecture](#architecture)
- [Technologies](#technologies)

## Features

- **Forecast**: Provides daily and daily forecasts depending on entered city.
- **Offline Mode**: Caches data for offline access.
- **User-Friendly UI**: Intuitive and responsive design.

## Installation

Clone the repository:
   git clone [https://github.com/mostafa4mohamed/Weather-Challenge.git](https://github.com/mostafa4mohamed/Weather-Challenge.git)

## Architecture

The project follows **Clean Architecture**, ensuring clear separation of concerns and modularity. The app is structured into distinct layers to keep the core business logic isolated from external dependencies. The core business logic is placed in the **Domain Layer**, which is independent of other layers.

The app also follows the **MVVM (Model-View-ViewModel)** design pattern, where:
- **Model** represents the data and business logic.
- **View** represents the UI components (built using **Jetpack Compose**).
- **ViewModel** acts as a bridge, managing UI-related data and handling logic between the **Model** and **View** layers.

The layers are as follows:
- **Domain Layer**: Contains entities and use cases, representing the core logic.
- **Data Layer**: Handles data operations, including API interactions via **Retrofit** and local storage via **Room**.
- **APp Layer**: Uses **Jetpack Compose** to create the UI and **ViewModel** to manage UI-related data and handle interactions with the domain layer.

This architecture ensures that each layer is testable, independent, and maintainable.


## Technologies

- Kotlin: Programming language used.
- Jetpack Compose: Used to build a modern, declarative UI efficiently. 
- Room: Used for caching data in offline mode.
- Coroutines: Used to handle asynchronous tasks.
- Hilt: Implemented for dependency injection.
- Retrofit: Used to fetch data from the server.
- JUnit 4: to implement Unit tests.
- Clean Architecture : The app is built using **Clean Architecture**, ensuring clear separation of concerns. The core business logic is isolated in the domain layer, while other layers (data and app) interact with it through well-defined interfaces.
