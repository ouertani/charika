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

import org.osgi.service.blueprint.reflect.BeanMetadata
import scala.collection.JavaConversions._


trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata



sealed class BeanMetadata_(
  id :String , 
  activation:Activation,
  dependsOns:List[String],
  className:String,
  initMethod:String ,
  destroyMethod:String,
  beanArguments:List[TBeanArgument],
  beanProperties:List[TBeanProperty],
  factoryMethod:String,
  factoryComponent:TTarget,
  scope:Scope) extends ComponentMetadata_(id , activation , dependsOns) with TBeanMetadata {

  override def  getClassName()=className
  override def  getInitMethod()=initMethod
  override def  getDestroyMethod()=destroyMethod
  override def  getArguments()=beanArguments
  override def  getProperties()=beanProperties
  override def  getFactoryMethod()=factoryMethod
  override def  getFactoryComponent()=factoryComponent
  override def  getScope()=scope.stringValue

 
}

class BeanMetadataBuilder  extends ComponentMetadataBuilder{
 
  private [this] var className:String=null
  private [this] var initMethod:String =null
  private [this] var  destroyMethod:String=null
  private [this] var  beanArguments:List[TBeanArgument]=List()
  private [this] var  beanProperties:List[TBeanProperty]=List()
  private [this] var factoryMethod:String=null
  private [this] var factoryComponent:TTarget=null
  private [this] var scope:Scope=Singleton



  
  def withClassName(className:String)={
    this.className=className
    this
  }
  def withInitMethod( initMethod:String )={
    this.initMethod=initMethod
    this
  }
  def withDestroyMethod(destroyMethod:String)={
    this.destroyMethod=destroyMethod
    this
  }
  def withBeanArguments(beanArguments:List[TBeanArgument])={
    this.beanArguments=beanArguments
    this
  }

  def withBeanArgument(beanArgument:TBeanArgument)={
    this.beanArguments = beanArguments:+beanArgument
    this
  }


  def withBeanProperties(beanProperties:List[TBeanProperty])={
    this.beanProperties=beanProperties
    this
  }

   def withBeanProperty(beanProperty:TBeanProperty)={
    this.beanProperties = this.beanProperties:+beanProperty
    this
  }


  def withFactoryMethod(factoryMethod:String)={
    this.factoryMethod=factoryMethod
    this
  }
  def withFactoryComponent(factoryComponent:TTarget)={
    this.factoryComponent=factoryComponent
    this
  }
  def withScope(scope:Scope)={
    this.scope=scope
    this
  }


}