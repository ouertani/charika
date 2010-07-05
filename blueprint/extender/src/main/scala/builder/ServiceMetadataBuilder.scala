/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v. 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint
package builder


import reflect._
import reflect.impl._
import scala.collection.JavaConversions._


  
class ServiceMetadataBuilder[T <: ServiceMetadataBuilder[T] ] (default:TDefault)
extends ComponentMetadataBuilder[ServiceMetadataBuilder[T]](default) with Function0[TServiceMetadata]{

  protected [this] var   _serviceComponent:TTarget=_
  protected [this] var   _interfaces:List[String]=_
  protected [this] var   _autoExport:AutoExport=_
  protected [this] var   _serviceProperties: List[TMapEntry]=_
  protected [this] var   _ranking: Int=_
  protected [this] var   _registrationListeners:Seq[TRegistrationListener]=_



  def withServiceComponent (serviceComponent:TTarget):T= {
    _serviceComponent=serviceComponent
    this.asInstanceOf[T]
  }

  def withInterfaces (interfaces:List[String]):T= {
    _interfaces=interfaces
    this.asInstanceOf[T]
  }
  def withInterfaces (interface:String):T= {
    _interfaces=_interfaces:+interface
    this.asInstanceOf[T]
  }
  def withAutoExport (autoExport:AutoExport):T= {
    _autoExport=autoExport
    this.asInstanceOf[T]
  }
  def withServiceProperties (serviceProperties: List[TMapEntry]):T= {
    _serviceProperties
    this.asInstanceOf[T]
  }
  def withRanking (ranking: Int):T= {
    _ranking=ranking
    this.asInstanceOf[T]
  }
  def withRegistrationListeners (registrationListeners:Seq[TRegistrationListener]):T= {
    _registrationListeners=registrationListeners
    this.asInstanceOf[T]
  }
  def withRegistrationListener (registrationListener:TRegistrationListener):T= {
    _registrationListeners=_registrationListeners:+registrationListener
    this.asInstanceOf[T]
  }



  override def apply={
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
