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

import org.osgi.service.blueprint.reflect.ReferenceListener

trait TReferenceListener extends ReferenceListener

class ReferenceListener_(
  listenerComponent:TTarget,
  bindMethod:String,
  unbindMethod:String
) extends TReferenceListener {

  override def  getListenerComponent()=listenerComponent
  override  def getBindMethod()=bindMethod
  override def getUnbindMethod()=unbindMethod
}



class ReferenceListenerBuilder {
  private [this] var  listenerComponent:TTarget=_
  private [this] var bindMethod:String=_
  private [this] var  unbindMethod:String=_



  def withListenerComponent  (listenerComponent:TTarget)={
    this.listenerComponent=listenerComponent
    this
  }
  def withBindMethod   (bindMethod:String)={
    this.bindMethod=bindMethod
    this
  }
  def withUnbindMethod   (unbindMethod:String)={
    this.unbindMethod=unbindMethod
    this
  }

}