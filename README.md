## README

The following is a quick guide to preparing the Library Management System web application.

Prerequisites
-------------

* jdk 1.7
* mysql 5.6
* maven 3.0.5

Use [homebrew](http://mxcl.github.com/homebrew/) to install the stuff you need.


Usual build tasks
-----------------

* Compile source/tests, run the unit tests, make a war
`mvn clean package`

* Determine code coverage: `mvn clean cobertura:cobertura`.
The coverage reports can be viewed at `./target/site/cobertura/index.html`

* Start server
`mvn jetty:run`

* Report updates on dependencies
`mvn versions:display-dependency-updates`

ThoughtWorks, Inc &copy; 2013
