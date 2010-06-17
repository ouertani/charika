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


sealed trait Activation { val   activation:Int  }
case object Lazy extends Activation {val activation=2 }
case object Eager extends Activation{ val activation=1}
