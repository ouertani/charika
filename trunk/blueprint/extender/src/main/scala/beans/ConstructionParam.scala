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

case class ConstructionParam( dependsOn:List[String], arguments : List[Argument],  propertys :  List[Property]) {
  require(dependsOn != null, "DependsOn must not be null!")
  require(arguments != null, "arguments must not be null!")
  require(propertys != null, "propertys must not be null!")

  val t =arguments.map(_.index).partition(_.isDefined)

  if( t._1.size !=0) {
    /*
     * Either all arguments have a specified index or none have a specified index.
     *
     */
    require (t._2.size==0,"Either all arguments have a specified index or none have a specified index.")


    /*
     * If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.
     */
    val l= arguments.map(_.index.get)
    require(l.filter(0>).isEmpty,"index must be >= 0")

    l.sortWith  (_ < _).foldLeft(-1) ((x,y)=> { require(y==x+1,"index run from 0..(n-1), where n is the number of arguments");y})

  }


}

class ConstructionParamBuilder {
  private[this] var  dependsOns:List[String]= _
  private[this] var  arguments : List[Argument]= _
  private[this] var  propertys :  List[Property]= _



  def withDependsOn (dependsOn:String) = {this.dependsOns =  this.dependsOns :::List(dependsOn);this}
  def withArgument (argument:Argument) ={this.arguments =  this.arguments :::List(argument);this}
  def withProperty (property:Property) ={this.propertys =  this.propertys :::List(property);this}

  def build= ConstructionParam(dependsOns,arguments,propertys)
}
