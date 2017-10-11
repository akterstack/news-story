#News Story

###Requirements
- Java 8
- Gradle 4+

###Get Started
- Run gradle task `./gradlew bootRun` in Linux or `.\gradlew.bat bootRun` in Windows
- Browse `http://localhost:8080`

###To Change UI
- Install nodejs 8+
- Install quasar-cli `npm install -g quasar-cli`
- Install vueapp dependencies by `cd vueapp && npm install`
- Run developer mode using `quasar dev`
- Run production mode using `quasar build`. This will compiled & compressed css, js & html into `src/main/resources/static` folder
