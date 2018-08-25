# MVP Android Template
A MVP Android Template to give you a Head Start for your next Android Project. It contains the boilerplate code to quickly setup your project for MVP Architecture using industry standard practices and popular libraries like RxJava, Dagger, Retrofit and Room.

![Sample](https://raw.githubusercontent.com/gauravk95/mvp-android-template/master/sample.gif)

### This project uses:
* **RxJava 2** - For Reactive Programming
* **Dagger 2** - For Dependency Injection
* **Retrofit 2** - As Type Safe HTTP client
* **Room** - For persistence storage(abstraction of SQLite)

### MVP Architecture Blueprint
![Architecture](https://raw.githubusercontent.com/gauravk95/mvp-android-template/master/MVPArchBlueprint.jpg)

### The app has following packages:
1. **base:** It contains base classes
2. **data:** It contains all the data accessing and manipulating components like data models, sources, repositories
    * model
      * local
      * remote
    * source
      * db
      * network
      * prefs
      * repository
         * local
         * remote
3. **di:** Dependency providing classes using Dagger2.
    * component
    * module
4. **ui:** View classes along with their corresponding Presenters.
    * custom
    * adapters
    * main
5. **service:** Services for the application.
6. **utils:** Utility classes.
    * fonts 
    * rx 
    
### License:
```
    Copyright 2018 Gaurav Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
