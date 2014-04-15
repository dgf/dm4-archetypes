# DeepaMehta 4 Archetypes

A collection of archetypes to create
[DeepaMehta 4](http://github.com/jri/deepamehta)
specific [Maven](http://maven.apache.org) plugins.

## Requirements

only Maven 3.0.5 or higher

## Usage

### interactive artifact creation

The interactive mode just requires the catalog URL to start.

```sh
# start interactive creation mode
mvn archetype:generate -DarchetypeCatalog=http://m2.deepamehta.de
```

### create a plugin artifact from an archetype

In general you have to specify all required Maven artifact properties and the archetype to use.

```sh
# create artifact
mvn archetype:generate \
-DgroupId=<your-plugin-group> \
-DartifactId=<your-plugin-artifact> \
-Dversion=<your-artifact-version> \
-DarchetypeCatalog=http://m2.deepamehta.de \
-DarchetypeGroupId=de.deepamehta.archetypes \
-DarchetypeArtifactId=<archetype-to-use> \
-DarchetypeVersion=4.2 \
-DinteractiveMode=false
```

You can find a concrete example in each sub-module documentation.

### run DeepaMehta from within your artifact directory

Each plugin that is created from an archetype inherits the OSGi configuration of the DeepaMehta plugin parent.
This includes the complete setup of Pax Runner that enables your to start it directly
in the project with a single Maven call.

```sh
# locally install your plugin
cd <your-plugin-artifact>
mvn install

# start a fresh DeepaMehta instance
mvn pax:run
```

To get a hot-deploy environment please have a look at the
[SetupforHot-Deployment](https://trac.deepamehta.de/wiki/PluginDevelopmentGuide#SetupforHot-Deployment)
section of the [PluginDevelopmentGuide](https://trac.deepamehta.de/wiki/PluginDevelopmentGuide)
