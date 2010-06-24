package net.dikka.charika.blueprint
package reflect.impl
import org.osgi.service.blueprint.reflect._

trait TComponentMetadata extends ComponentMetadata with TNonNullMetadata

case class IComponentMetadata(id :String , activation:Activation , dependsOns:List[String]) extends TComponentMetadata