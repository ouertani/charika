package net.dikka.charika.blueprint
package reflect.impl
import reflect._
class ReferenceMetadata (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener],
  timeOut:Long) extends ServiceReferenceMetadata ( id ,
                                                   activation,
                                                   dependsOns,
                                                   availability ,
                                                   interface,
                                                   componentName,
                                                   filter,
                                                   referenceListeners)with TReferenceMetadata {
  override def getTimeout()=timeOut
}
