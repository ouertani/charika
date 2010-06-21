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
package net.dikka.charika.blueprint.extender.impl
package beans




case class Construction (clazz:Option[String], factoryMethod: Option[String], factoryRef:Option[String]){
  need(clazz != null, "Class must not be null!")
  need(factoryMethod != null, "FactoryMethod must not be null!")
  need(factoryRef != null, "FactoryRef must not be null!")

  /*
   The destroyMethod must not be set when the scope is prototype.
   The activation must not be set to eager if the bean also has prototype scope.
   The following combinations of arguments are valid, all other combinations are invalid:
   • className
   • className, factory-method
   • factory-ref, factory-method
   */
  if(clazz isDefined) {
    need((factoryRef  isEmpty), "Invalid combination" )
  }

  if(factoryMethod isDefined) {
    need(xor( factoryRef isDefined ,  clazz isDefined ) , "Invalid combination" )
  }
  need ((clazz isDefined ) || (factoryMethod isDefined) || (factoryRef isDefined ),"Invalid combination" )
}

class ConstructionBuilder {
  private[this] var   clazz:Option[String]=None
  private[this] var   factoryMethod:Option[String]=None
  private[this] var   factoryRef:Option[String]=None


  def withClass(clazz :String)= {
    this.clazz =clazz
    this
  }


  def withFactoryMethod(factoryMethod:String)={
    this.factoryMethod=factoryMethod
    this
  }

  def withFactoryRef(factoryRef:String)={
    this.factoryRef=factoryRef
    this
  }
  def build=Construction(clazz,factoryMethod,factoryRef)
}
