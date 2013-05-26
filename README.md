# DeepaMehta 4 Archetypes

a collection of archetypes to create a
[DeepaMehta 4](http://github.com/jri/deepamehta)
specific maven plugin

## Usage

### create a plugin artifact from an archetype

in general you have to specify the archetype to use
and all required maven artifact properties

```shell
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
and you can also use the interactive mode by only providing the catalog

```shell
# start interactive creation mode
mvn archetype:generate -DarchetypeCatalog=http://ci.deepamehta.de
```

### run DeepaMehta from within your artifact directory

```shell
# locally install your plugin
cd <your-plugin-artifact>
mvn install

# start a fresh DeepaMehta instance
mvn pax:run
```

to get a hot-deploy environment please have a look at the
[SetupforHot-Deployment](https://trac.deepamehta.de/wiki/PluginDevelopmentGuide#SetupforHot-Deployment)
section of the [DeepaMehta 4](http://github.com/jri/deepamehta)
[PluginDevelopmentGuide](https://trac.deepamehta.de/wiki/PluginDevelopmentGuide)
