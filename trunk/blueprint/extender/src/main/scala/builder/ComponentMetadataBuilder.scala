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

class ComponentMetadataBuilder  extends Function0[TComponentMetadata]{ 


  final protected [this] var _default:TDefault=new Default
  final protected [this] var _id :Option[String]=None
  final protected [this] var _activation:Activation=Eager
  final protected [this] var _dependsOns:List[String]=List()


  def withId(id :String )={
    _id=id
    this
  }
 
  def withActivation(activation:Option[String])={   
    activation match {
      case Some("eager") =>  _activation = Eager
      case Some("lazy") =>  _activation = Lazy
      case Some(e) => error ( e +" invalid activation text")
      case None => 
    }
     this
  }



  def withDependsOns( dependsOns:String)={
    if(dependsOns !=null && ! (dependsOns isEmpty) ) {
      _dependsOns=dependsOns.split(" ").toList
    }
    this
  }

  def apply()={
    new ComponentMetadata(_id,_activation,_dependsOns)
  }

}
