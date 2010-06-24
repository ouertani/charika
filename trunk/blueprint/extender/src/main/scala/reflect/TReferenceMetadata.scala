package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.ReferenceMetadata

trait TReferenceMetadata extends ReferenceMetadata with TTarget with TServiceReferenceMetadata


class ReferenceMetadata_ (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],  
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener],
  timeOut:Long) extends ServiceReferenceMetadata_ ( id ,
                                                   activation,
                                                   dependsOns,
                                                   availability ,
                                                   interface,
                                                   componentName,
                                                   filter,
                                                   referenceListeners)with TReferenceMetadata {
  override def getTimeout()=timeOut
}

