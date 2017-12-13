# News Story

### Requirements
- Java 8.x
- Gradle 4.x
- Tomcat 8.x

### Get Started
- Run gradle task `./gradlew bootRun` in Linux or `.\gradlew.bat bootRun` in Windows
- Browse `http://localhost:8080`

### To Make it Deployable
- Run `./gradlew build`
- Deploy `build/libs/news-story-1.0.0.war` as root webapp (`ROOT.war`)
- Start tomcat

### To Change UI
- Install nodejs 8+
- Install quasar-cli `npm install -g quasar-cli`
- Install vueapp dependencies by `cd vueapp && npm install`
- Run developer mode using `quasar dev`
- Run production mode using `quasar build`. This will compiled & compressed css, js & html into `src/main/resources/static` folder
