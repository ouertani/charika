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
package net.dikka.charika.blueprint.extender.impl


import org.osgi.service.blueprint.container.ComponentDefinitionException

package object beans {
  
  def xor3(x: Boolean, y: Boolean, z : Boolean): Boolean = (x || y || z ) && !(x && y) && !(x && z) && !(y && z) && ! (x && y && z)


  def xor(x: Boolean, y: Boolean): Boolean = (x || y) && !(x && y)



  implicit def toOption[T](t:T):Option[T]={if(t!=null) Some(t) else None}



  implicit def toConstructionParam(cpb:ConstructionParamBuilder)=cpb.build
  implicit def toArgumentBuilder(ab:ArgumentBuilder)=ab.build
  implicit def toCallback(cb :CallbackBuilder)=cb.build
  implicit def toConstruction(cb:ConstructionBuilder)=cb.build
  implicit def toProperty(pb:PropertyBuilder)=pb.build

  def need(b :Boolean, msg : String) {
    if(!b) throw new ComponentDefinitionException("Unknown element " + msg);
  }
 
}
