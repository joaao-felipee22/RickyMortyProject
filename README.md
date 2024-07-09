# Ricky and Morty

A simple Android app to show Ricky and Morty characters.

## Knowledge Stack

This project leverages on:

- 100% powered by AndroidX
- Unidirectional Data Flow Architecture based on Clean Architecture with Repository Pattern
- Coroutines for asynchronous programming
- Dagger Hilt for Dependency Injection
- GSON for automatic JSON handling
- OkHttp3 + Retrofit for networking over HTTP
- 100% written in Kotlin

## Building and Running

### Running from IDE

- Ensure you have Android Studio X.X.X or newer

### Building from CLI

To build an APK, execute

```
./gradlew build
```

### Running unit tests from CLI

To run all unit tests, execute

```
./gradlew test
```

## Implementation

The application is divided in some modules and they are described below:

- **app** ~ module that handles the startup initialization
- **shared** ~ has all common classes, interfaces, extensions that other modules might use
- **networking** ~ responsible for handling all network requests
- **features/characters/list** ~ the main feature module where display the screen of characters list

## Next steps

- Implement more unit tests, end to end tests, and integration tests
- Consider using other dependency injection libraries (Kodein, Koin)
- Integrate Danger to improve code reviews
- Create a new job to run espresso tests
- Add animations
- Consider a possibility to create a base ViewModel class to handle the VMI process
- Improve error handling through checking the HTTP status code to implement WorkManager strategies to retry/failure the execution of deletion batch process
- Consider using Firebase Test Lab to run more instrumentation tests

## LICENSE

```
MIT License

Copyright (c) 2024 joaao-felipee22

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.