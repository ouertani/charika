package net.dikka.charika.blueprint
package reflect

import scala.collection.Iterable
import scala.collection.JavaConversions._

import org.osgi.service.blueprint.reflect.ServiceReferenceMetadata

trait TServiceReferenceMetadata  extends ServiceReferenceMetadata with TComponentMetadata

class ServiceReferenceMetadata_ (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],  
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener] )
  extends ComponentMetadata_ (id , activation, dependsOns)
  with TServiceReferenceMetadata {
    
  
  override def getAvailability()=availability.intValue
  override def getInterface() =interface
  override def getComponentName()=componentName
  override def getFilter()=filter
  override def getReferenceListeners()=referenceListeners
}