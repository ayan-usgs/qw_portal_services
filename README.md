# qw\_portal\_services
Water Quality Portal (WQP) Lookup Service

## Local Configuration
This application is configured to be run in a Tomcat container. The development configuration (context.xml and swaggerServices.yml) can be copied to your local Tomcat. Required configuration is:

```
    <Environment name="qwPortalServices/displayHost" type="java.lang.String" value="localhost:8443"/>
    <Environment name="qwPortalServices/displayPath" type="java.lang.String" value="/qw_portal_services"/>
    <Environment name="swaggerServicesConfigFile" type="java.lang.String" value="${catalina.base}/conf/swaggerServices.yml"/>"
    <Resource name="jdbc/WQPQW" 
        .
        .
        .
    />
```

## Automated Testing
This application has two flavors of automated tests: unit tests (\*Test.java) and integration tests (\*IT.java) which require a database.

### Testing with an IDE
An application-it.yml file needs to be created in the project root directory in order to run the integration tests. It should contain:

```
wqpCoreUrl: <<url for ci database>>
wqpCoreUsername: <<database username>>
wqpCorePassword: <<database password>>
```

### Testing with Maven
The unit tests can be run in a terminal with the maven command ```mvn test``` in the project's root directory.

The integration tests can be run in a terminal with the maven command ```mvn verify``` in the project's root directory.
When run this way, configuration information will be pulled from the maven setting.xml file. It will need to contain the following profile:
```
  <profile>
    <id>it</id>
    <properties>
      <wqpCoreUrl><<url for ci database>></wqpCoreUrl>
      <wqpCoreUsername><<database username>></wqpCoreUsername>
      <wqpCorePassword><<database password>></wqpCorePassword>
    </properties>
  </profile>
```
