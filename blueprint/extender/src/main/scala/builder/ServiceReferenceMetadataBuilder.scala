package net.dikka.charika.blueprint
package builder


import reflect._
import reflect.impl._
import scala.collection.JavaConversions._


class ServiceReferenceMetadataBuilder {

  this:ComponentMetadataBuilder =>

  protected [this] var   _availability : Availability=_
  protected [this] var   _interface:String=_
  protected [this] var   _componentName:String=_
  protected [this] var   _filter:String=_
  protected [this] var   _referenceListeners:Iterable[TReferenceListener]=_


  def withAvailability(availability:Availability)={
    _availability=availability
    this
  }
  def withInterface(interface:String)={
    _interface=interface
    this
  }
  def withComponentName(componentName:String)={
    _componentName=componentName
    this
  }
  def withFiler(filter :String)={
    _filter=filter
    this
  }
  def withreerenceListeners( referenceListeners:Iterable[TReferenceListener])={
    _referenceListeners=referenceListeners
    this
  }




  def build={
    new ServiceReferenceMetadata (
      _id ,
      _activation,
      _dependsOns,
      _availability ,
      _interface,
      _componentName,
      _filter,
      _referenceListeners)
  }
}
