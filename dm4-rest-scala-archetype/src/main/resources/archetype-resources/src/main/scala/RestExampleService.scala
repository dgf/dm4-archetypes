#set( $symbol_dollar = '$' )
package ${package};

import de.deepamehta.core.{RelatedTopic, ResultSet}
import de.deepamehta.core.osgi.PluginActivator
import de.deepamehta.core.service.event.AllPluginsActiveListener

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces, WebApplicationException}

import java.util.logging.Logger

@Path("/example")
class RestExampleService extends PluginActivator with AllPluginsActiveListener {

  private val log: Logger = Logger.getLogger(classOf[RestExampleService].getName)

  def allPluginsActive() = {
    log.info("create some Notes and open /example/notes to check this service")
  }

  /**
   * @return all <code>Note</code> topics as result set
   */
  @GET
  @Path("/notes")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def listAllNoteTitles: ResultSet[RelatedTopic] = {
    log.info("return all Note topics")
    try {
      val topics: ResultSet[RelatedTopic] = dms.getTopics("dm4.notes.note", true, 0, null)
      log.finest("Note topics: \n" + topics.toJSON)
      topics
    } catch {
      case e: Exception => {
        log.warning(e.getMessage)
        throw new WebApplicationException(e)
      }
    }
  }
}
