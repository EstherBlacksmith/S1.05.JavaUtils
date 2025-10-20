#In order to execute the code on this repository by command line, 
#copy the following code:
#compile all the classes inside the package
javac -d out src/main/java/JavaUtilsExercises_lvl_1_2/*.java
#copy the properties file in order to be accessible
cp src/main/resources/config.properties out/
#ejecute the the compilated classes and follow the menu that will appears in your console
java -cp out JavaUtilsExercises_lvl_1_2.Main
