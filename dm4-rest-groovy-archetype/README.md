# DeepaMehta 4 REST Groovy Archetype

template with a REST service written in Groovy

## Usage

create a simple REST plugin

```sh
mvn archetype:generate \
-DgroupId=de.deepamehta.archetypes.test \
-DartifactId=simple-rest-groovy-plugin \
-Dversion=1.0-SNAPSHOT \
-DarchetypeCatalog=http://ci.deepamehta.de \
-DarchetypeGroupId=de.deepamehta.archetypes \
-DarchetypeArtifactId=dm4-rest-groovy-archetype \
-DarchetypeVersion=4.1 \
-DinteractiveMode=false
```