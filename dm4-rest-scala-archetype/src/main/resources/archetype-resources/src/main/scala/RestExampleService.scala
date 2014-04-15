#set( $symbol_dollar = '$' )
package ${package};

import de.deepamehta.core.RelatedTopic
import de.deepamehta.core.osgi.PluginActivator
import de.deepamehta.core.service.event.AllPluginsActiveListener

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

import java.util.logging.Logger

import scala.collection.JavaConverters._

@Path("/example/scala")
class RestExampleService extends PluginActivator with AllPluginsActiveListener {

  private val log: Logger = Logger getLogger classOf[RestExampleService].getName

  @Override
  def allPluginsActive() {
    log info "create some Notes and open /example/scala/notes to check this service"
  }

  /**
   * @return list of all <code>Note</code> titles
   */
  @GET
  @Path("/notes")
  @Produces(Array("application/json"))
  def listAllNoteTitles: java.util.Set[String] = {
    log info "Scala returns all Note titles"
    val topics = dms.getTopics("dm4.notes.note", true, 0).asScala
    val titles = for (t: RelatedTopic <- topics.toSet) yield {
      log finest t.toJSON.toString
      t.getCompositeValue.getString("dm4.notes.title", "n/a")
    }
    titles.asJava
  }
}
