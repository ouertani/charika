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

import org.osgi.service.blueprint.reflect.ReferenceMetadata

trait TReferenceMetadata extends ReferenceMetadata with TTarget with TServiceReferenceMetadata


sealed class ReferenceMetadata_ (
  id :String ,
  activation:Activation ,
  dependsOns:List[String],  
  availability : Availability,
  interface:String,
  componentName:String,
  filter:String,
  referenceListeners:Iterable[TReferenceListener],
  timeOut:Long) extends ServiceReferenceMetadata_ ( id ,
                                                   activation,
                                                   dependsOns,
                                                   availability ,
                                                   interface,
                                                   componentName,
                                                   filter,
                                                   referenceListeners)with TReferenceMetadata {
  override def getTimeout()=timeOut
}

class ReferenceMetadataBuilder extends /* ServiceReferenceMetadataBuilder with */   TFluentBuilder[TReferenceMetadata]{
  this :ServiceReferenceMetadataBuilder with ComponentMetadataBuilder =>
  private [reflect] var   _timeOut:Long =_





  def withTimeOut (timeOut:Long)={
    _timeOut=timeOut
    this
  }


  override def validate (){}


  override def apply()={
    new ReferenceMetadata_ (
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