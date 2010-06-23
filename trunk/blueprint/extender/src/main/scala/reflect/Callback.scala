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


case class Callback(initMethod:Option[String], destroyMethod:Option[String]){
  need(initMethod != null, "InitMethod must not be null!")
  need(destroyMethod != null, "DestroyMethod must not be null!")
}

class CallbackBuilder {
  private[this] var initMethod:Option[String]=None
  private[this] var  destroyMethod:Option[String]=None


  def withInitMethod(initMethod:String)={
    this.initMethod=initMethod
    this
  }

  def withDestroyMethod(destroyMethod:String)={
    this.destroyMethod=destroyMethod
    this
  }
  def build =Callback(initMethod, destroyMethod)


}
