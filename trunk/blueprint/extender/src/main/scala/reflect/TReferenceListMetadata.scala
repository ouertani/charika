package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.ReferenceListMetadata
import scala.collection.JavaConversions._
import scala.collection.Iterable
trait TReferenceListMetadata extends ReferenceListMetadata with TServiceReferenceMetadata


class ReferenceListMetadata_ (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener],
  memberType : MemberType)extends ServiceReferenceMetadata_(id ,
                                                            activation,
                                                            dependsOns,
                                                            availability ,
                                                            interface,
                                                            componentName,
                                                            filter,
                                                            referenceListeners) with TReferenceListMetadata {
  override def getMemberType()=memberType.intValue
}