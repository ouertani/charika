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

	