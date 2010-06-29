package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
import scala.collection.JavaConversions._

class ServiceMetadataBuilder {


  this : ComponentMetadataBuilder =>
  private [this] var   _serviceComponent:TTarget=_
  private [this] var   _interfaces:List[String]=_
  private [this] var   _autoExport:AutoExport=_
  private [this] var   _serviceProperties: List[TMapEntry]=_
  private [this] var   _ranking: Int=_
  private [this] var   _registrationListeners:Seq[TRegistrationListener]=_



  def withServiceComponent (serviceComponent:TTarget)= {
    _serviceComponent=serviceComponent
    this
  }

  def withInterfaces (interfaces:List[String])= {
    _interfaces=interfaces
    this
  }
  def withInterfaces (interface:String)= {
    _interfaces=_interfaces:+interface
    this
  }
  def withAutoExport (autoExport:AutoExport)= {
    _autoExport=autoExport
    this
  }
  def withServiceProperties (serviceProperties: List[TMapEntry])= {
    _serviceProperties
    this
  }
  def withRanking (ranking: Int)= {
    _ranking=ranking
    this
  }
  def withRegistrationListeners (registrationListeners:Seq[TRegistrationListener])= {
    _registrationListeners=registrationListeners
    this
  }
  def withRegistrationListener (registrationListener:TRegistrationListener)= {
    _registrationListeners=_registrationListeners:+registrationListener
    this
  }



  def build={
    new ServiceMetadata(
  _id ,
  _activation,
  _dependsOns,
  _serviceComponent,
  _interfaces,
  _autoExport,
  _serviceProperties,
  _ranking,
  _registrationListeners )
  }
}