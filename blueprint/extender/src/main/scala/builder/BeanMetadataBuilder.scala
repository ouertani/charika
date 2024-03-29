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



  
class BeanMetadataBuilder (default:TDefault)
extends ComponentMetadataBuilder [BeanMetadataBuilder] (default) with Function0[TBeanMetadata]  {

 
   
  final protected [this] var _className:Option[String]=None
  final protected [this] var _initMethod:Option[String] =None
  final protected [this] var _destroyMethod:Option[String]=None
  final protected [this] var _beanArguments:Seq[TBeanArgument]=List()
  final protected [this] var _beanProperties:Seq[TBeanProperty]=List()
  final protected [this] var _factoryMethod:Option[String]=None
  final protected [this] var _factoryComponent:Option[TTarget]=None
  final protected [this] var _scope:Scope=_


  override  def self():BeanMetadataBuilder = {this}

  def withClassName(className:String)={
    _className=className
    this
  }



  def withInitMethod( initMethod:String )={
    _initMethod=initMethod
    this
  }
  def withDestroyMethod(destroyMethod:String)={
    _destroyMethod=destroyMethod
    this
  }
  def withBeanArguments(beanArguments:Seq[TBeanArgument])={
    _beanArguments=beanArguments
    this
  }

  def withBeanArgument(beanArgument:TBeanArgument)={
    _beanArguments = _beanArguments:+beanArgument
    this
  }


  def withBeanProperties(beanProperties:Seq[TBeanProperty])={
    _beanProperties=beanProperties
    this
  }

  def withBeanProperty(beanProperty:TBeanProperty)={
    _beanProperties = _beanProperties:+beanProperty
    this
  }


  def withFactoryMethod(factoryMethod:String)={
    _factoryMethod=factoryMethod
    this
  }
  def withFactoryComponent(factoryComponent:Option[TTarget])={
    _factoryComponent=factoryComponent
    this
  }
  def withScope(scope:Scope)={
    _scope=scope
    this
  }


  def withScope(scope:String)={
    scope match {
      case null => _scope =Singleton
      case "" => _scope =Singleton
      case "singleton" => _scope = Singleton
      case "prototype" =>  _scope = Prototype
      case e => error ( e +" invalid scope text")
    }
     
    this
  }

  def validate (){
    if( this._scope == Prototype) {
      need(_destroyMethod isEmpty ,"The destroyMethod must not be set when the scope is prototype. ")
      need (_activation != Eager ,"The activation must not be set to eager if the bean also has prototype scope.")
    }
    if(_className isDefined) {
      need (_factoryComponent isEmpty ,BeanMetadataBuilder.INVALID_COMBINATIONS)

      if(_factoryComponent isDefined) {
        need(_factoryMethod isDefined,BeanMetadataBuilder.INVALID_COMBINATIONS)
      }
    }
    need((_className isDefined) || (_factoryComponent isDefined) ||( _factoryMethod isDefined ),BeanMetadataBuilder.INVALID_COMBINATIONS )
  }

  override  def apply()={
    validate
    validateArguments
    new BeanMetadata(_id ,
                     _activation,
                     _dependsOns,
                     _className,
                     _initMethod,
                     _destroyMethod,
                     _beanArguments,
                     _beanProperties,
                     _factoryMethod,
                     _factoryComponent,
                     _scope)
  }



  private [this] def validateArguments(){
    if(!(_beanArguments isEmpty)){
      val (indexed, notIndexed ) =_beanArguments span (_.index isDefined)
      need ((indexed isEmpty) ||( notIndexed isEmpty) ,"Either all arguments have a specified index or none have a specified index.")
      if(notIndexed isEmpty ) {
        indexed.map(x=>need (x.index.get >= 0 ,"If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments."))
        for ( i<- 0 to (indexed.size -1) ){
          need (indexed.find(_.index.get == i) isDefined,"If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.")
        }
      }
    }
  }
}
object BeanMetadataBuilder{
  val INVALID_COMBINATIONS="""The following combinations of arguments are valid, all other combinations are invalid:
• className
• className, factory-method
• factory-ref, factory-method
"""
}

