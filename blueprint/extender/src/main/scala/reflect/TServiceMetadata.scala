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


class ServiceMetadataBuilder extends ComponentMetadataBuilder with  TBuilder[TServiceMetadata]{
 
  private [this] var   serviceComponent:TTarget=_
  private [this] var   interfaces:List[String]=_
  private [this] var   autoExport:AutoExport=_
  private [this] var   serviceProperties: List[TMapEntry]=_
  private [this] var   ranking: Int=_
  private [this] var   registrationListeners:Seq[TRegistrationListener]=_



  def withServiceComponent (serviceComponent:TTarget)= {
    this.serviceComponent=serviceComponent
    this
  }

  def withInterfaces (interfaces:List[String])= {
    this.interfaces=interfaces
    this
  }
  def withInterfaces (interface:String)= {
    this.interfaces=interfaces:+interface
    this
  }
  def withAutoExport (autoExport:AutoExport)= {
    this.autoExport=autoExport
    this
  }
  def withServiceProperties (serviceProperties: List[TMapEntry])= {
    this.serviceProperties
    this
  }
  def withRanking (ranking: Int)= {
    this.ranking=ranking
    this
  }
  def withRegistrationListeners (registrationListeners:Seq[TRegistrationListener])= {
    this.registrationListeners=registrationListeners
    this
  }
  def withRegistrationListener (registrationListener:TRegistrationListener)= {
    this.registrationListeners=registrationListeners:+registrationListener
    this
  }

  override def validate (){}


  override def apply()={
    new ServiceMetadata_(
  id ,
  activation,
  dependsOns,
  serviceComponent,
  interfaces,
  autoExport,
  serviceProperties,
  ranking,
  registrationListeners )
  }
}