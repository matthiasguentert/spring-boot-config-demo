## Description

This spring boot project holds demos to show-case the usage of profiles. 

## Switching between profiles 

To activate set the environment variable accordingly (PowerShell example). 

```PowerShell
$env:spring.profiles.active={prod,dev0,sprint,...}
```

You can also override specific values e.g.

```PowerShell
$env:message=this is prod (env)
```

## Mixed notes 

* More than a single profile at a time can be active 
* If no profile is specified (`spring.profiles.active=null`) the default one will be used 