# DeepaMehta 4 Archetypes

a collection of archetypes to create a
[DeepaMehta 4](http://github.com/jri/deepamehta)
specific maven plugin

## Usage

until there is a public repository with this collection available
you have to build it for your own

### locally install the archetype collection

```shell
# clone repository
git clone http://github.com/dgf/dm4-archetypes
cd dm4-archetypes

# build archetypes and install them to your local Maven repository
mvn install
```

### create a plugin artifact from an archetype

in general you have to specify the archetype to use
and all required maven artifact properties

```shell
mvn archetype:generate \
-DgroupId=<your-plugin-group> \
-DartifactId=<your-plugin-artifact> \
-Dversion=<your-artifact-version> \
-DarchetypeGroupId=de.deepamehta.archetypes \
-DarchetypeArtifactId=<archetype-to-use> \
-DarchetypeVersion=4.1 \
-DinteractiveMode=false
```

you find a concrete example call in each sub-module documentation

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
