# DeepaMehta 4 Migration Plugin Archetype

Template with a declarative JSON migration that contains

 * a composite topic type with a simple name and a HTML description
 * and some topic instances
 * a image resource as icon

## Usage

create a simple migration plugin

```shell
mvn archetype:generate \
-DgroupId=de.deepamehta.archetype.test \
-DartifactId=simple-migration-plugin \
-Dversion=1.0-SNAPSHOT \
-DarchetypeGroupId=de.deepamehta.archetypes \
-DarchetypeArtifactId=dm4-migration-plugin-archetype \
-DarchetypeVersion=4.1 \
-DinteractiveMode=false
```
