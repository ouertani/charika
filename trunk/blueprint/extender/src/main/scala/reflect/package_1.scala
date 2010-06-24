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


import org.osgi.service.blueprint.container.ComponentDefinitionException
import scala.xml.Node

package object  reflect {
  def need(b :Boolean, msg : String) {
    if(!b) throw new ComponentDefinitionException("Unknown element " + msg);
  }

  trait ComponentParser [T] {
    def  parseElement( node:Node):T
  }



  implicit def toScope(scope: String): Scope={
    if(scope== null) Singleton
    if(scope=="singleton")  Singleton
    else if(scope =="prototype") Prototype
    else if (scope isEmpty) Singleton
    else throw new IllegalArgumentException("invalid scope text")
  }



  implicit def toActivation(activation: String): Activation = {
    if(activation ==null ) Eager
    if(activation=="lazy") Lazy
    else if(activation=="eager") Eager
    else if(activation isEmpty) Eager
    else throw new IllegalArgumentException("invalid activation text")
  }
}
