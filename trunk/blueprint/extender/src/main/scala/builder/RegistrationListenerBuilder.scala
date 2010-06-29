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
class RegistrationListenerBuilder  {

  private [this] var _listenerComponent:TTarget=_
  private [this] var _registrationMethod:String=_
  private [this] var _unregistrationMethod:String=_

  def withListenerComponent(listenerComponent:TTarget)={
    _listenerComponent=listenerComponent
    this
  }
  def withRegistrationMethod(registrationMethod:String)={
    _registrationMethod=registrationMethod
    this
  }
  def withUnregistrationMethod(unregistrationMethod:String)={
    _unregistrationMethod=unregistrationMethod
    this
  }



  def build={
    new RegistrationListener (
      _listenerComponent,
      _registrationMethod,
      _unregistrationMethod)
  }
}
