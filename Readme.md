# Rock Paper Scissor
Implementation by Peter Mucha

## Starting
* Start by either executing `mvn exec:java` or by:
```
mvn package & java -jar target\rps-0.0.1-SNAPSHOT.jar <gametype>
```
### Game Types
  * `lizard` -- you can play `Rock,Paper,Scissor,Spock,Lizard`.
  * `rps11` -- play [rps11](http://www.umop.com/rps11.htm)
  
default mode is classical, so only `Rock, Paper and Scissor`.

## Features
* Console UI (but can be extended to work with another ui)
* Different Game-Rules (Classic, Lizard-Spock-Extension)
* multiple rounds 
* striking AI