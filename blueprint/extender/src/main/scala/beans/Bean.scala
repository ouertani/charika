/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint.extender.impl
package beans


case class Callback(initMethod:Option[String],
                    destroyMethod:Option[String])

case class Construction (clazz:Option[String],
                         factoryMethod: Option[String],
                         factoryRef:Option[String])

case class ConstructionParam( dependsOn:List[String]=List(),
                             arguments :List[Argument] =List(),
                             propertys : List[Property]=List())


case class Bean (id:String,
                 activation:Activation,
                 scope:Scope=Singleton ,
                 dependsOn:List[String]=List() ,
                 arguments :List[Argument]=List() ,
                 propertys : List[Property]=List(),
                 clazz:Option[String],
                 factoryMethod: Option[String],
                 factoryRef:Option[String],
                 initMethod:Option[String],
                 destroyMethod:Option[String] ) extends Component(id, activation, dependsOn) {

  def this(id:String,
           activation:Activation,
           scope:Scope ,
           constructionParam: ConstructionParam,
           construction :Construction,
           callback :Callback){  this(id,
                                      activation,
                                      scope,
                                      constructionParam.dependsOn,
                                      constructionParam.arguments,
                                      constructionParam.propertys,
                                      construction.clazz, construction.factoryMethod, construction.factoryRef,
                                      callback.initMethod, callback.destroyMethod)  }
 

  require(id != null, "Id must not be null!")
  require(activation != null, "Activation must not be null!")
  require(scope != null, "Scope must not be null!")
  require(dependsOn != null, "DependsOn must not be null!")
  require(propertys != null, "propertys must not be null!")
  require(propertys != null, "propertys must not be null!")
  require(clazz != null, "Class must not be null!")
  require(factoryMethod != null, "FactoryMethod must not be null!")
  require(factoryRef != null, "FactoryRef must not be null!")
  require(initMethod != null, "InitMethod must not be null!")
  require(destroyMethod != null, "DestroyMethod must not be null!")

  /*
   * The destroyMethod must not be set when the scope is prototype.
   The activation must not be set to eager if the bean also has prototype scope.
   The following combinations of arguments are valid, all other combinations are invalid:
   • className
   • className, factory-method
   • factory-ref, factory-method
   */

  if(scope == Prototype) {
    require (destroyMethod isEmpty,"The destroyMethod must not be set when the scope is prototype.")      
    require (activation == Lazy, "The activation must not be set to eager if the bean also has prototype scope.")
  }

  if(clazz isDefined) {
    require((factoryRef  isEmpty), "Invalid combination" )
  }

  if(factoryMethod isDefined) {
    require(xor( factoryRef isDefined ,  clazz isDefined ) , "Invalid combination" )
  }
  require ((clazz isDefined ) || (factoryMethod isDefined) || (factoryRef isDefined ),"Invalid combination" )






}
