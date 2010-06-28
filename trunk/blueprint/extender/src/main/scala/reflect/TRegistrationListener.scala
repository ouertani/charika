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

import org.osgi.service.blueprint.reflect.RegistrationListener

trait TRegistrationListener extends RegistrationListener

sealed class RegistrationListener_ (
  listenerComponent:TTarget, 
  registrationMethod:String,
  unregistrationMethod:String
)extends TRegistrationListener {

  override def getListenerComponent()=listenerComponent
  override def getRegistrationMethod()=registrationMethod
  override def getUnregistrationMethod()=unregistrationMethod

}


class RegistrationListenerBuilder {

  private [this] var    listenerComponent:TTarget=_
  private [this] var  registrationMethod:String=_
  private [this] var   unregistrationMethod:String=_

  def withListenerComponent(listenerComponent:TTarget)={
    this.listenerComponent=listenerComponent
    this
  }
  def withRegistrationMethod(registrationMethod:String)={
    this.registrationMethod=registrationMethod
    this
  }
  def withUnregistrationMethod(unregistrationMethod:String)={
    this.unregistrationMethod=unregistrationMethod
    this
  }
  
}