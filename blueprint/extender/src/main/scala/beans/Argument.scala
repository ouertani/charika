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

case class Argument (index: Option[Int], 
                     tipe:Option[String],
                     ref:Option[String],
                     value:Option[String],
                     component: Option[Component]) {
  require (index!=null, "index must not be null")
  require (tipe!=null, "type must not be null")
  require (ref !=null,"ref must not be null")
  require (value != null,"value must not be null")
  require (component != null,"component must not be null")



 
  /*
   The following attributes and elements are mutually exclusive:
   • ref
   • value
   • An inlined object value
   */
  require (xor3(ref isDefined, value isDefined, component isDefined),""" The following attributes and elements are mutually exclusive:
   • ref
   • value
   • An inlined object value""")
}

class ArgumentBuilder(){

  private [this] var index: Option[Int]=None
  private [this] var tipe:Option[String]=None
  private [this] var ref:Option[String]=None
  private [this] var value:Option[String]=None
  private [this] var component: Option[Component]=None



  
  def withIndex(index: Int)={
    this.index=Some(index)    
    this}

  def withType(tipe: String)={
    this.tipe=tipe
    this
  }

  def withRef(ref:String)={
    this.ref=ref    
    this}
  def withValue(value:String)={
    this.value=value   
    this}
  def withComponent(component:Component)={
    this.component=(component)
    this}


  def build  = Argument(index,tipe,ref,value,component)

  def + (that :ArgumentBuilder) = build ::that.build ::Nil

}
