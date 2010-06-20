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

case class Property (name:Option[String], ref: Option[String], value: Option[String],component: Option[Component]) {
  require(name != null,"Name must not be null")
  require (ref != null, "ref must not be null")
  require (value != null,"value must not be null")
  require (component != null, "component must not be null")



  /*
   The following attributes/elements are mutually exclusive
   • ref
   • value
   • An inlined object value
   */

  require (xor3(ref isDefined, value isDefined , component isDefined), """ The following attributes/elements are mutually exclusive
   • ref
   • value
   • An inlined object value""")
}


class PropertyBuilder {
  private[this] var  name:Option[String]=None
  private[this] var  ref: Option[String]=None
  private[this] var  value: Option[String]=None
  private[this] var  component: Option[Component]=None


  def withName(name:String ) = {this.name=name;this}
  def withRef(ref:String)={this.ref=ref;this}
  def withComponent(component : Component){this.component=component;this}
  
  def build = Property(name =name, ref =ref, value= value,component= component)
}
