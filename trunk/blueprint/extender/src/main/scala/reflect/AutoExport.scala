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

sealed trait AutoExport {
  val intValue:Int
}
case object AutoExportDisabled extends AutoExport {
  override val intValue= 1
}

case object AutoExportInterfaces extends AutoExport {
  override val intValue= 2
}

case object AutoExportClassHierarchy  extends AutoExport{
  override val intValue= 3
}

case object AutoExportAllClasses extends AutoExport{
  override val intValue= 4
} 

	