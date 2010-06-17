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

class Property (name:Option[String], ref: Option[String], value: Option[String],component: Option[Component]) {
  require(name != null)
  require (ref != null)
  require (value != null)
  require (component != null)



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
