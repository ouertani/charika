package net.dikka.charika.blueprint
package reflect.impl

import reflect._
import scala.collection.JavaConversions._

class PropsMetadata( entries:List[TMapEntry]) extends TPropsMetadata {
  override def getEntries()= entries
}
