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


trait TComponentMetadataBuilder { this : TDefault =>

  val componentMetadataBuilder:ComponentMetadataBuilder
  
  class ComponentMetadataBuilder  extends Function0[TComponentMetadata]{ this : TDefault =>


    final protected [this] var _id :String=_
    final protected [this] var _activation:Activation=_
    final protected [this] var _dependsOns:List[String]=_



    def withId(id :String ) = {
      _id=id
      this
    }
    def withActivation(activation:Activation):ComponentMetadataBuilder={
      _activation=activation
      this
    }
    def withActivation(activation:String):ComponentMetadataBuilder={
      if((activation == null) || (activation isEmpty)){
        withActivation( defaultActivation)
      }
      else {
        activation match {
          case "eager" =>  withActivation( Eager)
          case "lazy" =>  withActivation( Lazy)
          case e => error ( e +" invalid activation text")
        }
      }

    }


    def withDependsOns( dependsOns:List[String])={
      _dependsOns=dependsOns
      this
    }
    def withDependsOns( dependsOns:String)={
      if(dependsOns !=null && ! (dependsOns isEmpty) )
        _dependsOns=dependsOns.split(" ").toList
      this
    }

    def withDependsOn( dependsOn:String)={
      _dependsOns=_dependsOns :+dependsOn
      this
    }

    def apply()={
      new ComponentMetadata(_id,_activation,_dependsOns)
    }

  }
}