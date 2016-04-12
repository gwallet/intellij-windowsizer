Window Sizer
===

[JetBrains](https://www.jetbrains.com/) IntelliJ platform plugin that allows the user to resize the project window of any IntelliJ based product (IDEA, PyCharm, etc).

License
---
Window Sizer is released under the Apache 2.0 license.

Installing
---
First, be sure to run your IDE with Java 8 Runtime using the about dialog box.

### From the registry

Browse the plugin registry and search for _Window Sizer_

### From source

Build the source using the following instruction, then run it to be sure it works.
Then right-click on the module and select _Prepare Plugin Module 'intellij-windowsizer' for Deployment_, a JAR file will be created in the root directory of the project.
Eventually, choose _Install the plugin from disk ..._ to select the JAR created above and relaunch our IDE.

Building And Running
---
First step, be sure to follow the [Plugin Development Guideline](https://www.jetbrains.com/help/idea/2016.1/plugin-development-guidelines.html) in order to setup your environment properly.

1. Clone this repository,
1. Open the project using [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/),
1. Setup the correct IntelliJ SDK using _Project Structure_ > _Project_ > _Project SDK_,
1. Be sure to compile with JDK 8 language level _Project Structure_ > _Project_ > _Project language level_ > _8 - lambdas ..._,
1. Launch the plugin with the _Plugin_ run configuration.

Voilà ! a new IntelliJ instance shows up, and the plugin is ready to use :)

You're ready to contribute, congrats !

Known Issues
---

### Can not resize window when indexing

Just wait the end of the indexing process, then the menu items will be enabled.

### Can not use the plugin with my IDE running on Java N, N < [1.]8

Breaking news, [it's time to upgrade](https://java.com/en/download/faq/java_7.xml)!

1. Download your favorite flavor of the Java 8 Runtime or Java 8 Development Kit for you platform.
1. Then [see here](https://intellij-support.jetbrains.com/hc/en-us/articles/206544879-Selecting-the-JDK-version-the-IDE-will-run-under)
for instructions about selecting the JDK version the IDE will run under.