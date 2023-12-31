#Version Comparison
The version Comparison project is intended to be a library to
be consumed by a third party that is used to determine the 
relative order of two versions.
 
*The main class has code so to test the functionality of
the two main helper classes with ease by providing a loop until user decides to exit the application.
The utility classes are just the VersionComparator, VersionValidator and ValidatorConstants.
So for all intents and purposes the main class is acting like a consumer of the utility classes
and has not got anything to do with the utility. As it is out of scope, no testing or documentation
is provided for it.*

##Requirements
- Minimum Version - Java 11

##Features
- Validate versions based on given criteria and assumptions.
- Compares two versions and outputs the relative order. It is important the consuming service validates
  the version first.

##How To Run
##### Maven Wrapper
- ./mvnw clean install
- ./mvnw clean package
- java -jar target/version-comparison-util-1.0.0.jar

##### IDE
- Some IDEs will autoconfigure a run function in the main class.

##### JAVA
- javac VersionComparison.java & java VersionComparison 
- if you have class patch issues try prefixing the arguments with com.sojern 


###Assumptions

- You can have a major, minor, patch etc as "0" . e.g "0.0.0.0"
- You can't have a 0 followed by a number in any part of the version unless prefixed with a
  number greater than 0. E.g valid = 0.100.10, invalid 00.00.01 ( all parts )
- There's no mention of limiting to strict semantic versioning (Major.Minor.Patch). The biggest example 
  was 1.2.9.9.9.9 so I have limited both the separate number sequences once they are split to an array
  to have max length 6 and the version string size to min 1 and max 20. this is to prevent excessive
  memory usage etc. E.g 1.1.1.1.1.1 is a valid version, 1.1.1.1.1.1.2 is not valid.
- You can only have numbers separated by dots.  

##Future Considerations

- Current validation on string passed only limited to taking in numbers
and dots and a minimum length of 1 and max of 20. This would be updated to accommodate bigger versions 
when allowing for more than just numbers and dots . A limit should always be considered as we use a regex on the string
and we would be vulnerable to denial of service attacks if a huge string was passed.  
- Exception handling to be improved by creating specific exception
classes. 
- The main class was out of scope but if time permitted I would have cleaned it up.
- I have kept the two classes separate as they do not need to necessarily know about each other
  and the VersionValidator could be potentially used elsewhere to just merely check if a version
  is valid and not necessarily needed to be compared. 

 
 
 
