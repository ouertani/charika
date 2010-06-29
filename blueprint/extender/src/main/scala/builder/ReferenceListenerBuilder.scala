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
class ReferenceListenerBuilder {

  private [this] var _listenerComponent:TTarget=_
  private [this] var _bindMethod:String=_
  private [this] var _unbindMethod:String=_



  def withListenerComponent  (listenerComponent:TTarget)={
    _listenerComponent=listenerComponent
    this
  }
  def withBindMethod   (bindMethod:String)={
   _bindMethod=bindMethod
    this
  }
  def withUnbindMethod   (unbindMethod:String)={
    _unbindMethod=unbindMethod
    this
  }
  def build()={
    new ReferenceListener(
      _listenerComponent,
      _bindMethod,
      _unbindMethod
    )
  }
}
