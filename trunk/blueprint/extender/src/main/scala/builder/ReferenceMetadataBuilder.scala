package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
class ReferenceMetadataBuilder {
  this :ServiceReferenceMetadataBuilder with ComponentMetadataBuilder =>
  private [this] var   _timeOut:Long =_





  def withTimeOut (timeOut:Long)={
    _timeOut=timeOut
    this
  }




def build()={
    new ReferenceMetadata (
      _id ,
      _activation,
      _dependsOns,
      _availability,
      _interface,
      _componentName,
      _filter,
      _referenceListeners,
      _timeOut)
  }

}