package net.dikka.charika.blueprint
package builder

import reflect._
import reflect.impl._

class ComponentMetadataBuilder extends TDefault  {


  protected [this] var _id :String=_
  protected [this] var _activation:Activation=_
  protected [this] var _dependsOns:List[String]=_



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

  def build():TComponentMetadata ={
    new ComponentMetadata(_id,_activation,_dependsOns)
  }

}
