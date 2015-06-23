
# Instructions to build a android project that can be used to plug into a testing framework. 
#1: An Android project is typically built with a gradle wrapper. One can use gradle to build a Java project or an Android project. 
#2: For the Sony-Mobile SDK development, we focus on building android projects. 
#3: A gradle framework can be used to build multi-projects which also will be leveraged as a test-harness for Sony Mobile SDK development. 
#4: The custom checker developer/owner needs to build a self-contained Unit test case with single or a multiple java files that can be built
    in gradle.
#5: gradleCoverity folder within Sample_Android_Sony_mobile_Project dir is an example of a self contained Android project that is built via gradle. 
#6: Many such similar projects with a root gradle files will make up the testing harness. 
#7: A perlfile will trigger the Gradle build and perform COverity Analysis and generate a log as part of the test harness. 

Additional instructions about installing gradle and building Android project can be found following the link below: 
https://spring.io/guides/gs/gradle-android/#scratch

