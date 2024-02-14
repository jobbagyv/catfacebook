# Cat Facebook (under construction)

The goal of this miniproject is to create a website for the uploading and rating of cat images.

It uses Spring boot 3.x as backend, Angular 17 for frontend, and authenticates via OAUTH2 using keycloak

# Running the project
Run the keycloak in the docker folder using docker-compose, then just start it up using Application.java.

This keycloak contains a "test" user with "test" password, for testing.

# Some notable mentions about the structure

For database, default spring jpa is used, however, fetching of lazy objects (and special queries)
are solved via QueryDSL.

Objects are mapped to DTOs using mapstruct.

Angular also has keycloak authentication wired. This is done using an interceptor. For details, see app.config.ts.

