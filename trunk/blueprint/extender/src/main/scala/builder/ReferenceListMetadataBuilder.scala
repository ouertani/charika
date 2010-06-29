package net.dikka.charika.blueprint
package builder

import reflect._
import reflect.impl._
class ReferenceListMetadataBuilder {
  this:ServiceReferenceMetadataBuilder  with ComponentMetadataBuilder=>
  private [this] var  _memberType : MemberType=_

  def withMemberType(memberType : MemberType)= {
    _memberType=memberType
    this
  }



  def build()={
    new ReferenceListMetadata (
      _id ,
      _activation,
      _dependsOns,
      _availability,
      _interface,
      _componentName,
      _filter,
      _referenceListeners,
      _memberType)
  }
}
