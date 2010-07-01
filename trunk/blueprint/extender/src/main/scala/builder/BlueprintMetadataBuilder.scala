package net.dikka.charika.blueprint
package builder


import reflect._
import reflect.impl._

trait TBlueprintMetadataBuilder {
  val blueprintMetadataBuilder : BlueprintMetadataBuilder
  //TODO Convertor
  
  class BlueprintMetadataBuilder extends Function0[TBlueprintMetadata] {
    private [this] var _default:TDefault=_
    private [this] var _metadatas:List[TMetadata]=_


    def withDefault(default:TDefault)={
      _default=default
      this
    }
    def withMetaDatas( metaDatas:List[TMetadata]) ={
      _metadatas=metaDatas
      this
    }
    def withMetaData(metaData:TMetadata)={
      _metadatas::=metaData
      this
    }
    
    def apply()={
      BlueprintMetadata(_default,_metadatas)
    }
  }
}
