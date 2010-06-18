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

case class Bean (id:String,
                 activation:Activation,
                 scope:Scope ,
                 constructionParam: ConstructionParam,
                 construction :Construction,
                 callback :Callback) extends Component(id, activation, constructionParam.dependsOn) {

  require(id != null, "Id must not be null!")
  require(activation != null, "Activation must not be null!")
  require(scope != null, "Scope must not be null!")

  if(scope == Prototype) {
    require (callback.destroyMethod isEmpty,"The destroyMethod must not be set when the scope is prototype.")
    require (activation == Lazy, "The activation must not be set to eager if the bean also has prototype scope.")
  }
}
