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

class ComponentMetadataBuilder [T <: ComponentMetadataBuilder[T]] (default:TDefault)  extends Function0[TComponentMetadata]{


  final protected [this] var _id :Option[String]=None
  final protected [this] var _activation:Activation=default.defaultActivation
  final protected [this] var _dependsOns:List[String]=List()



  def self():T = {
    this.asInstanceOf[T]
  }

  def withId(id :String ):T={
    _id=id
    self
  }
 
  def withActivation(activation:Option[String]):T={
    activation match {
      case Some("eager") =>  _activation = Eager
      case Some("lazy") =>  _activation = Lazy
      case Some(e) => error ( e +" invalid activation text")
      case None => 
    }
    self
  }



  def withDependsOns( dependsOns:String):T={
    if(dependsOns !=null && ! (dependsOns isEmpty) ) {
      _dependsOns=dependsOns.split(" ").toList
    }
    self
  }

  def apply()={
    new ComponentMetadata(_id,_activation,_dependsOns)
  }

}
