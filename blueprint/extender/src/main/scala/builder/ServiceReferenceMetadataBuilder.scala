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

trait TServiceReferenceMetadataBuilder { this:TComponentMetadataBuilder =>

 
  
  val serviceReferenceMetadataBuilder:ServiceReferenceMetadataBuilder
  
  class ServiceReferenceMetadataBuilder extends Function0[TServiceReferenceMetadata] {

    this:ComponentMetadataBuilder =>

    final protected [this] var   _availability : Availability=_
    final protected [this] var   _interface:String=_
    final protected [this] var   _componentName:String=_
    final protected [this] var   _filter:String=_
    final protected [this] var   _referenceListeners:Iterable[TReferenceListener]=_


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




    def apply={
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
}
