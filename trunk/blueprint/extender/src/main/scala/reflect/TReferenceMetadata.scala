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

class ReferenceMetadataBuilder extends ServiceReferenceMetadataBuilder  with   TBuilder[TReferenceMetadata]{
  private [this] var   timeOut:Long =_



 

  def withTimeOut (timeOut:Long)={
    this.timeOut=timeOut
    this
  }

 
  override def validate (){}


  override def apply()={
    new ReferenceMetadata_ (
      id ,
      activation,
      dependsOns,
      availability,
      interface,
      componentName,
      filter,
      referenceListeners,
      timeOut)
  }
  
}