# WorldRemitTest Automation

This project is a maven based project and uses Selenium and cucumber frameworks. The cucumber feature file has 3 scenarios:
 1) A positive scenario where user selects Philippines and validates that the page for Philippnes is loaded
 2) A failing scenario where user selects Philippines but expects the page for New Zealnad to be loaded
 3) A scenario outline where the test verifies that the correct page is loaded for any numbr of countries added to the Datatable Examples (3 countries added to the table)
 
 As the scenario to automate was relatively simpler, the framework is not complicated too much with a separate utility class, property files, etc.. 
 Also, to avoid the element of doubt regarding the browsers and versions installed in the test machine where this will be run, this test is limited to the most widely used chrome browser but on different platforms (Windows, linux and Mac). But if needed, the tests can be easily configured to run on any browser by adding few additional methods in the WebDriverConfiguration class, having the right drivers and passing an additional argument in the command line.
   
**Pre-Requisites**

1) Java should be installed in the test machine. This is expected to be already installed in the test machine. If not installed, follow the instructions: https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html
2) Maven should be configured in the test machine so that the 'mvn' command is recognized. If Maven is not configured, follow the maven configuration steps on different platforms, at the bottom of this page.
3) Latest version of chrome should be installed. (v75.0.3770.9 of the chrome drivers are attached to this project in the path: "<project root>/src/main/resources/webDrivers"). If an earlier version of chrome browser is used, the drivers may not be compatible with it and the driver compatible for that version need to be used and replaced in the webDriver path specified.
 
**Executing tests from the command line**

Execute the following command from the project root directory by changing the value of platform and tag name as required:

```$xslt
mvn test -Dplatform=windows -Dcucumber.options="--tags @ScenarioOutlineDemonstration"
```

_platforms_: windows | mac | linux

_tags_: @PassingScenario | @FailingScenario | @ScenarioOutlineDemonstration

**Executing tests from the editor (e.g., Intellij)**

Update the desired test tag in the TestRunner class (src/test/java/testRunner).
Run the TestRunner class as a junit test with vm options value set to "-Dplatform=windows" or any desired platform

_platforms_: windows | mac | linux

_tags_: @PassingScenario | @FailingScenario | @ScenarioOutlineDemonstration


**Maven configuration on Windows**

Unzip the maven zip file located at: <project root>/src/main/resources/mavenLibraries/apache-maven-3.6.1-bin.zip.

Add both M2_HOME and MAVEN_HOME variables to the Windows environment using system properties, and point it to your Maven folder.

Update the PATH variable by appending the Maven bin folder – %M2_HOME%\bin, so that you can run the Maven’s command everywhere.

**Maven configuration on Linux**

Extract the maven archive file located at: <project root>/src/main/resources/mavenLibraries/apache-maven-3.6.1-bin.tar.gz

Assuming that maven is extracted to "/usr/local/apache-maven/apache-maven-3.6.1", enter the following commands in the command terminal:

```$xslt

$ export M2_HOME=/usr/local/apache-maven/apache-maven-3.6.1
 
$ export M2=$M2_HOME/bin
 
$ export MAVEN_OPTS=-Xms256m -Xmx512m

$ export PATH=$M2:$PATH 
```

**Maven configuration on Mac**

Extract the maven archive file located at: <project root>/src/main/resources/mavenLibraries/apache-maven-3.6.1-bin.tar.gz

Assuming that maven is extracted to the 'Downloads' directory, enter the following commands in the command terminal:

```$xslt

chown -R root:wheel Downloads/apache-maven*

mv Downloads/apache-maven* /opt/apache-maven

nano $HOME/.profile

export PATH=$PATH:/opt/apache-maven/bin

bash

```

