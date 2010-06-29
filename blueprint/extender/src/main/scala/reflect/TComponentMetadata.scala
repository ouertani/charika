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
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._
import scala.xml.Node

trait TComponentMetadata extends ComponentMetadata with TNonNullMetadata {
  val id :String
  val activation:Activation
  val dependsOns:List[String]

}

private [reflect] class ComponentMetadata_(val id :String ,val activation:Activation ,val dependsOns:List[String]) extends TComponentMetadata {
  override def getId()=id
  override def getActivation()=activation.intValue
  override def getDependsOn()=dependsOns
}



class ComponentMetadataBuilder extends ABuilder  {

  
  private [reflect] var _id :String=_
  private [reflect] var _activation:Activation=_
  private [reflect] var _dependsOns:List[String]=_

 
  
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
    new ComponentMetadata_(_id,_activation,_dependsOns)
  }

}

class ComponentMetadataParser extends  AComponentParser {
 override def  apply( node:Node) :TComponentMetadata = new  ComponentMetadataBuilder()
  .withId(node \ "@id" text)
  .withActivation(node \ "@activation" text)
  .withDependsOns(node \ "@depends-on" text)
  .build


  
}