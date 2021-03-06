# qw\_portal\_services

[![Build Status](https://travis-ci.org/NWQMC/qw_portal_services.svg?branch=postgres)](https://travis-ci.org/NWQMC/qw_portal_services)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/34585f7c07cf4a39a7c691ec31c78820)](https://www.codacy.com/manual/usgs_wma_dev/qw_portal_services?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=NWQMC/qw_portal_services&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/NWQMC/qw_portal_services/branch/master/graph/badge.svg)](https://codecov.io/gh/NWQMC/qw_portal_services)

Internet Of Water (IOW) Lookup Service

## Local Configuration
This application is configured to be run as a jar. It can also be run using the command ``` mvn spring-boot:run ``` in the project root directory.
 
To run in a development environment, create an application.yml file in
the project root directory containing the following (shown are example values):

```$yml
DATABASE_ADDRESS: <127.0.0.1>
DATABASE_PORT: <5435>
DATABASE_NAME: <wqp_db>
READ_ONLY_USERNAME: <wqp_user>
READ_ONLY_PASSWORD: <changeMe>
SCHEMA_NAME: <wqp>

SERVER_PORT: <8082>
SERVER_CONTEXT_PATH: </Codes>

ROOT_LOG_LEVEL: INFO

CODES_SERVICE_URL: <http://localhost:8082/Codes/>
DEPLOY_NAME: <Water Quality Portal Codes>
```

## Testing
This project contains JUnit 5 tests. Maven can be used to run them (in addition to the capabilities of your IDE).

To run the unit tests of the application use:

```shell
mvn package
```

To additionally start up a Docker database and run the integration tests of the application use:

```shell
mvn verify -DTESTING_DATABASE_PORT=5437 -DTESTING_DATABASE_ADDRESS=localhost -DTESTING_DATABASE_NETWORK=iow
```
