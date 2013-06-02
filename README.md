# DeepaMehta 4 Archetypes

a collection of archetypes to create
[DeepaMehta 4](http://github.com/jri/deepamehta)
specific [Maven](http://maven.apache.org/download.cgi) plugins

## Requirements

only Maven 3.0.4 or higher

## Usage

### interactive artifact creation

you can use the interactive mode by only providing the catalog URL

```sh
# start interactive creation mode
mvn archetype:generate -DarchetypeCatalog=http://ci.deepamehta.de
```

### create a plugin artifact from an archetype

in general you have to specify the archetype to use
and all required Maven artifact properties

```sh
# create artifact
mvn archetype:generate \
-DgroupId=<your-plugin-group> \
-DartifactId=<your-plugin-artifact> \
-Dversion=<your-artifact-version> \
-DarchetypeCatalog=http://ci.deepamehta.de \
-DarchetypeGroupId=de.deepamehta.archetypes \
-DarchetypeArtifactId=<archetype-to-use> \
-DarchetypeVersion=4.1 \
-DinteractiveMode=false
```

you find a concrete example call in each sub-module documentation

### run DeepaMehta from within your artifact directory

```sh
# locally install your plugin
cd <your-plugin-artifact>
mvn install

# start a fresh DeepaMehta instance
mvn pax:run
```

to get a hot-deploy environment please have a look at the
[SetupforHot-Deployment](https://trac.deepamehta.de/wiki/PluginDevelopmentGuide#SetupforHot-Deployment)
section of the [PluginDevelopmentGuide](https://trac.deepamehta.de/wiki/PluginDevelopmentGuide)
