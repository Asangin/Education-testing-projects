# Use report portal for storing test results

> The aim of this project is to evaluate the ReportPortal service for generating test reports.

[Documentation](https://reportportal.io/)

## Set up Report Portal locally

Note! o utilize this project, you must install ReportPortal on your local machine by following
the [guide.](https://reportportal.io/installation) I am using Docker, and deployment will take some time. Once
ReportPortal is deployed, it needs to be configured for the Java project using
this [guide.](https://github.com/reportportal/agent-java-junit5#step-4---configuring-reportportal) And enter your
ReportPortal project properties into the [reportportal.properties](src/test/resources/reportportal.properties) file.
