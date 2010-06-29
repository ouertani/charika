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
import scala.xml.Node


trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata



class BeanMetadata_(
  id :String ,
  activation:Activation,
  dependsOns:List[String],
  className:Option[String],
  initMethod:Option[String] ,
  destroyMethod:Option[String],
  beanArguments:List[TBeanArgument],
  beanProperties:List[TBeanProperty],
  factoryMethod:Option[String],
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
object BeanMetadataBuilder{
  val INVALID_COMBINATIONS="""The following combinations of arguments are valid, all other combinations are invalid:
• className
• className, factory-method
• factory-ref, factory-method
"""
}


class BeanMetadataBuilder /*extends ComponentMetadataBuilder*/ {

  private [reflect] var _componentMetadata: TComponentMetadata=_
  private [reflect] var _className:Option[String]=None
  private [reflect] var _initMethod:Option[String] =None
  private [reflect] var _destroyMethod:Option[String]=None
  private [reflect] var _beanArguments:List[TBeanArgument]=List()
  private [reflect] var _beanProperties:List[TBeanProperty]=List()
  private [reflect] var _factoryMethod:Option[String]=None
  private [reflect] var _factoryComponent:TTarget=null
  private [reflect] var _scope:Scope=_



  def withComponentMetadata(componentMetadata: TComponentMetadata)={
    _componentMetadata=componentMetadata
    this
  }
  
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
  def withBeanArguments(beanArguments:List[TBeanArgument])={
    _beanArguments=beanArguments
    this
  }

  def withBeanArgument(beanArgument:TBeanArgument)={
    _beanArguments = _beanArguments:+beanArgument
    this
  }


  def withBeanProperties(beanProperties:List[TBeanProperty])={
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
  def withFactoryComponent(factoryComponent:TTarget)={
    _factoryComponent=factoryComponent
    this
  }
  def withScope(scope:Scope)={
    _scope=scope
    this
  }

  def validate (){
    if( this._scope == Prototype) {
      need(_destroyMethod isEmpty ,"The destroyMethod must not be set when the scope is prototype. ")
      need (_componentMetadata.activation != Eager ,"The activation must not be set to eager if the bean also has prototype scope.")
    }
    if(_className isDefined) {
      need (_factoryComponent == null ,BeanMetadataBuilder.INVALID_COMBINATIONS)

      if(_factoryComponent != null) {
        need(_factoryMethod isDefined,BeanMetadataBuilder.INVALID_COMBINATIONS)
      }
    }
    need((_className isDefined) || (_factoryComponent != null) ||( _factoryMethod isDefined ),BeanMetadataBuilder.INVALID_COMBINATIONS )
  }


  def build()={
    new BeanMetadata_( _componentMetadata.id ,
                      _componentMetadata.activation,
                      _componentMetadata.dependsOns,
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

class BeanMetadataParser extends  ComponentMetadataParser {

  override def  apply( node:Node):TBeanMetadata = {

   val componentMetadata:TComponentMetadata = new ComponentMetadataParser()(node)


    new BeanMetadataBuilder().withComponentMetadata(componentMetadata).build



  }
   
}
  

