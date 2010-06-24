package net.dikka.charika.blueprint
package reflect


import org.osgi.service.blueprint.reflect.ServiceReferenceMetadata

trait TServiceReferenceMetadata  extends ServiceReferenceMetadata with TComponentMetadata

case class ServiceReferenceMetadataImpl( availability : Availability,
                                        getInterface:String,
                                        componentName:String,
                                        getFilter:String,
                                        getReferenceListeners:Seq[TReferenceListener] ) extends TServiceReferenceMetadata