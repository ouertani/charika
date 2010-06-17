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





import net.dikka.charika.blueprint.extender.impl.beans._
import net.dikka.charika.blueprint.extender.impl.beans.Activation

package object parser {

  implicit def toActivation(activation: String):Activation = {
    Activation.unapply(activation) get
  }

  implicit def toScope(scope :String) :Scope = {
    Scope.unapply(scope) get
  }

  implicit def toOptionOfString(string :String):Option[String]= {
    if(string==null || string.isEmpty) None
    else Some(string)
  }
}
