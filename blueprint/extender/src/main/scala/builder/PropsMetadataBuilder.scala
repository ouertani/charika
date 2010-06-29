package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
class PropsMetadataBuilder {
  private [this] var _entries:List[TMapEntry]=_

 def withEntries(entries:List[TMapEntry])={
    this._entries=entries
    this
  }

  def withEntry(entry:TMapEntry)={
    this._entries::=entry
    this
  }




 def build()={
    new PropsMetadata( _entries)
  }
}
