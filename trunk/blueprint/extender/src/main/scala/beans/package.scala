/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint.extender.impl


package object beans {

  sealed trait Availability
  case object Mandatory extends Availability
  case object Optional extends Availability



  object Activation {
    def unapply(activation: String): Option[Activation] = {

      if(activation ==null ) Some(Eager)
      if(activation=="lazy") Some(Lazy)
      else if(activation=="eager") Some(Eager)
      else None
    }
  }
  sealed trait Activation {
    val   activation:Int

                          
  }
  case object Lazy extends Activation {val activation=2 }
  case object Eager extends Activation{ val activation=1}

  object Scope {
    def unapply(scope: String): Option[Scope]={
      if(scope=="singleton")  Some(Singleton)
      else if(scope =="prototype") Some (Prototype)
      else None
    }
  }
  sealed trait Scope 
  case object Singleton extends Scope
  case object Prototype extends Scope


  abstract class Component (id:String, activation :Activation=Eager, dependsOn:List[String])




  def xor3(x: Boolean, y: Boolean, z : Boolean): Boolean = (x || y || z ) && !(x && y) && !(x || z) && !(y || z) && ! (x && y && z)


  def xor(x: Boolean, y: Boolean): Boolean = (x || y) && !(x && y)

 
}
