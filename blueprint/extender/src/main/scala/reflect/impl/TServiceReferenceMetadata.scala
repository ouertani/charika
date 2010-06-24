package net.dikka.charika.blueprint
package reflect.impl

import reflect.impl.ServiceReferenceMetadata

trait TServiceReferenceMetadata  extends ServiceReferenceMetadata with TComponentMetadata

case class ServiceReferenceMetadataImpl( availability : Availability,
                                        getInterface:String,
                                        componentName:String,
                                        getFilter:String,
                                        getReferenceListeners:Seq[ReferenceListener] ) extends TServiceReferenceMetadata