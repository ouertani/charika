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

import scala.collection.Iterable
import scala.collection.JavaConversions._

import org.osgi.service.blueprint.reflect.ServiceReferenceMetadata

trait TServiceReferenceMetadata  extends ServiceReferenceMetadata with TComponentMetadata

class ServiceReferenceMetadata_ (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],  
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener]
)extends ComponentMetadata_ (id ,
                             activation,
                             dependsOns)
    with TServiceReferenceMetadata {
    
  
  override def getAvailability()=availability.intValue
  override def getInterface() =interface
  override def getComponentName()=componentName
  override def getFilter()=filter
  override def getReferenceListeners()=referenceListeners
}


class ServiceReferenceMetadataBuilder extends /*ComponentMetadataBuilder*/ TFluentBuilder[TServiceReferenceMetadata] {

  this:ComponentMetadataBuilder =>

  protected [reflect] var   _availability : Availability=_
  protected [reflect] var   _interface:String=_
  protected [reflect] var   _componentName:String=_
  protected [reflect] var   _filter:String=_
  protected [reflect] var   _referenceListeners:Iterable[TReferenceListener]=_


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

  def validate (){}


  def apply()={
    new ServiceReferenceMetadata_ (
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
