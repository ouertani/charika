package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect._
import scala.xml.Node

trait TServiceReferenceMetadata extends ServiceReferenceMetadata with TComponentMetadata {
  val availability:Availability
  val interface:Option[String]
  val componentName:Option[String]
  val filter:Option[String]

  override def int getAvailability()=availability.value

	
  override def	 getInterface():String=interface.getOrElse(null)

	
 override def	 getComponentName():String:componentName.getOrElse(null)

	
  override def	 getFilter()=filter.getOrElse(null)

	
	//Collection<ReferenceListener> getReferenceListeners();
}
case class ServiceReference {

}
