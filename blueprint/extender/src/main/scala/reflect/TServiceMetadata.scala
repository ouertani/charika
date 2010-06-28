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
package reflect

import org.osgi.service.blueprint.reflect.ServiceMetadata
import scala.collection.JavaConversions._

trait TServiceMetadata extends ServiceMetadata with TComponentMetadata


class ServiceMetadata_(
  id :String , 
  activation:Activation ,
  dependsOns:List[String],
  serviceComponent:TTarget,
  interfaces:List[String],
  autoExport:AutoExport,
  serviceProperties: List[TMapEntry],
  ranking: Int,
  registrationListeners:Seq[TRegistrationListener] ) extends ComponentMetadata_(id  , activation, dependsOns) with TServiceMetadata {



  override def getServiceComponent()=getServiceComponent
  override def  getInterfaces()=getInterfaces
  override def  getAutoExport()=autoExport.intValue
  override def getServiceProperties()=serviceProperties
  override def getRanking()=ranking
  override def getRegistrationListeners()=registrationListeners
}


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
    new ServiceMetadata_(
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