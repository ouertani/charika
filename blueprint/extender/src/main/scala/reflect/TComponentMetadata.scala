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

trait TComponentMetadata extends ComponentMetadata with TNonNullMetadata

abstract class ComponentMetadata_(id :String , activation:Activation , dependsOns:List[String]) extends TComponentMetadata {
  override def getId()=id
  override def getActivation()=activation.intValue
  override def getDependsOn()=dependsOns
}



abstract class ComponentMetadataBuilder extends ABuilder with TFluentBuilder[TComponentMetadata]{
  
  private [reflect] var _id :String=_
  private [reflect] var _activation:Activation=_
  private [reflect] var _dependsOns:List[String]=_


  def withId(id :String )= {
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
  def withDependsOn( dependsOn:String)={
    _dependsOns=_dependsOns :+dependsOn
    this
  }





}