# Val-DNA 
**VAL-DNA** is an offline first, single source of truth application that consists of 12 screens built entirely with Jetpack compose. The application is an encyclopedia for the game [Valorant](https://playvalorant.com/ar-ae/)
# Screenshots
![Presentation](/Screenshots/Presentation%20Screenshots.png?raw=true "Val-DNA")
# Features
**Val-DNA** utilizes [Valorant’s API](https://valorant-api.com/) to request data and assets regarding the different aspects of the game like agents, maps and skins, then cahces the data for offline use. Users can browse the application's different screens to view infromation and details regarding the game in sleek looking UI.
# Technologies
• JetPack compose for ui.  
• Retrofit for netowrking.  
• Room for offline Chaching.  
• Coil for image loading.  
• Coroutines + Flow for asynchronous.  
• Hilt for dependency injection.  
• Navigation Compose for navigation.  
• SplashArtAPI for the splash screen.  
# Architecture
**Val-DNA** follows the [official architecture guidance](https://developer.android.com/topic/architecture) by Google.  
• Clean architucture.  
• Single Source of Truth.  
• Repository pattern.  
# Goal
**Val-DNA** serves as my personal pet project. I wanted to make a project where I could put my recent Jetpack compose learnings to test, while also creating an application that follows Google's recommended offline first architicture, and I wanted to do so by creating an applicatin for something that I love.
# Download APK
 You can Download the application by [clicking here](app-debug.apk)
# Todo
• Write more tests for the application.  
• Improve UI.  
• add login feature using fireauth.  
• Make chat room using firebase.

