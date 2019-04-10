$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/Features/MyTest.feature");
formatter.feature({
  "name": "Search weather in Zaragoza city",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify search button is ok",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Open the Google Chrome and launch the application Weather API",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Enter the Username and Password",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "The temperature of the city of Zaragoza is displayed",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});