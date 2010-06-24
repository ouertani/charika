package net.dikka.charika.blueprint
package reflect
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._

trait TComponentMetadata extends ComponentMetadata with TNonNullMetadata

abstract class ComponentMetadata_(id :String , activation:Activation , dependsOns:List[String]) extends TComponentMetadata {
  override def getId()=id
  override def getActivation()=activation.intValue
  override def getDependsOn()=dependsOns
}