package net.dikka.charika.blueprint
package reflect.impl

import reflect._

 class ReferenceListMetadata (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener],
  memberType : MemberType)extends ServiceReferenceMetadata(id ,
                                                            activation,
                                                            dependsOns,
                                                            availability ,
                                                            interface,
                                                            componentName,
                                                            filter,
                                                            referenceListeners) with TReferenceListMetadata {
  override def getMemberType()=memberType.intValue
}
