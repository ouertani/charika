package net.dikka.charika.blueprint
package reflect.impl

import reflect._

//TODO add convertor
case class BlueprintMetadata  (
  default:TDefault,
  metaData:List[TMetadata]
)extends TBlueprintMetadata