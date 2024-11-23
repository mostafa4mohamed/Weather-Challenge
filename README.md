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

This repository applies Clean Architecture using the Onion Architecture pattern with an MVVM (Model-View-ViewModel) architecture. 
The project is modularized into three modules: app, data, and domain.

## Technologies

- Kotlin: Programming language used.
- Jetpack Compose: Used to build a modern, declarative UI efficiently. 
- Room: Used for caching data in offline mode.
- Coroutines: Used to handle asynchronous tasks.
- Hilt: Implemented for dependency injection.
- Retrofit: Used to fetch data from the server.
- JUnit 4: to implement Unit tests.
