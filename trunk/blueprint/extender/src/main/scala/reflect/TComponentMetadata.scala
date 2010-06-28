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
class ComponentMetadataBuilder {

  private [this] var id :String=_
  private [this] var activation:Activation=_
  private [this] var dependsOns:List[String]=_

  def withId(id :String )= {
    this.id=id
  }
  def withActivation(activation:Activation)={
    this.activation= activation
    this
  }
  def withDependsOns( dependsOns:List[String])={
    this.dependsOns=dependsOns
    this
  }
  def withDependsOn( dependsOn:String)={
    this.dependsOns=dependsOns :+dependsOn
    this
  }
}