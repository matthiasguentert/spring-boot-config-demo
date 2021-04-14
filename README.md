## Description

This spring boot project holds demos to show-case the usage of profiles and basic docker usage. 

## Switching between profiles 

To activate set the environment variable accordingly (PowerShell example). 

```PowerShell
$env:spring.profiles.active={prod,dev0,sprint,...}
```

You can also override specific values e.g.

```PowerShell
$env:message=this is prod (env)
```

## Docker cheet sheet

```Bash
# Build image
docker build -t myorg/myapp:dev .

# Peek into image
docker run -ti --entrypoint /bin/sh myorg/myapp:dev

# Run image
docker run -p 8080:8080 myorg/myapp

# Peek into running container
docker exec -ti container_name /bin/sh
```

## Mixed notes 

* More than a single profile at a time can be active 
* If no profile is specified (`spring.profiles.active=null`) the default one will be used 

## Further reading

### Configuration
* https://reflectoring.io/spring-boot-profiles/
* https://zetcode.com/springboot/profile/#:~:text=A%20profile%20is%20a%20set%20of%20configuration%20settings.,profile-specific%20property%20files%20only%20for%20the%20specified%20profile.

### Docker
* https://spring.io/guides/gs/spring-boot-docker/
* https://spring.io/guides/topicals/spring-boot-docker/#:~:text=%20Spring%20Boot%20Docker%20%201%20A%20Basic,there%20are%20some%20tweaks%20you%20might...%20More%20