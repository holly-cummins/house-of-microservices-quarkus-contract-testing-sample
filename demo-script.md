# Microservices House Demo Notes

## Pre-demo prep

- Print these instructions!
- Run `./demo-clean` script, which will delete the contract tests 

### Machine tidy
- Pause any backup software
- Turn on Mac Focus
- Quit email and other messaging tools

### Display
- Make terminal and IDE fonts huge
- Make browser font huge
- Reduce screen resolution to 1920 x 1080

### Environment setup

- Sort out web conference green screen if necessary
- Get an iPad with a timer running

### IDE setup 

Open two IDEs, one for Java and one for JavaScript. Idea and WebStorm is ideal, but Eclipse and VSCode also works well. 

Open a terminal within each IDE (or two OS terminals). 

## The demo 

1. Show both sets of code. Explain the scenario: the simplest possible distributed application, with a JavaScript front-end and a Java back-end. Dividing the Java application into more microservices would increase the number of moving parts to demo, and not necessarily teach us anything more.

2. Briefly tour the code.
3. Start the back-end with `mvn quarkus:dev`. Visit http://localhost:8080/resident to show the json which is passed to the front end. 
4. Start the front end with `npm start`. Visit http://localhost:3000 to show the app. 
   > You may need to build it first with `npm install`. On a Mac M1 you may also first have to run `npm i @pact-foundation/pact-node`, then `npm install`.
5. Back to the code, and explain the model of a `Resident` which includes several body parts, that may evolve at different paces.
6. Show the tests. Because of course there are tests, we're responsible developers. 
   1. Run the back-end tests in IntelliJ (they're also running continuously in Quarkus)
   2. Create a new terminal and run `npm run test`
7. Refactor `bff/src/main/java/sample/resident/Resident.java`! Torso's a big word, do we even know what that means? In IntelliJ, use `shift-F6` to rename `getTorso` to `getStomach`. 
8. Sense check. Run the Java tests (all working), run the JavaScript tests, all working. 
9. Visit the web page again. It's all going to work, right, because the tests all worked?
10. Oh no, we're missing a stomach! What's going on? Check the json at http://localhost:8080/resident, see that the json has changed.
11. Stop the auto-test running.
12. Use the git history to recreate the contract tests. Rollback `ResidentTable.contract.test.js` from the git history. Show the `frontend/src/ResidentTable.test.js` and then compare the two tests. Explain the differences are because Pact acts both as a mock and a validator of all possible values.
13. Restart the tests. Show how a json contract has appeared in `frontend/pact/pacts/app-house.json`
14. The test should pass, we're the consumer, we made assumptions about how the provider should behave. But are those assumptions correct? Now is when we find out! 
15. Copy the pact to share it to the provider: `cp pact/pacts/* ../bff/src/test/resources/pacts/`. Explain that normally this would be done by automatically checking it into source control or using a broker. 
16. Restore the Java test from history. 
17. Run the Java tests, show the failure, explain how it could be fixed by negotiating a contract change or changing the source code. 

## A really long demo

Write the full contract test on both sides, using `ResidentTable.test.js` as a base. 	Wrap in pactWith, base URL, etc. 
Go outside in - add pactWith, confirm compile, add before, add interaction to provider and base URL, etc

Break the logic in the front-end, show the pact is a handy mock.

Add the state back, show how to do regexes
