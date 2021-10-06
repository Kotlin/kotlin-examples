Sample project for using [Jest](https://facebook.github.io/jest/) unit testing framework,
by using its bindings from the [kodando-jest](https://github.com/danfma/kodando).
 
This time, we will configure jest to execute the tests, so that you could:

* Run the tests using jest (from node) at the shell;
* Run the tests using Idea to get a nice view of the running tests.

PS.: I'm using the `kotlin-dce-js` plugin because it unwraps all the dependencies in one directory, maybe someone could
remove that.

# WHAT CAN YOU DO?

At the directory root:

* Resolve dependencies: `yarn install`
* Build kotlin using gradle: `yarn build`
* Execute the tests: `yarn test`
* Configure Idea to run the tests using the Jest task... 

By the way, you can use `npm` too, if you don't like `yarn`. 