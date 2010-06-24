package net.dikka.charika.blueprint
package reflect



import org.osgi.service.blueprint.reflect.PropsMetadata
import scala.collection.JavaConversions._

trait TPropsMetadata extends PropsMetadata with TNonNullMetadata

class PropsMetadata_( entries:List[TMapEntry]) extends TPropsMetadata {
  override def getEntries()= entries
}